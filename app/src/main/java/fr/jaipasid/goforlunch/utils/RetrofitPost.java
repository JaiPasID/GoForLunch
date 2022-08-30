package fr.jaipasid.goforlunch.utils;

import com.google.gson.annotations.SerializedName;

public class RetrofitPost {

    private double lat;
    private double lon;


    @SerializedName("boddy")
    private String boddy;


    /** Getter / Setter
     *
     * @return
     */
    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public String getBoddy() {
        return boddy;
    }

    public void setBoddy(String boddy) {
        this.boddy = boddy;
    }
}
