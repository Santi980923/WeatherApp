package com.irojas.demojwt.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class AirPollution {
    @JsonProperty("coord")
    private Coordinate coordinate;
    @JsonProperty("list")
    private List<AirList> listAirComponents = new ArrayList<>();
}
