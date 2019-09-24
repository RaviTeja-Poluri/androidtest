package com.raviteja.tourism.retro;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public final class RetroClient {


    private static final String BASE_URL = "http://192.168.0.104:6363/";
    private static Retrofit retrofit = null;

    public static Retrofit getRetroClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
