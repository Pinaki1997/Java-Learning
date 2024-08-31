package com.example.ProductService.controllers;

import com.example.ProductService.models.Weather;
import com.example.ProductService.services.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
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

    @GetMapping("/{lat}/{long}")
    public ResponseEntity<Weather> fetchCurrentWeather(@PathVariable(value = "lat") String latitude, @PathVariable(value = "long") String longitude) {
        // Code to fetch current weather

        Weather weather = weatherService.fetchWeather(latitude, longitude);
        return new ResponseEntity<>(weather, HttpStatusCode.valueOf(200));
    }
}
