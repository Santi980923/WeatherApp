package com.sespitia.weatherapp.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AirComponents {
    @JsonProperty("co")
    private Double carbonMonoxide;
    @JsonProperty("no")
    private Double nitrogenMonoxide;
    @JsonProperty("no2")
    private Double nitrogenDioxide;
    @JsonProperty("o3")
    private Double ozone;
    @JsonProperty("so2")
    private Double sulphurDioxide;
    @JsonProperty("pm2_5")
    private Double particulate;
    @JsonProperty("pm10")
    private Double particulateMatter;
    @JsonProperty("nh3")
    private Double ammonia;

}
