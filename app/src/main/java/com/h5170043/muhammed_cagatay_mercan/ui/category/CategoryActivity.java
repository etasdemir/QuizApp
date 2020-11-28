package com.h5170043.muhammed_cagatay_mercan.ui.category;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.h5170043.muhammed_cagatay_mercan.R;
import com.h5170043.muhammed_cagatay_mercan.ui.game.GameActivity;
import com.h5170043.muhammed_cagatay_mercan.utils.AppPreferences;
import com.h5170043.muhammed_cagatay_mercan.utils.Category;
import com.h5170043.muhammed_cagatay_mercan.utils.Constants;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class CategoryActivity extends AppCompatActivity {

    TextView txt_category_name;
    Button btn_category_tech;
    Button btn_category_science;
    Button btn_exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        initViews();
        setPlayerName();
        handleCategoryButtons();
        handleButtonExit();
    }

    private void setPlayerName() {
        AppPreferences appPreferences = new AppPreferences(this);
        String name = appPreferences.getPlayerName();
        txt_category_name.setText(name);
    }

    private void handleCategoryButtons() {
        btn_category_science.setOnClickListener( view ->
                navigateToGameActivity(Category.Science));

        btn_category_tech.setOnClickListener( view ->
                navigateToGameActivity(Category.Tech));
    }

    private void navigateToGameActivity(Category category){
        Intent intent = new Intent(this, GameActivity.class);
        intent.putExtra(Constants.categoryNameKey, category);
        startActivity(intent);
        finish();
    }

    private void handleButtonExit() {
        btn_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createExitAlertDialog();
            }
        });
    }

    private void createExitAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.category_alert_message)
                .setCancelable(false)
                .setPositiveButton(R.string.category_alert_yes, (dialogInterface, i) -> {
                    finish();
                })
                .setNegativeButton(R.string.category_alert_no, (dialogInterface, i) -> {
                    dialogInterface.dismiss();
                });
        AlertDialog dialog = builder.create();
        dialog.setTitle(R.string.category_alert_title);
        dialog.show();
    }

    private void initViews() {
        txt_category_name = findViewById(R.id.txt_category_name);
        btn_category_tech = findViewById(R.id.btn_category_tech);
        btn_category_science = findViewById(R.id.btn_category_science);
        btn_exit = findViewById(R.id.btn_category_exit);
    }
}