package lesson6.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Temperature {
    @JsonProperty("Minimum")
    public Extrema minimum;
    @JsonProperty("Maximum")
    public Extrema maximum;
}
