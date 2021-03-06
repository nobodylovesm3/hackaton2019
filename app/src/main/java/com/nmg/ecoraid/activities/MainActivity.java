package com.nmg.ecoraid.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.nmg.ecoraid.R;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setFullScreen();
        ImageView loginBtn = findViewById(R.id.btn_login);
        ImageView registerBtn = findViewById(R.id.btn_register);

        loginBtn.setOnClickListener(v -> goToLoginActivity());
        registerBtn.setOnClickListener(v -> goToRegisterActivity());
    }

    private void goToRegisterActivity() {
        Intent startIntent = new Intent(getApplicationContext(), RegisterActivity.class);
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

    private void goToLoginActivity() {
        Intent startIntent = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(startIntent);
    }
}
