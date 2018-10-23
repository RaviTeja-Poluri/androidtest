package app.ravi.com.myapp.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import app.ravi.com.myapp.R;
import app.ravi.com.myapp.adapter.StatesListAdapter;
import app.ravi.com.myapp.api.StateApi;
import app.ravi.com.myapp.model.State;
import app.ravi.com.myapp.retro.RetroClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StatesList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //TODO : this is for states
        setContentView(R.layout.states_activity);
        final RecyclerView viewById = findViewById(R.id.recycler1);
        String userName = getIntent().getStringExtra("uname");
        if (userName == null || userName.isEmpty()) {
            userName = "Guest";
        }
        final List<State> stateList = new ArrayList<>();
        RetroClient.getRetroClient().create(StateApi.class).getStates().enqueue(new Callback<List<State>>() {
            @Override
            public void onResponse(Call<List<State>> call, Response<List<State>> response) {
                stateList.addAll(response.body());
                StatesListAdapter statesListAdapter = new StatesListAdapter(stateList, getApplicationContext());
                viewById.setAdapter(statesListAdapter);
                viewById.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            }

            @Override
            public void onFailure(Call<List<State>> call, Throwable t) {
                t.printStackTrace();
            }
        });



    }
}
