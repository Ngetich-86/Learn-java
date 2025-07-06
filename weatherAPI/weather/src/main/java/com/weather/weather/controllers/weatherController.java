package com.weather.weather.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weather.weather.models.weatherModel;

@RestController
@RequestMapping("/weather")
public class weatherController {
    
    @GetMapping
    public weatherModel getWeather(){
        String city = "London"; 
        return new weatherModel(
            city,
            "26°C",
            "Partly cloudy"
        );
    }
}
