package lesson7.project;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonRootName(value = "MyDailyWeather")
public class WeatherDailyResponse {
    @JsonProperty("WeatherText")
    private String weatherText;

    @JsonProperty("Temperature")
    private Temperature temperature;

    public String getWeatherText() {
        return weatherText;
    }

    public void setWeatherText(String weatherText) {
        this.weatherText = weatherText;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }
}

@JsonIgnoreProperties(ignoreUnknown = true)
class Temperature {
    @JsonProperty("Metric")
    public Metric metric;
}

@JsonIgnoreProperties(ignoreUnknown = true)
class Metric{
    @JsonProperty("Value")
    public double value;
    @JsonProperty("Unit")
    public String unit;
}