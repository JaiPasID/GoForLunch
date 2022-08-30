package fr.jaipasid.goforlunch.fragment;


import android.Manifest;
import android.content.Context;

import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationRequest;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;


import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;


import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.maps.GoogleMap;

import com.google.android.gms.maps.OnMapReadyCallback;

import fr.jaipasid.goforlunch.MainActivity;
import fr.jaipasid.goforlunch.R;
import fr.jaipasid.goforlunch.locationManager.LocationGps;
import fr.jaipasid.goforlunch.utils.RetrofitPost;


public class MapFragment extends Fragment implements OnMapReadyCallback{


    double lat;
    double lon;
    private ActivityResultLauncher<String> requestPermissionLauncher;
    LocationCallback locationCallback;
    RetrofitPost retrofitPost;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Initialize view
        View view = inflater.inflate(R.layout.fragment_map, container, false);


        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED ) {
            CallBack();
        } else {
            requestPermissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION);
        }

        requestPermissionLauncher = registerForActivityResult(new ActivityResultContracts.RequestPermission(), new ActivityResultCallback<Boolean>() {
            @Override
            public void onActivityResult(Boolean isGranted) {
                if (isGranted) {
                    CallBack();
                    retrofitPost.setLat(lat);
                    retrofitPost.setLon(lon);
                } else {
                    //
                }
            }
        });

   return view;


        }


        public void CallBack(){
            locationCallback = new LocationCallback() {
                @Override
                public void onLocationResult(@NonNull LocationResult locationResult) {
                    super.onLocationResult(locationResult);
                    Location location = locationResult.getLastLocation();
                    lat = location.getLatitude();
                    lon = location.getLongitude();
                    retrofitPost.setLat(lat);
                    retrofitPost.setLon(lon);

                }
            };

        }



    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
 // TODO UTILISER LES COORDONNES POUR WOO,ER SUR MA LOCAISTION


    }
}