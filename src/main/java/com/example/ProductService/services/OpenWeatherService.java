package com.example.ProductService.services;

import com.example.ProductService.dtos.OpenWeatherDto;
import com.example.ProductService.models.Weather;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OpenWeatherService implements WeatherService {
    private final String appid = "35edd1c4174aded6db8f5d1ce6b65f26";
    @Override
    public Weather fetchWeather(String latitude, String longitude) {
        // Code to fetch weather from OpenWeather API
        String url = "https://api.openweathermap.org/data/2.5/weather?lat=" + latitude + "&lon=" + longitude + "&APPID=" + appid;
        RestTemplate restTemplate = new RestTemplate();
        OpenWeatherDto openWeatherDto = restTemplate.getForObject(url, OpenWeatherDto.class);
        return new Weather(openWeatherDto);
    }
}
