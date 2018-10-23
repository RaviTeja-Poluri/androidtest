package app.ravi.com.myapp.api;

import app.ravi.com.myapp.model.User;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by root on 10/2/18.
 */

public interface UserApiInterface {


    @GET("user")
    Call<User> validateUser(@Query("name") String uname, @Query("pwd") String pwd);

    @POST("/user/login")
    Call<User> login(@Body User user);

    @POST("user")
    Call<User> saveUser(@Body User user);

    @Multipart
    @POST("/{userid}/profile/upload")
    Call<ResponseBody> upload(@Path("userid") String uId,@Part MultipartBody.Part file);

    //@Header for adding header

}
