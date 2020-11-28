package com.h5170043.muhammed_cagatay_mercan.ui.category;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.h5170043.muhammed_cagatay_mercan.R;
import com.h5170043.muhammed_cagatay_mercan.utils.AppPreferences;

public class CategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        String name = new AppPreferences(this).getPlayerName();
        Log.e("TAG", "onCreate: " + name);
    }
}