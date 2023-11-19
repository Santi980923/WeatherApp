package com.irojas.demojwt.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.io.Serializable;
import java.time.*;
import java.util.ArrayList;
import java.util.List;

public class WeatherData implements Serializable {

    private Instant timestamp;
    private LocalDate date;
    private LocalTime time;
    @JsonProperty("coord")
    private Coordinate coordinate;
    @JsonProperty("weather")
    private List<WeatherForecast> lista = new ArrayList<>();
    private String base;
    @JsonProperty("main")
    private MainMesures mainMeasures;
    @JsonProperty("visibility")
    private Integer visibility;
    @JsonProperty("wind")
    private Wind wind;
    @JsonProperty("clouds")
    private Cloud cloud;
    @JsonSetter("dt")
    public void setTimestamp(long unixTime){
        this.timestamp = Instant.ofEpochMilli(unixTime * 1000);
        LocalDateTime localDateTime = LocalDateTime.ofInstant(timestamp, ZoneOffset.UTC);
        setDate(localDateTime.toLocalDate());
        setTime(localDateTime.toLocalTime());
    }
    @JsonProperty("sys")
    private SystemCountry systemCountry;

    @JsonProperty("timezone")
    private Double timeZone;
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("cod")
    private Integer code;

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }


}
