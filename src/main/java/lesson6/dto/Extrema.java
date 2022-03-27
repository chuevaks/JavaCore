package lesson6.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Extrema {
    @JsonProperty("Value")
    public double value;
    @JsonProperty("Unit")
    public String unit;
    @JsonProperty("UnitType")
    public int unitType;
}
