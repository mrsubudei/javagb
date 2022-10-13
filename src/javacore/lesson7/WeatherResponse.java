package lesson7.project;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonRootName(value = "MyDailyWeather")
public class WeatherResponse {

    @JsonProperty("DailyForecasts")
    private DailyForecasts[] forecasts;

    public DailyForecasts[] getForecasts() {
        return forecasts;
    }

    public void setForecasts(DailyForecasts[] forecasts) {
        this.forecasts = forecasts;
    }
}

@JsonIgnoreProperties(ignoreUnknown = true)
class DailyForecasts{

    @JsonProperty("Date")
    public String date;

    @JsonProperty("Temperature")
    public Temperature2 temperature;

    @JsonProperty("Day")
    public Day day;

}

@JsonIgnoreProperties(ignoreUnknown = true)
class Temperature2 {
    @JsonProperty("Minimum")
    public Minimum minimum;
    @JsonProperty("Maximum")
    public Maximum maximum;
}

@JsonIgnoreProperties(ignoreUnknown = true)
class Minimum {
    @JsonProperty("Value")
    public int value;
}

@JsonIgnoreProperties(ignoreUnknown = true)
class Maximum {
    @JsonProperty("Value")
    public int value;
}

@JsonIgnoreProperties(ignoreUnknown = true)
class Day {
    @JsonProperty("IconPhrase")
    public String iconPhrase;
}