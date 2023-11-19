package com.irojas.demojwt.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.io.Serializable;
import java.time.*;
import java.util.ArrayList;
import java.util.List;

public class ForecastWeather implements Serializable {

    @JsonProperty("dt")
    private Long dt;

    @JsonProperty("main")
    private ForeCastMain foreCastMain;

    @JsonProperty("weather")
    private List<WeatherForecast> lista = new ArrayList<>();

    @JsonProperty("clouds")
    private Cloud cloud;

    @JsonProperty("wind")
    private WindForeCast windForeCast;

    @JsonProperty("visibility")
    private Integer visibility;
    @JsonProperty("pop")
    private Integer pop;
    @JsonProperty("sys")
    private SysForeCast sysForeCast;
    @JsonProperty("dt_txt")
    private String dtTxt;


}

