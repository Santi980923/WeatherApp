package com.sespitia.weatherapp.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Wind {
    @JsonProperty("speed")
    private Double speed;

    @JsonProperty("deg")
    private Double deg;

}
