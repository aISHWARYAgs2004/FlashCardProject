package com.example.flashcardproject;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;

public class FlashcardViewActivity extends AppCompatActivity {
    private TextView tvFlashcard;
    private Button btnFlip, btnShuffle, btnMarkKnown;
    private ArrayList<Flashcard> flashcards;
    private int currentIndex = 0;
    private boolean isShowingQuestion = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flashcard_view);

        // Initialize components
        tvFlashcard = findViewById(R.id.tvFlashcard);
        btnFlip = findViewById(R.id.btnFlip);
        btnShuffle = findViewById(R.id.btnShuffle);
        btnMarkKnown = findViewById(R.id.btnMarkKnown);

        // Dummy data for flashcards (replace with data from database/Firebase)
        flashcards = new ArrayList<>();
        flashcards.add(new Flashcard("What is the capital of France?", "Paris"));
        flashcards.add(new Flashcard("What is the square root of 16?", "4"));
        flashcards.add(new Flashcard("Who wrote 'To be, or not to be'?", "Shakespeare"));

        if (!flashcards.isEmpty()) {
            displayFlashcard();
        } else {
            Toast.makeText(this, "No flashcards available", Toast.LENGTH_SHORT).show();
        }

        // Set up button listeners
        btnFlip.setOnClickListener(v -> flipFlashcard());
        btnShuffle.setOnClickListener(v -> shuffleFlashcards());
        btnMarkKnown.setOnClickListener(v -> markFlashcardAsKnown());
    }

    private void displayFlashcard() {
        if (flashcards.isEmpty()) return;

        Flashcard currentFlashcard = flashcards.get(currentIndex);
        if (isShowingQuestion) {
            tvFlashcard.setText(currentFlashcard.getQuestion());
        } else {
            tvFlashcard.setText(currentFlashcard.getAnswer());
        }
    }

    private void flipFlashcard() {
        isShowingQuestion = !isShowingQuestion;

        // Flip animation effect
        AlphaAnimation fadeOut = new AlphaAnimation(1.0f, 0.0f);
        fadeOut.setDuration(200);
        fadeOut.setFillAfter(true);
        fadeOut.setAnimationListener(new android.view.animation.Animation.AnimationListener() {
            @Override
            public void onAnimationStart(android.view.animation.Animation animation) { }

            @Override
            public void onAnimationEnd(android.view.animation.Animation animation) {
                // Change text to answer or question after fade out
                displayFlashcard();

                // Fade in animation
                AlphaAnimation fadeIn = new AlphaAnimation(0.0f, 1.0f);
                fadeIn.setDuration(200);
                fadeIn.setFillAfter(true);
                tvFlashcard.startAnimation(fadeIn);
            }

            @Override
            public void onAnimationRepeat(android.view.animation.Animation animation) { }
        });
        tvFlashcard.startAnimation(fadeOut);
    }

    private void shuffleFlashcards() {
        Collections.shuffle(flashcards);
        currentIndex = 0;
        isShowingQuestion = true;
        displayFlashcard();
        Toast.makeText(this, "Flashcards shuffled", Toast.LENGTH_SHORT).show();
    }

    private void markFlashcardAsKnown() {
        Flashcard currentFlashcard = flashcards.get(currentIndex);
        currentFlashcard.setKnown(true);
        Toast.makeText(this, "Marked as known", Toast.LENGTH_SHORT).show();

        // Move to the next flashcard if there are more
        if (currentIndex < flashcards.size() - 1) {
            currentIndex++;
            isShowingQuestion = true;
            displayFlashcard();
        } else {
            Toast.makeText(this, "You've reviewed all flashcards!", Toast.LENGTH_LONG).show();
        }
    }
}

