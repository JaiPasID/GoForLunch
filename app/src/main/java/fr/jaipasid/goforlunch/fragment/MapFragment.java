package fr.jaipasid.goforlunch.fragment;


import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;

import java.util.List;

import fr.jaipasid.goforlunch.R;
import fr.jaipasid.goforlunch.models.MyFetchData;
import fr.jaipasid.goforlunch.models.Result;
import fr.jaipasid.goforlunch.utils.GoogleMapsApi;
import fr.jaipasid.goforlunch.viewmodel.FetchDataViewModel;
import fr.jaipasid.goforlunch.viewmodel.NewModelFactory;


public class MapFragment extends Fragment implements OnMapReadyCallback{


    double lat;
    double lon;
    private ActivityResultLauncher<String> requestPermissionLauncher;
    private GoogleMapsApi mGoogleMapsApi;
    private FetchDataViewModel mFetchDataViewModel;
    private List<Result> retourApi;
    private String mLocation;



    LocationCallback locationCallback;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Initialize view
        View view = inflater.inflate(R.layout.fragment_map, container, false);
        mFetchDataViewModel = new ViewModelProvider(this, NewModelFactory.getInstance()).get(FetchDataViewModel.class);




        requestPermissionLauncher = registerForActivityResult(new ActivityResultContracts.RequestPermission(), new ActivityResultCallback<Boolean>() {
            @Override
            public void onActivityResult(Boolean isGranted) {
                if (isGranted) {
                    CallBack();

                } else {
                    //
                }
            }
        });
        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED ) {
            CallBack();
        } else {
            requestPermissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION);
        }
 
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

                    mLocation = lat + "," + lon;

                }
            };

        }



    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {

        mFetchDataViewModel.getRestaurants(mLocation).observe(requireActivity(), new Observer<MyFetchData>() {
            @Override
            public void onChanged(MyFetchData pMyFetchData) {
                retourApi = pMyFetchData.getResults();

                // TODO FAIRE UNE BOUCLE SUR LES RESTAURANTS
                for (int i = 0; i < retourApi.size(); i++){
                    Double lat =  retourApi.get(i).getGeometry().getLocation().getLat();
                    Double lon =  retourApi.get(i).getGeometry().getLocation().getLng();

                    // TODO AJOUT UN MARKER A CHAQUE ITARATION DE LA BOUCLE
                }

            }
        });





    }


}