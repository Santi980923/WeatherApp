package com.irojas.demojwt.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class MainMesures implements Serializable {
    @JsonProperty("temp")
    private Double temp;

    @JsonProperty("feels_like")
    private Double feels_like;

    @JsonProperty("temp_min")
    private Double temp_min;

    @JsonProperty("temp_max")
    private Double temp_max;

    @JsonProperty("pressure")
    private Double pressure;

    @JsonProperty("humidity")
    private Double humidity;



}
