package com.example.flashcardproject;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class FlashScreenActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flash_screen);

        new Handler().postDelayed(() -> {
            Intent intent = new Intent(FlashScreenActivity.this, HomeActivity.class);
            startActivity(intent);
            finish();
        }, 2000); // Display for 2 seconds
    }
}

