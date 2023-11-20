package com.sespitia.weatherapp.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MainAir {
    @JsonProperty("aqi")
    private Integer aqi;
}
