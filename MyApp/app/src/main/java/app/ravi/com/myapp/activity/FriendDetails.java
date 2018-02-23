package app.ravi.com.myapp.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.Locale;

import app.ravi.com.myapp.R;

public class FriendDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend_details);

        TextView locationView = findViewById(R.id.frnd_details_location);
        TextView mobileView = findViewById(R.id.frnd_details_mobile);
        TextView ageView = findViewById(R.id.frnd_details_age);

        Bundle extras = getIntent().getExtras();

        locationView.setText(String.format("location : %s", extras.getString("location")));
        mobileView.setText(String.format(Locale.ENGLISH, "mobile : %d", extras.getLong("mobile")));
        ageView.setText(String.format(Locale.ENGLISH, "age : %d", extras.getInt("age")));


    }
}
