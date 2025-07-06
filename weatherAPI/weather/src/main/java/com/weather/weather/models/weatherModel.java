package com.weather.weather.models;

public class weatherModel {
    private String city;
    private String tempreture;
    private String description;

    public weatherModel(String city, String tempreture, String description){
        this.city = city;
        this.description = description;
        this.tempreture = tempreture;
    }
    public String getCity(){
        return city;
    }
    public String getTempreture(){
        return tempreture;
    }
    public String getDescription(){
        return description;
    }
}
