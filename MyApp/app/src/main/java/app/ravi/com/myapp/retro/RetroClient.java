package app.ravi.com.myapp.retro;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by root on 10/2/18.
 */

public final class RetroClient {
    private static final String BASE_URL = "http://192.168.0.102:6363/";
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
