package com.h5170043.muhammed_cagatay_mercan.ui.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.h5170043.muhammed_cagatay_mercan.R;
import com.h5170043.muhammed_cagatay_mercan.ui.category.CategoryActivity;
import com.h5170043.muhammed_cagatay_mercan.utils.AppPreferences;

public class LoginActivity extends AppCompatActivity {

    private Button btn_next;
    private EditText txt_login_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initViews();
        handleButtonEvent();
    }

    private void handleButtonEvent() {
        btn_next.setOnClickListener(view -> {
            String name = getPlayerName();
            saveName(name);
            navigateToCategoryActivity();
        });
    }

    private String getPlayerName() {
        String name = txt_login_name.getText().toString();
        if (name.isEmpty()){
            name = getString(R.string.login_empty_name);
        }
        return name;
    }

    private void saveName(String name) {
        AppPreferences appPreferences = new AppPreferences(this);
        appPreferences.savePlayerName(name);
    }

    private void navigateToCategoryActivity() {
        Intent intent = new Intent(this, CategoryActivity.class);
        startActivity(intent);
        finish();
    }

    private void initViews() {
        btn_next = findViewById(R.id.btn_login_next);
        txt_login_name = findViewById(R.id.txt_login_name);
    }
}