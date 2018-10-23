package app.ravi.com.myapp.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import app.ravi.com.myapp.R;
import app.ravi.com.myapp.api.UserApiInterface;
import app.ravi.com.myapp.model.User;
import app.ravi.com.myapp.retro.RetroClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        Button submit = findViewById(R.id.btn_login_submit);
        Button register = findViewById(R.id.btn_login_register);
        Button forgotPassword = findViewById(R.id.btn_login_forgotpassword);
        final Button guest = findViewById(R.id.btn_login_guest);
        final EditText uname = findViewById(R.id.et_login_uname);
        final EditText pwd = findViewById(R.id.et_login_pwd);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String user = uname.getText().toString();
                final String password =pwd.getText().toString();
  /*              UserApiInterface apiService =
                        RetroClient.getRetroClient().create(UserApiInterface.class);
                Call<User> validatedUser = apiService.validateUser(user, String.valueOf(password));
                validatedUser.enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        Toast.makeText(getApplicationContext(), response.body().toString(), Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                        intent.putExtra("uname", user);
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "unknown error occurs please try again after sometime", Toast.LENGTH_LONG).show();
                    }
                });*/


                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                intent.putExtra("uname", user);
                startActivity(intent);
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), RegisterScreen.class);
                startActivity(intent);
                finish();
            }
        });

        guest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(getApplicationContext(), "guest", Toast.LENGTH_LONG).show();
                guest.setBackgroundColor(Color.DKGRAY);
                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                intent.putExtra("uname", "Guest");
                startActivity(intent);
                finish();
            }
        });

        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "currently un available", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(), LoginBoardScreen.class);
        startActivity(intent);
        finish();
    }
}
