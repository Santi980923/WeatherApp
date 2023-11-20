package com.sespitia.weatherapp.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.time.*;

public class SystemCountry {
    private Instant timestamp;
    private LocalDate date;
    private LocalTime time;



    @JsonProperty("type")
    private Integer type;

    @JsonProperty("id")
    private Integer idCountry;

    @JsonProperty("country")
    private String country;

    @JsonProperty("lat")
    private Double latitude;

    @JsonProperty("sunrise")
    private Integer sunrise;
    @JsonProperty("sunset")
    private Integer sunset;

}
