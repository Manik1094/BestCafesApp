package com.example.manikgupta.bestcafes;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.support.v4.app.NavUtils;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.net.URI;
import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {


    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mCafesDatabaseReference;

    private LinearLayout dotsLayout;

    private ProgressBar progressBar;
    private ViewPager slidingViewPager;
    private TextView mTextView;
    private int count = 0;


    private static final String LOG_TAG = DetailActivity.class.getSimpleName();
    private ArrayList<CustomCafes> cafes = new ArrayList<>();
    private CustomAdapter customAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);



        Intent intent = getIntent();
        String stateName = intent.getStringExtra("statename");


        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        progressBar = findViewById(R.id.progressBar);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);

        actionBar.setTitle(stateName);

        slidingViewPager = (ViewPager) findViewById(R.id.viewPager);
        dotsLayout = (LinearLayout) findViewById(R.id.dotsLayout);


        ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {


            }
        };

        slidingViewPager.addOnPageChangeListener(viewListener);


        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mCafesDatabaseReference = mFirebaseDatabase.getReference().child(stateName);

        progressBar.setVisibility(View.VISIBLE);

        mCafesDatabaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    CustomCafes c = ds.getValue(CustomCafes.class);
                    cafes.add(c);
                    ++count;
                    Log.e(LOG_TAG, "Loop executed " + count + "times");

                }
                progressBar.setVisibility(View.GONE);
                customAdapter = new CustomAdapter(getBaseContext(), cafes);
                slidingViewPager.setAdapter(customAdapter);
                customAdapter.notifyDataSetChanged();


            }


            @Override
            public void onCancelled(DatabaseError databaseError) {

                Toast.makeText(DetailActivity.this, "Could not get data , Try again later", Toast.LENGTH_SHORT).show();

            }
        });
    }






    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == android.R.id.home){
            NavUtils.navigateUpFromSameTask(this);
        }
        return true;
    }


        }

