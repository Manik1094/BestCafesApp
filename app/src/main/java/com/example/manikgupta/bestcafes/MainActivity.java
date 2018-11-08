package com.example.manikgupta.bestcafes;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ActionBar actionBar;

    private StatesAdapter mAdapter;
private CustomState customState;
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    public ArrayList<CustomState> stateNames = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent= getIntent();

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        stateNames.add(new CustomState("Delhi",R.drawable.delhi2));
        stateNames.add(new CustomState("Mumbai",R.drawable.mumbai2));

        stateNames.add(new CustomState("Kolkata",R.drawable.kolkata1));
        stateNames.add(new CustomState("Gujrat",R.drawable.gujrat1));

        stateNames.add(new CustomState("Goa",R.drawable.goa));
        stateNames.add(new CustomState("Chennai",R.drawable.chennai));
        stateNames.add(new CustomState("Bangalore",R.drawable.ban_logo));
        stateNames.add(new CustomState("Himachal",R.drawable.him));







        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mAdapter = new StatesAdapter(this,stateNames);

        RecyclerView.LayoutManager layoutManager  = new GridLayoutManager(this,2);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        recyclerView.setAdapter(mAdapter);
    }


}
