package lesson6.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Glyph {
    @JsonProperty("Icon")
    public int icon;
    @JsonProperty("IconPhrase")
    public String iconPhrase;
    @JsonProperty("HasPrecipitation")
    public boolean hasPrecipitation;
}
