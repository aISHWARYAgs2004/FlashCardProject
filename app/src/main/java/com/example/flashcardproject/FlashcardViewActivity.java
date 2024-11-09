package com.example.flashcardproject;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FlashcardViewActivity extends AppCompatActivity {
    private TextView flashcardText;
    private boolean isQuestion = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flashcard_view);

        flashcardText = findViewById(R.id.flashcardText);

        flashcardText.setOnClickListener(view -> {
            if (isQuestion) {
                // Display answer with flip animation
            } else {
                // Display question with flip animation
            }
            isQuestion = !isQuestion;
        });
    }
}

