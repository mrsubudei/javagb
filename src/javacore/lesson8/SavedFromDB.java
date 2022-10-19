package javacore.lesson8;

public class SavedFromDB {
    private int id;
    private String city;
    private String localDate;
    private String weatherText;
    private double temperature;

    public SavedFromDB(int id, String city, String localDate, String weatherText, double temperature) {
        this.id = id;
        this.city = city;
        this.localDate = localDate;
        this.weatherText = weatherText;
        this.temperature = temperature;
    }
    public int getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public String getLocalDate() {
        return localDate;
    }

    public String getWeatherText() {
        return weatherText;
    }

    public double getTemperature() {
        return temperature;
    }
}
