package com.h5170043.muhammed_cagatay_mercan.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import com.h5170043.muhammed_cagatay_mercan.R;

public class AppPreferences {
    private static final String APP_SHARED_PREFS = "Shared Pref";
    private static final String KEY_PREFS_PLAYER_NAME = "Key Player Name";

    private final Context context;
    private final SharedPreferences sharedPref;
    private final SharedPreferences.Editor prefEditor;

    @SuppressLint("CommitPrefEdits")
    public AppPreferences(Context context) {
        this.context = context;
        sharedPref = context.getSharedPreferences(APP_SHARED_PREFS, Activity.MODE_PRIVATE);
        prefEditor = sharedPref.edit();
    }

    public void savePlayerName(String name) {
        prefEditor.putString(KEY_PREFS_PLAYER_NAME, name);
        prefEditor.commit();
    }

    public String getPlayerName() {
        return sharedPref.getString(
                        KEY_PREFS_PLAYER_NAME,
                        context.getString(R.string.login_empty_name)
                );
    }
}
