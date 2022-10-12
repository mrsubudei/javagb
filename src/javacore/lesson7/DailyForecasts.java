package javacore.lesson7;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DailyForecasts {
    private String Date;
    @JsonProperty(value = "EpochDate")
    private int E;
    Temperature TemperatureObject;
    Day DayObject;
    Night NightObject;
    ArrayList< Object > Sources = new ArrayList < Object > ();
    private String MobileLink;
    private String Link;


    // Getter Methods

    public String getDate() {
        return Date;
    }

    public float getEpochDate() {
        return E;
    }

    public Temperature getTemperature() {
        return TemperatureObject;
    }

    public Day getDay() {
        return DayObject;
    }

    public Night getNight() {
        return NightObject;
    }

    public String getMobileLink() {
        return MobileLink;
    }

    public String getLink() {
        return Link;
    }

    // Setter Methods

    public void setDate(String Date) {
        this.Date = Date;
    }

    public void setEpochDate(int EpochDate) {
        this.E = EpochDate;
    }

    public void setTemperature(Temperature TemperatureObject) {
        this.TemperatureObject = TemperatureObject;
    }

    public void setDay(Day DayObject) {
        this.DayObject = DayObject;
    }

    public void setNight(Night NightObject) {
        this.NightObject = NightObject;
    }

    public void setMobileLink(String MobileLink) {
        this.MobileLink = MobileLink;
    }

    public void setLink(String Link) {
        this.Link = Link;
    }
}

