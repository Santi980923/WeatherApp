package com.irojas.demojwt.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "there is an error while accesing openweathermap.com")
public class OpenWeatherMapException extends RuntimeException{
    public OpenWeatherMapException(String msg){
        super(msg);
    }
}
