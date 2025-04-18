package com.provizit.counterapp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.provizit.counterapp.Config.ViewController;
import com.provizit.counterapp.Logins.LoginActivity;
import com.provizit.counterapp.R;
import com.provizit.counterapp.Config.Preferences;
import com.provizit.counterapp.databinding.ActivitySplashScreenBinding;

public class SplashScreenActivity extends AppCompatActivity {

    ActivitySplashScreenBinding binding;

    Animation animationUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySplashScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewController.changeStatusBarColor(
                this,
                ContextCompat.getColor(SplashScreenActivity.this, R.color.white),
                false);

        splashAnimation();

    }

    public void splashAnimation() {
        String LOGINCHECK = Preferences.loadStringValue(getApplicationContext(), Preferences.LOGINCHECK, "");

        animationUp = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_up);
        binding.upImage.setAnimation(animationUp);
        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(3000);
                } catch (Exception ignored) {
                } finally {
                    if (LOGINCHECK.equals("true")) {
                        Intent intent = new Intent(SplashScreenActivity.this, DashBoardActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                        finish();
                    } else {
                        Intent intent = new Intent(SplashScreenActivity.this, LoginActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                        finish();
                    }
                }
            }
        };
        t.start();
    }

}