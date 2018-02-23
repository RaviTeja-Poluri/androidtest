package app.ravi.com.myapp.activity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import app.ravi.com.myapp.R;

public class LoginBoardScreen extends AppCompatActivity {


    Button signup, login, guest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_board_screen);

        signup = (Button) findViewById(R.id.btn_signup);
        login = (Button) findViewById(R.id.btn_login);
        guest = (Button) findViewById(R.id.btn_guest);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                signup.setBackgroundColor(Color.GRAY);
                signup.getBackground().setColorFilter(Color.GREEN, PorterDuff.Mode.MULTIPLY);
//                Toast.makeText(getApplicationContext(), "signup", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), RegisterScreen.class);
                startActivity(intent);
                finish();
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login.getBackground().setColorFilter(Color.GRAY, PorterDuff.Mode.MULTIPLY);

//                Toast.makeText(getApplicationContext(), "login", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), LoginScreen.class);
                startActivity(intent);
                finish();
            }
        });
        guest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                guest.getBackground().setColorFilter(Color.GREEN, PorterDuff.Mode.ADD);
//                Toast.makeText(getApplicationContext(), "guest", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
