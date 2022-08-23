package fr.jaipasid.goforlunch.locationManager;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;

import android.os.Bundle;
import android.util.Log;



public class LocationGps implements LocationListener {

    protected Context context;

    double lat, lon;


    @Override
    public void onLocationChanged(Location location) {
        lat = location.getLatitude();
        lon = location.getLongitude();

    }

    @Override
    public void onProviderDisabled(String provider) {
        Log.d("Latitude","disable");
    }

    @Override
    public void onProviderEnabled(String provider) {
        Log.d("Latitude","enable");
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        Log.d("Latitude","status");
    }
}
