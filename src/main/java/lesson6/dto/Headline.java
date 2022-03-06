package lesson6.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString, Root.class); */
public class Headline {
    @JsonProperty("EffectiveDate")
    public Date effectiveDate;
    @JsonProperty("EffectiveEpochDate")
    public int effectiveEpochDate;
    @JsonProperty("Severity")
    public int severity;
    @JsonProperty("Text")
    public String text;
    @JsonProperty("Category")
    public String category;
    @JsonProperty("EndDate")
    public Date endDate;
    @JsonProperty("EndEpochDate")
    public int endEpochDate;
    @JsonProperty("MobileLink")
    public String mobileLink;
    @JsonProperty("Link")
    public String link;
}
