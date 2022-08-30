package fr.jaipasid.goforlunch.utils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class Retrofit {

    private static retrofit2.Retrofit retrofit;
    private static String BASE_URL = "https://maps.googleapis.com/";





    public static retrofit2.Retrofit getRetrofit() {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            JsonPlaceApi jsonPlaceApi = retrofit.create(JsonPlaceApi.class);

            Call<List<RetrofitPost>> call = jsonPlaceApi.getPost();

            call.enqueue(new Callback<List<RetrofitPost>>() {
                @Override
                public void onResponse(Call<List<RetrofitPost>> call, Response<List<RetrofitPost>> response) {
                    if (!response.isSuccessful()){
                        response.code();
                        return;
                    }
                    List<RetrofitPost> postList = response.body();

                    for (RetrofitPost post : postList) {
                        String body = "";
                        body += "Lat" +  post.getLat();
                        body += "Lon" + post.getLon();

                    }
                }

                @Override
                public void onFailure(Call<List<RetrofitPost>> call, Throwable t) {

                }
            });
            }
        return retrofit;
    }

}
