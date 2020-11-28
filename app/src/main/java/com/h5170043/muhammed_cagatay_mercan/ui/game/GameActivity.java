package com.h5170043.muhammed_cagatay_mercan.ui.game;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.h5170043.muhammed_cagatay_mercan.R;
import com.h5170043.muhammed_cagatay_mercan.model.Question;
import com.h5170043.muhammed_cagatay_mercan.ui.category.CategoryActivity;
import com.h5170043.muhammed_cagatay_mercan.ui.lost.GameLostActivity;
import com.h5170043.muhammed_cagatay_mercan.ui.won.GameWonActivity;
import com.h5170043.muhammed_cagatay_mercan.utils.Category;
import com.h5170043.muhammed_cagatay_mercan.utils.Constants;
import com.h5170043.muhammed_cagatay_mercan.utils.QuestionGenerator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class GameActivity extends AppCompatActivity {
    private Category category;
    private int score = 0;
    private int currentQuestionNum = 1;
    private int totalQuestion;

    private TextView txt_category;
    private TextView txt_score;
    private TextView txt_question_number;
    private TextView txt_question;
    private Button btn_first;
    private Button btn_second;
    private Button btn_third;
    private Button btn_last;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        initViews();
        getCategory();
        setCategoryTitle();
        getTotalQuestionNumber();
        getNextQuestion();
        updateView();
    }

    private void getCategory() {
        Intent intent = getIntent();
        category = ((Category) intent.getSerializableExtra(Constants.categoryNameKey));
    }

    private void getTotalQuestionNumber() {
        totalQuestion = QuestionGenerator.getTotalQuestionNumber(category);
    }

    private void getNextQuestion() {
        int index = currentQuestionNum - 1;
        Question question = QuestionGenerator.getQuestionByCategoryName(category, index);
        setViewWithQuestion(question);
    }

    private void setViewWithQuestion(Question question) {
        txt_question.setText(question.getQuestion());
        btn_first.setText(question.getChoices()[0]);
        btn_second.setText(question.getChoices()[1]);
        btn_third.setText(question.getChoices()[2]);
        btn_last.setText(question.getChoices()[3]);
        handleClickEvents(question.getAnswer());
    }

    private void handleClickEvents(String answer) {
        Button correctButton = getCorrectButton(answer);
        btn_first.setOnClickListener(button -> handleButton((Button) button, correctButton));
        btn_second.setOnClickListener(button -> handleButton((Button) button, correctButton));
        btn_third.setOnClickListener(button -> handleButton((Button) button, correctButton));
        btn_last.setOnClickListener(button -> handleButton((Button) button, correctButton));
    }

    private Button getCorrectButton(String answer){
        if (isAnswerCorrect(btn_first, answer)){
            return btn_first;
        } else if (isAnswerCorrect(btn_second, answer)){
            return btn_second;
        } else if (isAnswerCorrect(btn_third, answer)){
            return btn_third;
        } else {
            return btn_last;
        }
    }

    private boolean isAnswerCorrect(Button button, String answer){
        return button.getText().equals(answer);
    }

    private void handleButton(Button button, Button correctButton) {
        button.setBackgroundColor(getResources().getColor(R.color.red));
        correctButton.setBackgroundColor(getResources().getColor(R.color.green));

        CountDownTimer timer = new CountDownTimer(1000, 1000) {
            @Override
            public void onTick(long l) { }

            @Override
            public void onFinish() {
                try {
                    if (button != correctButton){
                        navigateToGameLostActivity();
                    } else {
                        handleCorrectAnswer();
                    }
                } catch (Exception e) {
                    Log.e("GameActivity", e.getMessage());
                }
            }
        };
        timer.start();
    }

    private void navigateToGameLostActivity(){
        Intent intent = new Intent(this, GameLostActivity.class);
        intent.putExtra(Constants.gameCurrentQuestionKey, currentQuestionNum);
        intent.putExtra(Constants.gameTotalQuestionKey, totalQuestion);
        intent.putExtra(Constants.gameScoreKey, score);
        startActivity(intent);
        finish();
    }

    private void handleCorrectAnswer() {
        score = currentQuestionNum * 100;
        if (currentQuestionNum == totalQuestion) {
            navigateToGameWonActivity();
        } else {
            createCorrectAnswerDialog();
        }
        currentQuestionNum++;
    }

    private void createCorrectAnswerDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false)
                .setPositiveButton(R.string.game_dialog_continue, (dialogInterface, i) -> {
                    updateView();
                    getNextQuestion();
                    dialogInterface.dismiss();
                })
                .setNegativeButton(R.string.game_dialog_exit, (dialogInterface, i) ->
                        navigateToCategoryActivity());
        AlertDialog dialog = builder.create();
        dialog.setTitle(R.string.game_dialog_title);
        dialog.show();
    }

    private void navigateToGameWonActivity() {
        Intent intent = new Intent(this, GameWonActivity.class);
        intent.putExtra(Constants.gameTotalQuestionKey, totalQuestion);
        intent.putExtra(Constants.gameScoreKey, score);
        startActivity(intent);
        finish();
    }

    private void updateView() {
        txt_score.setText(String.valueOf(score));
        String questionNum = currentQuestionNum + "/" + totalQuestion;
        txt_question_number.setText(questionNum);
        btn_first.setBackgroundColor(getResources().getColor(R.color.primaryColor));
        btn_second.setBackgroundColor(getResources().getColor(R.color.primaryColor));
        btn_third.setBackgroundColor(getResources().getColor(R.color.primaryColor));
        btn_last.setBackgroundColor(getResources().getColor(R.color.primaryColor));
    }

    private void navigateToCategoryActivity() {
        Intent intent = new Intent(this, CategoryActivity.class);
        startActivity(intent);
        finish();
    }

    private void setCategoryTitle() {
        if (category == Category.Science) {
            txt_category.setText(getString(R.string.category_science));
        } else {
            txt_category.setText(getString(R.string.category_tech));
        }
    }

    private void initViews() {
        txt_category = findViewById(R.id.txt_game_title);
        txt_score = findViewById(R.id.txt_game_score);
        txt_question_number = findViewById(R.id.txt_game_question_num);
        txt_question = findViewById(R.id.txt_game_question);
        btn_first = findViewById(R.id.btn_game_first_choice);
        btn_second = findViewById(R.id.btn_game_second_choice);
        btn_third = findViewById(R.id.btn_game_third_choice);
        btn_last = findViewById(R.id.btn_game_fourth_choice);
    }

}