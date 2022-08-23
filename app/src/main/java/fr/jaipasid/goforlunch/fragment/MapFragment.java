package fr.jaipasid.goforlunch.fragment;


import android.Manifest;
import android.content.Context;

import android.content.pm.PackageManager;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationRequest;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;


import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;


import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.maps.GoogleMap;

import com.google.android.gms.maps.OnMapReadyCallback;

import fr.jaipasid.goforlunch.MainActivity;
import fr.jaipasid.goforlunch.R;


public class MapFragment extends Fragment implements OnMapReadyCallback {


    protected LocationManager locationManager;
    protected LocationRequest locationRequest;
    Context context;
    double lat;
    double lon;

    // FusedLocationProviderClient fusedLocationProviderClient;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Initialize view
        View view = inflater.inflate(R.layout.fragment_map, container, false);


        locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        locationRequest = LocationRequest.create();
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return TODO;
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, (LocationListener) this);


//TODO CREER UNE METHODE LOCATION MANAGER POUR RECUPERER LAT ET LONGITUDE

        // Return view
   return view;


        }





    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
 // TODO UTILISER LES COORDONNES POUR WOO,ER SUR MA LOCAISTION

    }
}