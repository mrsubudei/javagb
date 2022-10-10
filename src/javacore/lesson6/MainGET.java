package javacore.lesson6;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class MainGET {

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

                //printing answer
                String str = inline.toString();
                int count = -2;
                for (char c : str.toCharArray()) {
                    System.out.print(c);
                    if (c == '{') {
                        System.out.print("\n");
                        for (int i = count; i > 0; i--) {
                            System.out.print(" ");
                        }
                        count++;
                    }
                    if (count == 6) {
                        count = 0;
                    }
                }
                scanner.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}