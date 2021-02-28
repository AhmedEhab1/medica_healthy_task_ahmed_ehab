package com.egyvision.ahmedehabtask.ui.splash;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.TranslateAnimation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.egyvision.ahmedehabtask.R;
import com.egyvision.ahmedehabtask.databinding.ActivityMainBinding;
import com.egyvision.ahmedehabtask.ui.homescreen.HomeScreen;
import com.egyvision.ahmedehabtask.ui.login.Login;
import com.egyvision.ahmedehabtask.utilities.SharedPrefUtil;

public class MainActivity extends AppCompatActivity {
    private final int SPLASH_DISPLAY_LENGTH = 2700;
    String accessToken = "";
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.mainView.setClipToOutline(true);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimary, this.getTheme()));
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimary));
        }

        loading(binding.loadingShape);
        userToken();
    }

    // check if user log in
    public void userToken() {
        SharedPrefUtil sharedPrefUtil = new SharedPrefUtil(MainActivity.this);
        accessToken = sharedPrefUtil.getValueFromSharePref("accessToken");
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (accessToken.equals("")) {
                    /* Create an Intent that will start the Menu-Activity. */
                    Intent mainIntent = new Intent(MainActivity.this, Login.class);
                    MainActivity.this.startActivity(mainIntent);
                    MainActivity.this.finish();
                    overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_up);

                } else {
                    Intent mainIntent = new Intent(MainActivity.this, HomeScreen.class);
                    MainActivity.this.startActivity(mainIntent);
                    MainActivity.this.finish();
                    overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_up);

                }

            }
        }, SPLASH_DISPLAY_LENGTH);

    }

    public void loading(View view) {
        view.setVisibility(View.VISIBLE);
        view.setElevation(100);
        TranslateAnimation animate = new TranslateAnimation(
                0,                 // fromXDelta
                1000,                 // toXDelta
                0,  // fromYDelta
                0);// toYDelta
        animate.setDuration(3200);
        animate.setFillAfter(true);
        view.startAnimation(animate);
    }

}