package com.sespitia.weatherapp.controller;

import com.sespitia.weatherapp.models.AirPollution;
import com.sespitia.weatherapp.models.ForeCastData;
import com.sespitia.weatherapp.models.WeatherData;
import com.sespitia.weatherapp.service.WeatherService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
@Tag(name = "Weather Controller", description = "Endpoints for weather information")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/current/{city}")
    @Operation(summary = "Get current weather", description = "Get the current weather for a specific city")
    public ResponseEntity<?> getCurrentWeather(@PathVariable String city) {
        weatherService.validatecity(city);
        WeatherData weatherData = weatherService.getCurrentWeather(city);
        return ResponseEntity.ok(weatherData);
    }

    @GetMapping("/forecast/{city}")
    @Operation(summary = "Get forecast weather", description = "Get the forecast weather for a specific city")
    public ResponseEntity<?> getForecastWeather(@PathVariable String city) {
        weatherService.validatecity(city);
        ForeCastData forecastWeather = weatherService.getForecastWeather(city);
        return ResponseEntity.ok(forecastWeather);
    }

    @GetMapping("/airpollution/{city}")
    @Operation(summary = "Get air pollution", description = "Get air pollution data for a specific city")
    public ResponseEntity<?> getAirPollution(@PathVariable String city) {
        weatherService.validatecity(city);
        AirPollution airPollution = weatherService.getAirPollution(city);
        return ResponseEntity.ok(airPollution);
    }
}

