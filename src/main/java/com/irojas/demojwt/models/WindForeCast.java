package com.irojas.demojwt.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WindForeCast extends Wind{
    @JsonProperty("gust")
    private Double gust;
}
