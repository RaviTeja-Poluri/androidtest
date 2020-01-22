package com.raviteja.tourism.ui.home.places;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.raviteja.tourism.model.Place;
import com.raviteja.tourism.retro.RetroClient;
import com.raviteja.tourism.retro.clients.PlaceClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;

public class PlacesListViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public PlacesListViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public Call<List<Place>> getText() {
        final List<Place> places = new ArrayList<>();
        PlaceClient placeClient = RetroClient.getRetroClient().create(PlaceClient.class);
        return placeClient.getPlaces("1");
    }
}