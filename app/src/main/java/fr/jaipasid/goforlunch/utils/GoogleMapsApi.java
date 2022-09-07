package fr.jaipasid.goforlunch.utils;

import java.util.List;

import fr.jaipasid.goforlunch.models.MyFetchData;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GoogleMapsApi {

    @GET("maps/api/place/nearbysearch/json")
    Call<MyFetchData> getRestaurant(@Query("keyword")String cruise, @Query("location") String location, @Query("radius") int radius, @Query("type") String restaurant, @Query("key") String apiKey);

    /**
     * https://maps.googleapis.com/maps/api/place/nearbysearch/json
     *   ?keyword=cruise
     *   &location=-33.8670522 %2C 151.1957362
     *   &radius=1500
     *   &type=restaurant
     *   &key=YOUR_API_KEY
     */
}
