package javacore.lesson7;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
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
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите название города на английском языке (Для выхода нажмите 0)");
            city = scanner.nextLine();
            if (city.equals("0")) {
                System.exit(0);
            }

            try {
                cityCode = detectCityKey(city);
            } catch (IOException e) {
                System.out.println("Город не найден");
                continue;
            }

            try {
                weatherRequest();
            } catch (IOException e) {
                e.printStackTrace();
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
            int temperatureInCelsius = (responseArray[i].temperature.maximum.value +
                    responseArray[i].temperature.minimum.value) / 2 - 34;
            System.out.printf("В городе %s на дату %s ожидается %s, температура - %d\n", city,
                    responseArray[i].date.substring(0, 10), responseArray[i].day.iconPhrase, temperatureInCelsius);
        }
        System.out.println();
    }
}

