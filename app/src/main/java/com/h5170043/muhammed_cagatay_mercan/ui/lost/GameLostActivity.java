package com.h5170043.muhammed_cagatay_mercan.ui.lost;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.h5170043.muhammed_cagatay_mercan.R;
import com.h5170043.muhammed_cagatay_mercan.ui.category.CategoryActivity;
import com.h5170043.muhammed_cagatay_mercan.utils.Constants;

import androidx.appcompat.app.AppCompatActivity;

public class GameLostActivity extends AppCompatActivity {

    TextView txt_question_num;
    TextView txt_score;
    Button btn_return;
    Button btn_exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_lost);

        initViews();
        getArgs();

        btn_return.setOnClickListener((view -> navigateToCategory()));
        btn_exit.setOnClickListener((view -> finish()));
    }

    private void getArgs() {
        Intent intent = getIntent();
        int score = intent.getIntExtra(Constants.gameScoreKey, 0);
        int questionNum = intent.getIntExtra(Constants.gameCurrentQuestionKey, 0);
        int totalQuestion = intent.getIntExtra(Constants.gameTotalQuestionKey, 0);

        setViews(score, questionNum, totalQuestion);
    }

    private void setViews(int score, int questionNum, int totalQuestion) {
        String questionNumber = questionNum + "/" + totalQuestion;
        txt_score.setText(String.valueOf(score));
        txt_question_num.setText(questionNumber);
    }

    private void navigateToCategory() {
        Intent intent = new Intent(this, CategoryActivity.class);
        startActivity(intent);
        finish();
    }


    private void initViews() {
        txt_question_num = findViewById(R.id.txt_game_lost_question_num);
        txt_score = findViewById(R.id.txt_game_lost_score);
        btn_return = findViewById(R.id.btn_game_lost_return);
        btn_exit = findViewById(R.id.btn_game_lost_exit);
    }
}