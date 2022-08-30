package fr.jaipasid.goforlunch.utils;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceApi {

    @GET("/maps/api/place/nearbysearch/json")
    Call<List<RetrofitPost>> getPost();

}
