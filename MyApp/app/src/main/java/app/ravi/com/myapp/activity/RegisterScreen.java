package app.ravi.com.myapp.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.CycleInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import app.ravi.com.myapp.R;
import app.ravi.com.myapp.api.UserApiInterface;
import app.ravi.com.myapp.model.User;
import app.ravi.com.myapp.retro.RetroClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static app.ravi.com.myapp.R.id.activity_register_screen;

public class RegisterScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_screen);

        final RelativeLayout mainLayout = findViewById(activity_register_screen);
        Button submit = findViewById(R.id.reg_signup);
        final EditText uname = findViewById(R.id.reg_uname);
        final EditText pwd = findViewById(R.id.reg_pwd);
        final EditText mail = findViewById(R.id.reg_email);
        final EditText mobile = findViewById(R.id.reg_mobile);
        final EditText loc = findViewById(R.id.reg_loc);
        final EditText age = findViewById(R.id.reg_age);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isValidRegistration(uname, pwd, mobile, mail)) {
                    User user = new User();
                    user.setUserName(uname.getText().toString());
                    user.setPassword(pwd.getText().toString());
                    user.setEmail(mail.getText().toString());
                    user.setMobile(Long.parseLong(mobile.getText().toString()));
                    if (!age.getText().toString().isEmpty()) {
                        user.setAge(Integer.parseInt(age.getText().toString()));
                    }
                    if (!loc.getText().toString().isEmpty()) {
                        user.setLocation(loc.getText().toString());
                    }
                    saveUser(user);
                }
            }
        });
    }

    private void saveUser(User user) {
        UserApiInterface apiService =
                RetroClient.getRetroClient().create(UserApiInterface.class);
        Call<User> validatedUser = apiService.saveUser(user);
        validatedUser.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Toast.makeText(getApplicationContext(), response.body().toString(), Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), LoginBoardScreen.class);
                startActivity(intent);
                finish();
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                t.printStackTrace();
                Toast.makeText(getApplicationContext(), "unknown error occurs please try again after sometime", Toast.LENGTH_LONG).show();
            }
        });
    }


    private boolean isValidRegistration(EditText uname, EditText pwd, EditText mobile, EditText email) {
        boolean valid = true;
        final Drawable icon = getResources().getDrawable(R.drawable.eclamation);
        if (icon != null) {
            icon.setBounds(0, 0,
                    45,
                    45);
        }
        final TranslateAnimation shake = new TranslateAnimation(0, 10, 0, 0);
        shake.setDuration(250);
        shake.setInterpolator(new CycleInterpolator(3));
        if (TextUtils.isEmpty(uname.getText().toString())) {
            valid = false;
            uname.setAnimation(shake);
            uname.setError("user name is required", icon);
        }
        if (TextUtils.isEmpty(pwd.getText().toString())) {
            valid = false;
            pwd.setAnimation(shake);
            pwd.setError("password is required", icon);
        }
        if (TextUtils.isEmpty(mobile.getText().toString())) {
            valid = false;
            mobile.setAnimation(shake);
            mobile.setError("mobile number is required", icon);
        }
        if (TextUtils.isEmpty(email.getText().toString())) {
            valid = false;
            email.startAnimation(shake);
            email.setError("email is required", icon);
        }
        return valid;
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(), LoginBoardScreen.class);
        startActivity(intent);
        finish();
    }
}
