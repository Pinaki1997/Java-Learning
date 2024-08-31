package com.example.ProductService.services;

import com.example.ProductService.models.Weather;

public interface WeatherService {
    public Weather fetchWeather(String latitude, String longitude);
}
