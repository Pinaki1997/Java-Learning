package com.example.ProductService.dtos;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class OpenWeatherDto {

    private Coord coord;
    private List<Weather> weather;
    private String base;
    private Main main;
    private int visibility;
    private Wind wind;
    private Clouds clouds;
    private long dt;
    private Sys sys;
    private int timezone;
    private int id;
    private String name;
    private int cod;


    @Setter
    @Getter
    // Nested Classes
    public static class Coord {
        @JsonSerialize
        private double lon;
        private double lat;

    }

    @Setter
    @Getter
    public static class Weather {
        private int id;
        private String main;
        private String description;
        private String icon;

    }

    @Setter
    @Getter
    public static class Main {
        private double temp;
        private double feels_like;
        private double temp_min;
        private double temp_max;
        private int pressure;
        private int humidity;
        private int sea_level;
        private int grnd_level;

    }

    @Setter
    @Getter
    public static class Wind {
        private double speed;
        private int deg;

    }

    @Setter
    @Getter
    public static class Clouds {
        private int all;

    }

    @Setter
    @Getter
    public static class Sys {
        private int type;
        private int id;
        private String country;
        private long sunrise;
        private long sunset;
    }

}
