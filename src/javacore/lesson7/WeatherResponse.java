package javacore.lesson7;

public class WeatherResponse {

    private DailyForecasts[] forecasts = new DailyForecasts[5];

    public DailyForecasts[] getForecasts() {
        return forecasts;
    }

    public void setForecasts(DailyForecasts[] forecasts) {
        this.forecasts = forecasts;
    }
}
