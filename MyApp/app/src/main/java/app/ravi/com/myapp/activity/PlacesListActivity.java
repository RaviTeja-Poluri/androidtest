package app.ravi.com.myapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import app.ravi.com.myapp.R;
import app.ravi.com.myapp.adapter.PlacesListAdapter;
import app.ravi.com.myapp.adapter.StatesListAdapter;
import app.ravi.com.myapp.api.PlaceApi;
import app.ravi.com.myapp.model.Place;
import app.ravi.com.myapp.model.State;
import app.ravi.com.myapp.retro.RetroClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlacesListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places_list);

        final RecyclerView viewById = findViewById(R.id.placesRecycler);
        /*
         * getting state id
         */
        String stateId = getIntent().getStringExtra("stateId");
        final List<Place> placesList = new ArrayList<>();
        RetroClient.getRetroClient().create(PlaceApi.class).getPlaces(stateId).enqueue(new Callback<List<Place>>() {
            @Override
            public void onResponse(Call<List<Place>> call, Response<List<Place>> response) {
                placesList.addAll(response.body());
                PlacesListAdapter placeListAdapter = new PlacesListAdapter(placesList, getApplicationContext());
                viewById.setAdapter(placeListAdapter);
                viewById.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            }

            @Override
            public void onFailure(Call<List<Place>> call, Throwable t) {
                t.printStackTrace();
            }
        });

    }
}
