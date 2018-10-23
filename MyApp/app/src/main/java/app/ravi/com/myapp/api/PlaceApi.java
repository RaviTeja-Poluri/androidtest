package app.ravi.com.myapp.api;

import java.util.List;

import app.ravi.com.myapp.model.Place;
import app.ravi.com.myapp.model.State;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface PlaceApi {

    @GET("/{stateId}/places")
    Call<List<Place>> getPlaces(@Path("stateId") String stateId);
}
