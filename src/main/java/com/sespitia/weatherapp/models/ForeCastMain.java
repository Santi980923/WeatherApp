package com.sespitia.weatherapp.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ForeCastMain extends MainMesures{

    @JsonProperty("sea_level")
    private Double seaLevel;

    @JsonProperty("grnd_level")
    private Double groundLevel;

    @JsonProperty("temp_kf")
    private Double tempKf;
}
