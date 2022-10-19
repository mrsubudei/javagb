package javacore.lesson8;

import java.sql.*;
import java.util.ArrayList;

public class SqlDB {

    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    String createTableQuery = "CREATE TABLE IF NOT EXISTS Weather (\n" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "city TEXT NOT NULL,\n" +
            "localDate TEXT NOT NULL,\n" +
            "weatherText TEXT NOT NULL,\n" +
            "temperature REAL NOT NULL\n" +
            ");";
    String insertWeatherQuery = "INSERT INTO weather (city, localDate, weatherText, temperature) VALUES (?,?,?,?)";

    public static Connection getConnection() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:sqlite:" + "weatherapp.db");
        return conn;
    }

    public void createTableIfNotExists() {
        try (Connection connection = getConnection()) {
            connection.createStatement().execute(createTableQuery);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void clearDb() {
        try (Connection connection = getConnection()) {
            Statement stmt = connection.createStatement();
            stmt.execute("DROP TABLE IF EXISTS Weather");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public int[] saveWeatherData(WeatherResponse weatherData, String city) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement saveWeather = connection.prepareStatement(insertWeatherQuery)) {
            DailyForecasts[] responseArray = weatherData.getForecasts();

            for (int i = 0; i<responseArray.length; i++) {
                double temperatureInCelsius = (weatherData.getForecasts()[i].temperature.maximum.value +
                        weatherData.getForecasts()[i].temperature.minimum.value) / 2 - 34;
                saveWeather.setString(1, city);
                saveWeather.setString(2, weatherData.getForecasts()[i].date);
                saveWeather.setString(3, weatherData.getForecasts()[i].day.iconPhrase);
                saveWeather.setDouble(4, temperatureInCelsius);
                saveWeather.addBatch();
            }
            return saveWeather.executeBatch();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        throw new SQLException("Failure on saving weather object");
    }

    public static ArrayList<SavedFromDB> getDataFromDB()  throws SQLException{
        Connection connection = getConnection();
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM Weather");
        ArrayList<SavedFromDB> arrayList = new ArrayList<>();
        while (resultSet.next()) {
            arrayList.add(new SavedFromDB(resultSet.getInt(1), resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getDouble(5)));
        }
        return arrayList;
    }

    public static void printDataFromDb(ArrayList<SavedFromDB> list){
        for (SavedFromDB c : list) {
            System.out.println(c.getId() + " " + c.getCity() + " " + c.getLocalDate()
            + " " + c.getWeatherText() + " " + c.getTemperature());
        }
        System.out.println();
    }
}
