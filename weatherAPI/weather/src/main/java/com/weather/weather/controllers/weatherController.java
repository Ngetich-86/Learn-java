package com.weather.weather.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.weather.weather.models.weatherModel;

@RestController
@RequestMapping("/weather")
public class weatherController {
    
    @Value("${rapidapi.key}")
    private String rapidApiKey;
    
    @Value("${rapidapi.host}")
    private String rapidApiHost;
    
    @Value("${rapidapi.url}")
    private String rapidApiUrl;
    
    @GetMapping
    public weatherModel getWeather(@RequestParam String city) {
        RestTemplate restTemplate = new RestTemplate();
        
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-RapidAPI-Key", rapidApiKey);
        headers.set("X-RapidAPI-Host", rapidApiHost);
        
        HttpEntity<String> entity = new HttpEntity<>(headers);
        
        ResponseEntity<String> response = restTemplate.exchange(
            rapidApiUrl + "?q=" + city,
            HttpMethod.GET,
            entity,
            String.class
        );
        
        // For now, returning dummy data. You'll need to parse the JSON response
        return new weatherModel(
            city,
            "26°C",
            "Partly cloudy"
        );
    }
}
