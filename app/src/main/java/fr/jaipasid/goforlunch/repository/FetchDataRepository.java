package fr.jaipasid.goforlunch.repository;

import android.util.Log;

import fr.jaipasid.goforlunch.BuildConfig;
import fr.jaipasid.goforlunch.models.MyFetchData;
import fr.jaipasid.goforlunch.utils.GoogleMapsApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FetchDataRepository {

    GoogleMapsApi mGoogleMapsApi;

    public FetchDataRepository(GoogleMapsApi mGoogleMapsApi) {
        this.mGoogleMapsApi = mGoogleMapsApi;
    }

    public void fetchData(String location) {
        Call<MyFetchData> call = mGoogleMapsApi.getRestaurant("keyword", location, 1000, "restaurant", BuildConfig.MAPS_API_KEY);

        call.enqueue(new Callback<MyFetchData>() {
            @Override
            public void onResponse(Call<MyFetchData> call, Response<MyFetchData> response) {

                Log.d("Test", response.body().getResults().toString());
            }

            @Override
            public void onFailure(Call<MyFetchData> call, Throwable t) {
                Log.d("Erreur", t.getMessage());
            }
        });


    }
}
