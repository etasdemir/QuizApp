package com.h5170043.muhammed_cagatay_mercan.model;

public class Question {
    private String question;
    private String answer;
    private String[] choices;

    Question(String question, String answer, String[] choices){
        this.question = question;
        this.answer = answer;
        this.choices = choices;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String[] getChoices() {
        return choices;
    }

    public void setChoices(String[] choices) {
        this.choices = choices;
    }
}
