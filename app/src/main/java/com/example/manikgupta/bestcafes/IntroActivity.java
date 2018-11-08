package com.example.manikgupta.bestcafes;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class IntroActivity extends AppCompatActivity {

    private TextView getStartedTextView;

    private ImageView logo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_intro);

        getStartedTextView = findViewById(R.id.get_started_button);
        logo = findViewById(R.id.logo);

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        getStartedTextView.startAnimation(animation);
        logo.startAnimation(animation);

        ActionBar actionBar = getSupportActionBar();

        actionBar.setTitle(getString(R.string.intro));

        if (actionBar != null) {
            actionBar.hide();
        }

        getStartedTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(IntroActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });



    }
}
