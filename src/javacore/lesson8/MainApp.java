package javacore.lesson8;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class MainApp {

    private static final OkHttpClient client = new OkHttpClient();
    private static final ObjectMapper objectMapper = new ObjectMapper();
    public static String city = "";
    public static String cityCode = "";

    public static void main(String[] args) {
        runApplication();
    }

    public static void runApplication() {
        ArrayList<SavedFromDB> list;
        Scanner scanner = new Scanner(System.in);
        SqlDB.clearDb();
        boolean emptyDB = true;

        while (true) {
            System.out.println("Для запроса погоды, введите название города на английском языке");
            System.out.println("Для чтения из базы, введите 1");
            System.out.println("Для выхода из программы, введите 0");
            city = scanner.nextLine();

            switch(city) {
                case "0":
                    System.exit(0);
                case "1":
                    if (emptyDB) {
                        System.out.println("База пустая, сделайте запрос");
                        break;
                    }
                    try {
                        list = SqlDB.getDataFromDB();
                        SqlDB.printDataFromDb(list);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    try {
                        cityCode = detectCityKey(city);
                    } catch (IOException e) {
                        System.out.println("Город не найден");
                        break;
                    }

                    try {
                        weatherRequest();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    emptyDB = false;
            }
        }
    }

    public static String detectCityKey(String city) throws IOException {

        HttpUrl detectLocationURL = new HttpUrl.Builder()
                .scheme("http")
                .host("dataservice.accuweather.com")
                .addPathSegment("locations")
                .addPathSegment("v1")
                .addPathSegment("cities")
                .addPathSegment("autocomplete")
                .addQueryParameter("apikey", "QRe4ezytVLuPnK3dC0Jw3lZA5CtzCLAp")
                .addQueryParameter("q", city)
                .build();

        Request request = new Request.Builder()
                .addHeader("accept", "application/json")
                .url(detectLocationURL)
                .build();

        Response response = client.newCall(request).execute();

        if (!response.isSuccessful()) {
            throw new IOException("Невозможно прочесть информацию о городе. " +
                    "Код ответа сервера = " + response.code() + " тело ответа = " + response.body().string());
        }

        String jsonResponse = response.body().string();
        System.out.println("Произвожу поиск города " + city);

        if (objectMapper.readTree(jsonResponse).size() > 0) {
            String cityName = objectMapper.readTree(jsonResponse).get(0).at("/LocalizedName").asText();
            String countryName = objectMapper.readTree(jsonResponse).get(0).at("/Country/LocalizedName").asText();
            System.out.println("Найден город " + cityName + " в стране " + countryName);
        } else throw new IOException("Server returns 0 cities");

        return objectMapper.readTree(jsonResponse).get(0).at("/Key").asText();
    }

    public static void weatherRequest() throws IOException {
        HttpUrl url = new HttpUrl.Builder()
                .scheme("http")
                .host("dataservice.accuweather.com")
                .addPathSegment("forecasts")
                .addPathSegment("v1")
                .addPathSegment("daily")
                .addPathSegment("5day")
                .addPathSegment(cityCode)
                .addQueryParameter("apikey", "QRe4ezytVLuPnK3dC0Jw3lZA5CtzCLAp")
                .build();

        Request request = new Request.Builder()
                .addHeader("accept", "application/json")
                .url(url)
                .build();

        Response response = client.newCall(request).execute();

        WeatherResponse wResponse = objectMapper.readValue(response.body().string(), WeatherResponse.class);
        DailyForecasts[] responseArray = wResponse.getForecasts();

        System.out.println();
        for (int i = 0; i < responseArray.length; i++) {
            double temperatureInCelsius = (responseArray[i].temperature.maximum.value +
                    responseArray[i].temperature.minimum.value) / 2 - 34;
            System.out.printf("В городе %s на дату %s ожидается %s, температура - %.1f\n", city,
                    responseArray[i].date.substring(0, 10), responseArray[i].day.iconPhrase, temperatureInCelsius);
        }
        System.out.println();
        SqlDB db = new SqlDB();
        db.createTableIfNotExists();
        int[] created = new int[5];
        try {
            created = db.saveWeatherData(wResponse, city);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (created.length == 0) {
            System.out.println("Не получилось записать в базу");
        }

    }
}

