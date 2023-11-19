package com.irojas.demojwt.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ForeCastData implements Serializable {

    @JsonProperty("cod")
    private String code;
    @JsonProperty("message")
    private Double message;
    @JsonProperty("cnt")
    private Integer cnt;
    @JsonProperty("list")
    private List<ForecastWeather> listaForecast = new ArrayList<>();
    @JsonProperty("city")
    private City city;


}
