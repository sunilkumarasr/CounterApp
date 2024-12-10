package com.provizit.counterapp.Activitys;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.provizit.counterapp.Config.ViewController;
import com.provizit.counterapp.Logins.LoginActivity;
import com.provizit.counterapp.R;
import com.provizit.counterapp.Config.Preferences;
import com.provizit.counterapp.databinding.ActivityCounterBinding;
import com.provizit.counterapp.databinding.ActivityLoginBinding;

public class DashBoardActivity extends AppCompatActivity {


    ActivityCounterBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCounterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ViewController.barPrimaryColor(DashBoardActivity.this);

        Preferences.saveStringValue(getApplicationContext(), Preferences.LOGINCHECK, "true");


    }
}