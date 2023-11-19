package com.irojas.demojwt.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AirList {
    @JsonProperty("main")
    private MainAir mainAir;
    @JsonProperty("components")
    private AirComponents airComponents;
    @JsonProperty("dt")
    private Double dt;
}
