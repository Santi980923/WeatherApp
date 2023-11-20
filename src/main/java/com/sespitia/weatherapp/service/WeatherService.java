package com.sespitia.weatherapp.service;


import com.sespitia.weatherapp.exceptions.BadCityNameException;
import com.sespitia.weatherapp.models.AirPollution;
import com.sespitia.weatherapp.models.CityData;
import com.sespitia.weatherapp.models.ForeCastData;
import com.sespitia.weatherapp.models.WeatherData;
import com.sespitia.weatherapp.repository.WeatherRepository;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {

    private final WeatherRepository weatherRepository;

    public WeatherService(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }
    public WeatherData getCurrentWeather(String city){
        return weatherRepository.getCurrentWeather(city);
    }

   public ForeCastData getForecastWeather(String city){
        return weatherRepository.getForecastWeather(city);
   }

   public CityData getCityData(String city){
        return weatherRepository.getCityData(city).stream()
                .findFirst()
                .orElseThrow(()-> new RuntimeException("city not found"));
   }

   public AirPollution getAirPollution(String cityName){
        var cityData = getCityData(cityName);
       return weatherRepository.getAirPollution(cityData.getLat(), cityData.getLon());
   }
    // to validate the city name
    public void validatecity(String city) {
        if (!city.chars().allMatch(Character::isAlphabetic))
            throw new BadCityNameException();
    }

}
