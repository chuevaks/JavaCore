package lesson6.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Date;

public class FiveDayForecastResult{
    @JsonProperty("Headline")
    public Headline headline;
    @JsonProperty("DailyForecasts")
    public ArrayList<DailyForecast> dailyForecasts;
}

