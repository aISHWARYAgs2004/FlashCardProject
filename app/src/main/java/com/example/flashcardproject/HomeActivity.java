package com.example.flashcardproject;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class HomeActivity extends AppCompatActivity {
    private RecyclerView flashcardRecyclerView;
    private FloatingActionButton addFlashcardButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        flashcardRecyclerView = findViewById(R.id.flashcardRecyclerView);
        addFlashcardButton = findViewById(R.id.addFlashcardButton);

        // RecyclerView setup, Firebase data retrieval, and flashcard list population here

        addFlashcardButton.setOnClickListener(view -> {
            // Open Flashcard Creation Screen
        });
    }
}

