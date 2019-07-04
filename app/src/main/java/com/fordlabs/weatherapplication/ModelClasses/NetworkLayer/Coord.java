package com.fordlabs.weatherapplication.ModelClasses.NetworkLayer;

import com.google.gson.annotations.SerializedName;

public class Coord {

    @SerializedName("lon")
    public String lon;

    @SerializedName("lat")
    public String lat;

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }
}
