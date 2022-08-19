package fr.jaipasid.goforlunch.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;

import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import fr.jaipasid.goforlunch.MainActivity;
import fr.jaipasid.goforlunch.R;
import fr.jaipasid.goforlunch.databinding.ActivityMainBinding;


public class MapFragment extends Fragment implements OnMapReadyCallback{



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Initialize view
        View view=inflater.inflate(R.layout.fragment_map, container, false);

//TODO CREER UNE METHODE LOCATION MANAGER POUR RECUPERER LAT ET LONGITUDE

        // Return view
        return view;
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
 // TODO UTILISER LES COORDONNES POUR WOO,ER SUR MA LOCAISTION

    }
}