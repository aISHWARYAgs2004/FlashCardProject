package com.example.flashcardproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button btnAddFlashcard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the Add Flashcard button
        btnAddFlashcard = findViewById(R.id.btnAddFlashcard);

        btnAddFlashcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start FlashcardCreationActivity when the button is clicked
                Intent intent = new Intent(MainActivity.this, FlashcardCreation.class);
                startActivity(intent);
            }
        });
    }
}



