package com.example.flashcardproject;


import java.io.Serializable;

public class Flashcard implements Serializable {
    private String question;
    private String answer;
    private boolean isKnown;

    // Constructor
    public Flashcard(String question, String answer) {
        this.question = question;
        this.answer = answer;
        this.isKnown = false; // Default to not known
    }

    // Getter and Setter for Question
    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    // Getter and Setter for Answer
    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    // Getter and Setter for isKnown (optional for Mark as Known feature)
    public boolean isKnown() {
        return isKnown;
    }

    public void setKnown(boolean known) {
        isKnown = known;
    }
}
