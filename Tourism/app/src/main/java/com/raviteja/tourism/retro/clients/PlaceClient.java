package com.raviteja.tourism.retro.clients;

import com.raviteja.tourism.model.Place;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface PlaceClient {

    @GET("/place/list")
    Call<List<Place>> getPlaces(@Query("cityId") String cityId);
}