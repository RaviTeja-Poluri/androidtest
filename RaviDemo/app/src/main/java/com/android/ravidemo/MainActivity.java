package com.android.ravidemo;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements RvItemClickListener {

    private static final String TAG = "Main::";
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private NavigationView navigationView;
    private RecyclerView recyclerView;
    private List<String> parentList;
    private MyRvAdapter myRvAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         parentList=new ArrayList<>();
        parentList.add("Telangana");
        parentList.add("Maharashtra");
        parentList.add("Assam");
        parentList.add("Kolkatha");
        parentList.add("Arunachalparadesh");
        parentList.add("Andrapradesh");
        parentList.add("Utherpradesh");

        recyclerView=findViewById(R.id.rv_parentItems);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));
          myRvAdapter=new MyRvAdapter(getApplicationContext(),parentList, MainActivity.this);
        recyclerView.setAdapter(myRvAdapter);

        drawerLayout = findViewById(R.id.activity_main);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.Open, R.string.Close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        navigationView = findViewById(R.id.nv);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id) {
                    case R.id.home:
                        Toast.makeText(MainActivity.this, "Home", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        return true;
                }
                return true;

            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(int position) {
        Log.d(TAG, "onItemClick: "+position);


        MSingletonStack.push(parentList.get(position));
        parentList=new ArrayList<>();
        switch (position){
            case 0:
            parentList.add("Hyderabad");
            parentList.add("Secundrabad");
            parentList.add("Kothapet");
            parentList.add("Siddipet");
            parentList.add("Adilabad");
            break;
            case 1:
                parentList.add("Nasik");
                parentList.add("Solapur");
                parentList.add("Thane");
                parentList.add("Mumbai");
                parentList.add("Khandala");
                break;


        }
        myRvAdapter=new MyRvAdapter(getApplicationContext(),parentList,MainActivity.this);
        recyclerView.setAdapter(myRvAdapter);
        myRvAdapter.notifyDataSetChanged();
     }

    @Override
    public void onBackPressed() {

        String pop = MSingletonStack.pop();
        if (pop !=null){
            //TODO request according to this pop

        }

    }
}
