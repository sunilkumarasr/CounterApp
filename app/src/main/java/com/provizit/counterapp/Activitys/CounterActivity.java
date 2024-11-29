package com.provizit.counterapp.Activitys;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.provizit.counterapp.R;
import com.provizit.counterapp.Config.Preferences;

public class CounterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);

        Preferences.saveStringValue(getApplicationContext(), Preferences.LOGINCHECK, "true");


    }
}