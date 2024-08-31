package com.example.ProductService.models;

import com.example.ProductService.dtos.OpenWeatherDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Weather {
    @JsonProperty("coordinate")
    private Weather.Coord coord;
    private String base;
    private Weather.Main main;
    private int visibility;
    private Weather.Wind wind;
    private Weather.Clouds clouds;
    private long dt;
    private Weather.Sys sys;
    private int timezone;
    private int id;
    @JsonProperty("location_name")
    private String name;
    private int cod;

    public Weather(OpenWeatherDto openWeatherDto) {

        if(openWeatherDto == null) {
            return;
        }
        // Set the value of coordinate
        OpenWeatherDto.Coord c = openWeatherDto.getCoord();
        this.coord = new Weather.Coord();
        this.coord.setLat(c.getLat());
        this.coord.setLon(c.getLon());

        this.base = openWeatherDto.getBase();

        // Set main object of weather
        OpenWeatherDto.Main m = openWeatherDto.getMain();
        this.main = new Weather.Main();
        this.main.setTemp(m.getTemp());
        this.main.setFeels_like(m.getFeels_like());
        this.main.setTemp_min(m.getTemp_min());
        this.main.setTemp_max(m.getTemp_max());
        this.main.setPressure(m.getPressure());
        this.main.setHumidity(m.getHumidity());
        this.main.setSea_level(m.getSea_level());
        this.main.setGrnd_level(m.getGrnd_level());


        this.visibility = openWeatherDto.getVisibility();

        OpenWeatherDto.Wind w = openWeatherDto.getWind();
        this.wind = new Weather.Wind();
        this.wind.setSpeed(w.getSpeed());
        this.wind.setDeg(w.getDeg());


        OpenWeatherDto.Clouds cl = openWeatherDto.getClouds();
        this.clouds = new Weather.Clouds();
        this.clouds.setAll(cl.getAll());

        this.dt = openWeatherDto.getDt();

        OpenWeatherDto.Sys s = openWeatherDto.getSys();
        this.sys = new Weather.Sys();
        this.sys.setType(s.getType());
        this.sys.setId(s.getId());
        this.sys.setCountry(s.getCountry());
        this.sys.setSunrise(s.getSunrise());
        this.sys.setSunset(s.getSunset());

        this.timezone = openWeatherDto.getTimezone();
        this.id = openWeatherDto.getId();
        this.name = openWeatherDto.getName();
        this.cod = openWeatherDto.getCod();
    }

    @Getter
    @Setter
    // Nested Classes
    public static class Coord {
        @JsonProperty("longitute")
        private double lon;
        @JsonProperty("lattitude")
        private double lat;

    }

    @Getter
    @Setter
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

    @Getter
    @Setter
    public static class Wind {
        private double speed;
        private int deg;

    }

    @Getter
    @Setter
    public static class Clouds {
        private int all;

    }

    @Getter
    @Setter
    public static class Sys {
        private int type;
        private int id;
        private String country;
        private long sunrise;
        private long sunset;
    }
}