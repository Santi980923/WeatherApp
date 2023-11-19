package com.irojas.demojwt.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Coordinate implements Serializable {
    @JsonProperty("lon")
    private Double longitude;

    @JsonProperty("lat")
    private Double latitude;

}
