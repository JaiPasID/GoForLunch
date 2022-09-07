package fr.jaipasid.goforlunch.utils;



import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

import retrofit2.converter.gson.GsonConverterFactory;


public class Retrofit {

    private static retrofit2.Retrofit retrofit;
    private static String BASE_URL = "https://maps.googleapis.com/";




    public static retrofit2.Retrofit getRetrofit() {

        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)).build();
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build();
                }

        return retrofit;
    }
    public static GoogleMapsApi getGoogleMapsApi() {
        return getRetrofit().create(GoogleMapsApi.class);
    }


}
