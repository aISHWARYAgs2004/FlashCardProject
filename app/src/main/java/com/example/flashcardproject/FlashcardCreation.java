package com.example.flashcardproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class FlashcardCreation extends AppCompatActivity {
    private EditText etQuestion, etAnswer;
    private Button btnSave;
    private TextView tvTitle;

    private Flashcard flashcardToEdit;
    private boolean isEditing = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flashcard_creation);

        etQuestion = findViewById(R.id.etQuestion);
        etAnswer = findViewById(R.id.etAnswer);
        btnSave = findViewById(R.id.btnSave);
        tvTitle = findViewById(R.id.tvTitle);

        // Check if this activity was started with an existing flashcard for editing
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("flashcard")) {
            flashcardToEdit = (Flashcard) intent.getSerializableExtra("flashcard");
            if (flashcardToEdit != null) {
                isEditing = true;
                etQuestion.setText(flashcardToEdit.getQuestion());
                etAnswer.setText(flashcardToEdit.getAnswer());
                tvTitle.setText("Edit Flashcard");
            }
        }

        btnSave.setOnClickListener(v -> saveFlashcard());
    }

    private void saveFlashcard() {
        String question = etQuestion.getText().toString().trim();
        String answer = etAnswer.getText().toString().trim();

        if (question.isEmpty() || answer.isEmpty()) {
            Toast.makeText(this, "Please fill in both fields", Toast.LENGTH_SHORT).show();
            return;
        }

        if (isEditing) {
            // Update existing flashcard
            flashcardToEdit.setQuestion(question);
            flashcardToEdit.setAnswer(answer);
            // Save updated flashcard to the list or database
            Toast.makeText(this, "Flashcard updated", Toast.LENGTH_SHORT).show();
        } else {
            // Create a new flashcard
            Flashcard newFlashcard = new Flashcard(question, answer);
            // Add new flashcard to the list or database
            Toast.makeText(this, "Flashcard created", Toast.LENGTH_SHORT).show();
        }

        // Finish the activity and go back to the list
        finish();
    }
}

