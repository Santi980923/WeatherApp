package com.irojas.demojwt.controller;

import com.irojas.demojwt.models.AirPollution;
import com.irojas.demojwt.models.ForeCastData;
import com.irojas.demojwt.models.WeatherData;
import com.irojas.demojwt.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/current/{city}")
    public ResponseEntity<?> getCurrentWeather(@PathVariable String city) {
        weatherService.validatecity(city);
        WeatherData weatherData = weatherService.getCurrentWeather(city);
        return ResponseEntity.ok(weatherData);
    }

    @GetMapping("/forecast/{city}")
    public ResponseEntity<?> getForecastWeather(@PathVariable String city) {
        weatherService.validatecity(city);
        ForeCastData forecastWeather = weatherService.getForecastWeather(city);
        return ResponseEntity.ok(forecastWeather);
    }

    @GetMapping("/airpollution/{city}")
    public ResponseEntity<?> getAirPollution(@PathVariable String city) {
        weatherService.validatecity(city);
        AirPollution airPollution = weatherService.getAirPollution(city);
        return ResponseEntity.ok(airPollution);
    }
}
