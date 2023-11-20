package com.sespitia.weatherapp.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class City {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("coord")
    private Coordinate coordinate;
    @JsonProperty("country")
    private String country;
    @JsonProperty("population")
    private Long population;
    @JsonProperty("timezone")
    private Double timezone;
    @JsonProperty("sunrise")
    private Long sunrise;
    @JsonProperty("sunset")
    private Long sunset;

}
