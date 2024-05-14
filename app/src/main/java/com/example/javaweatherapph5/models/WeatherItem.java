package com.example.javaweatherapph5.models;
import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString, Root.class); */

@Data
public class WeatherItem{

    private String cod;
    private int message;
    private int cnt;
    private ArrayList<List> list;
    private City city;
    @Data
    public class City{
        private int id;
        private String name;
        private Coord coord;
        private String country;
        private int population;
        private int timezone;
        private int sunrise;
        private int sunset;
    }
    @Data
    public class Clouds{
        private int all;
    }
    @Data
    public class Coord{
        private double lat;
        private double lon;
    }
    @Data
    public class List{
        private int dt;
        private Main main;
        private ArrayList<Weather> weather;
        private Clouds clouds;
        private Wind wind;
        private int visibility;
        private double pop;
        private Rain rain;
        private Sys sys;
        private String dt_txt;
    }
    @Data
    public class Main{
        private double temp;
        private double feels_like;
        private double temp_min;
        private double temp_max;
        private int pressure;
        private int sea_level;
        private int grnd_level;
        private int humidity;
        private double temp_kf;
    }
    @Data
    public class Rain{
        @JsonProperty("3h")
        private double _3h;
    }
    @Data
    public class Sys{
        private String pod;
    }
    @Data
    public class Weather{
        private int id;
        private String main;
        private String description;
        private String icon;
    }
    @Data
    public class Wind{
        private double speed;
        private int deg;
        private double gust;
    }
}



