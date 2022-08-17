package fr.jaipasid.goforlunch.utils;

import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class Retrofit {

    private static retrofit2.Retrofit retrofit;
    private static String BASE_URL = "https://qrcode-monkey.p.rapidapi.com/qr/custom";



    public static retrofit2.Retrofit getRetrofit() {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();


        }
        return retrofit;
    }
}
