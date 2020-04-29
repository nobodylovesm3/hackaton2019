package com.nmg.ecoraid.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.nmg.ecoraid.R;

public class NavigationActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_layout);

        ImageView raidsButton = findViewById(R.id.btn_raids);
        ImageView snapButton = findViewById(R.id.btn_snap);
        ImageView rankingButton = findViewById(R.id.btn_rank);
        setFullScreen();

        raidsButton.setOnClickListener(v -> goToRaidsActivity());
        snapButton.setOnClickListener(v -> goToSnapActivity());
        rankingButton.setOnClickListener(v -> goToRankingActivity());
    }


    private void goToRankingActivity() {
        Intent startIntent = new Intent(getApplicationContext(), RankingSelectorActivity.class);
        startActivity(startIntent);
    }

    private void goToRaidsActivity() {
        Intent startIntent = new Intent(getApplicationContext(), RaidsActivity.class);
        startActivity(startIntent);
    }

    private void goToSnapActivity() {
        Intent startIntent = new Intent(getApplicationContext(), SubmitDataActivity.class);
        startActivity(startIntent);
    }

    private void setFullScreen() {
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
        );
    }
}
