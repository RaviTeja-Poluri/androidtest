package app.ravi.com.myapp.api;

import java.util.List;

import app.ravi.com.myapp.model.State;
import app.ravi.com.myapp.model.User;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface StateApi {

    @GET("state/list")
    Call<List<State>> getStates();
}
