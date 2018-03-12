package app.ravi.com.myapp.api;

import app.ravi.com.myapp.model.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by root on 10/2/18.
 */

public interface UserApiInterface {


    @GET("user")
    Call<User> validateUser(@Query("name") String uname, @Query("pwd") String pwd);

    @POST("user")
    Call<User> saveUser(@Body User user);

    //@Header for adding header

}
