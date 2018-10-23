package com.example.raviteja.drawermenuapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private LinearLayout linearNavigation;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawerLayout);
        linearNavigation = findViewById(R.id.linearNavigation);

        //for action bar toggle we need to create two strings
        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close);

        //adding drawer listener to drawer layout
        drawerLayout.addDrawerListener(actionBarDrawerToggle);

        //adding menu icon on top left of app
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //adding on click listener to menu
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ViewGroup.LayoutParams layoutParams = linearNavigation.getLayoutParams();
                int orientation = getResources().getConfiguration().orientation;
                if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
                    layoutParams.width = 280;
                } else {
                    layoutParams.width = 180;
                }
                linearNavigation.setLayoutParams(layoutParams);
                if (drawerLayout.isDrawerOpen(linearNavigation)) {
                    drawerLayout.closeDrawer(linearNavigation);
                } else {
                    drawerLayout.openDrawer(linearNavigation);
                }
            }
        });
    }

    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onPostCreate(savedInstanceState, persistentState);
        actionBarDrawerToggle.syncState();
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(linearNavigation)) {
            drawerLayout.closeDrawer(linearNavigation);
        } else {
            super.onBackPressed();
        }
    }
}
