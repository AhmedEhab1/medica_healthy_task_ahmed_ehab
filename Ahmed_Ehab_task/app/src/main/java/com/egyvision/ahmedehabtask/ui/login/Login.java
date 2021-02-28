package com.egyvision.ahmedehabtask.ui.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.egyvision.ahmedehabtask.R;
import com.egyvision.ahmedehabtask.databinding.ActivityLoginBinding;
import com.egyvision.ahmedehabtask.model.login.LoginModel;
import com.egyvision.ahmedehabtask.ui.homescreen.HomeScreen;
import com.egyvision.ahmedehabtask.utilities.Helper;
import com.egyvision.ahmedehabtask.utilities.SharedPrefUtil;

import java.util.HashMap;


public class Login extends AppCompatActivity implements LoginView {
    LoginPresenter presenter;
    ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        Helper.getInstance(this).setLanguage();
        presenter = new LoginPresenter(this, this);

        binding.loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });

    }

    public void login() {
        String mobile = binding.mobile.getText().toString();
        String password = binding.password.getText().toString();
        HashMap<String, String> map = new HashMap<>();
        map.put("mobile", mobile);
        map.put("password", password);
        Helper.getInstance(this).showLoading();
        presenter.getData(Helper.getInstance(this).header(), map);

    }


    @Override
    public void onGetData(LoginModel loginModel) {
        if (loginModel.getCode() == 100) {
            SharedPrefUtil sharedPrefUtil = new SharedPrefUtil(Login.this);
            sharedPrefUtil.setValueInSharePref("accessToken", String.valueOf(loginModel.getItem().getAuthorization()));

            Intent intent = new Intent(Login.this, HomeScreen.class);
            startActivity(intent);
            finish();
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        } else {
            Helper.getInstance(this).showAlertMessage(getResources().getString(R.string.notice), loginModel.getMessage());
        }
    }


    //To close keybord
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (getCurrentFocus() != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
        return super.dispatchTouchEvent(ev);
    }
}