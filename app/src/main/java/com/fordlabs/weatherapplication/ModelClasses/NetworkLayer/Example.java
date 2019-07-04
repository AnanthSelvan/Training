package com.fordlabs.weatherapplication.ModelClasses.NetworkLayer;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Example {

    @SerializedName("coord")
    public Coord coord;

    @SerializedName("weather")
    public List<Weather> weather;

    @SerializedName("base")
    public String base;

    @SerializedName("main")
    public MainValue mainValue;

    @SerializedName("id")
    public Integer id;

    @SerializedName("timezone")
    public String timezone;

    @SerializedName("name")
    public String name;

    @SerializedName("cod")
    public Integer cod;

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public MainValue getMainValue() {
        return mainValue;
    }

    public void setMainValue(MainValue mainValue) {
        this.mainValue = mainValue;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCod() {
        return cod;
    }

    public void setCod(Integer cod) {
        this.cod = cod;
    }
}
