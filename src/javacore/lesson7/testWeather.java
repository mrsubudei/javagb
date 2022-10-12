package javacore.lesson7;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class testWeather {
    public static void main(String[] args) {
        try {

            URL url = new URL("http://dataservice.accuweather.com/forecasts/" +
                    "v1/daily/5day/295212?apikey=QRe4ezytVLuPnK3dC0Jw3lZA5CtzCLAp");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            int responseCode = conn.getResponseCode();
            if (responseCode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responseCode);
            } else {
                StringBuilder inline = new StringBuilder();
                Scanner scanner = new Scanner(url.openStream());

                while (scanner.hasNext()) {
                    inline.append(scanner.nextLine());
                }

                String jsonString = inline.toString();

                ObjectMapper objectMapper = new ObjectMapper();
                objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                WeatherResponse weather = objectMapper.readValue(jsonString, WeatherResponse.class);

                System.out.println(weather.getForecasts()[1].getDate());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
