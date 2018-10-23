package app.ravi.com.myapp.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import app.ravi.com.myapp.R;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        final String userName;
        TextView editText = findViewById(R.id.et_home_uname);

        if (getIntent().getStringExtra("uname") == null || getIntent().getStringExtra("uname").isEmpty()) {
            userName = "Guest";
        } else {
            userName = getIntent().getStringExtra("uname");
        }

        editText.setText(String.format("Welcome %s", userName));
        Button logout = findViewById(R.id.btn_home_logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LoginBoardScreen.class);
                startActivity(intent);
                finish();
            }
        });
        SharedPreferences user = getSharedPreferences("user", MODE_PRIVATE);
        SharedPreferences.Editor edit = user.edit();
        edit.putString("user", userName);
        edit.apply();
        Button feeds = findViewById(R.id.btn_home_feeds);
        feeds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //get user states_list and their friend states_list
                Intent intent = new Intent(getApplicationContext(), StatesList.class);
                intent.putExtra("uname", userName);
                startActivity(intent);
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
