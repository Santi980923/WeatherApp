package com.sespitia.weatherapp.repository;

import com.sespitia.weatherapp.exceptions.OpenWeatherMapException;
import com.sespitia.weatherapp.models.AirPollution;
import com.sespitia.weatherapp.models.CityData;
import com.sespitia.weatherapp.models.ForeCastData;
import com.sespitia.weatherapp.models.WeatherData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;
import org.springframework.web.util.UriTemplate;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

@Repository
public class WeatherRepository {

    @Value("${openweathermap.api.key}")
    private String apiKey;
    @Value("${openweathermap.current.url}")
    private String currentWeather;
    @Value("${geolocation.api.url}")
    private String urlLocation;
    @Value("${openweathermap.current.pollution}")
    private String urlPollution;

    private final RestTemplate restTemplate;

    public WeatherRepository(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }


    private <T> T invoke(URI url, Class<T> responseType) {
        RequestEntity<?> requestEntity = RequestEntity.get(url).accept(MediaType.APPLICATION_JSON).build();
        ResponseEntity<T> exchange = null;

        try {
            exchange = this.restTemplate.exchange(requestEntity, responseType);
        } catch (Exception ex) {
            throw new OpenWeatherMapException(ex.getMessage());
        }
        return exchange.getBody();
    }

    @Cacheable("currentWeather")
    public WeatherData getCurrentWeather(String city) {
        URI urlOpenWeatherMapExpanded = new UriTemplate(currentWeather).expand("weather",city, apiKey);
        return invoke(urlOpenWeatherMapExpanded, WeatherData.class);
    }

    @Cacheable("foreCastWeather")
    public ForeCastData getForecastWeather(String city){
        URI urlOpenWeatherMapExpanded = new UriTemplate(currentWeather).expand("forecast",city, apiKey);
        return invoke(urlOpenWeatherMapExpanded, ForeCastData.class);
    }

    @Cacheable("cityData")
    public List<CityData> getCityData(String city){
        URI urlOpenWeatherMapExpanded = new UriTemplate(urlLocation).expand(city,apiKey);
        CityData[] cityDataArray = invoke(urlOpenWeatherMapExpanded,  CityData[].class);
        return Arrays.stream(cityDataArray).toList();
    }

   @Cacheable("airPollution")
    public AirPollution getAirPollution(Double lat, Double lon){
        URI urlOpenWeatherMapExpanded = new UriTemplate(urlPollution).expand("air_pollution",lat,lon,apiKey);
        return invoke(urlOpenWeatherMapExpanded, AirPollution.class);
    }
}
