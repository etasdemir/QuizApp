package com.h5170043.muhammed_cagatay_mercan.ui.won;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.h5170043.muhammed_cagatay_mercan.R;
import com.h5170043.muhammed_cagatay_mercan.ui.category.CategoryActivity;
import com.h5170043.muhammed_cagatay_mercan.utils.Constants;

import androidx.appcompat.app.AppCompatActivity;

public class GameWonActivity extends AppCompatActivity {

    TextView txt_score;
    TextView txt_question_num;
    Button btn_return;
    Button btn_exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_won);

        initViews();
        getArgs();

        btn_return.setOnClickListener(view -> navigateToCategory());
        btn_exit.setOnClickListener(view -> finish());
    }

    private void navigateToCategory() {
        Intent intent = new Intent(this, CategoryActivity.class);
        startActivity(intent);
        finish();
    }

    private void getArgs() {
        Intent intent = getIntent();
        int score = intent.getIntExtra(Constants.gameScoreKey, 0);
        int totalQuestion = intent.getIntExtra(Constants.gameTotalQuestionKey, 0);
        setViews(score, totalQuestion);
    }

    private void setViews(int score, int totalQuestion) {
        String questionNumber = totalQuestion + "/" + totalQuestion;
        txt_score.setText(String.valueOf(score));
        txt_question_num.setText(questionNumber);
    }

    private void initViews() {
        txt_score = findViewById(R.id.txt_game_won_score);
        txt_question_num = findViewById(R.id.txt_game_won_question_num);
        btn_return = findViewById(R.id.btn_game_won_return);
        btn_exit = findViewById(R.id.btn_game_won_exit);
    }
}