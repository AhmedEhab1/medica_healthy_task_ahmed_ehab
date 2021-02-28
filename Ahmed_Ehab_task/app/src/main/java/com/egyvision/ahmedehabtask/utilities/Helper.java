package com.egyvision.ahmedehabtask.utilities;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.egyvision.ahmedehabtask.R;

import java.util.HashMap;
import java.util.Locale;

public class Helper {
    private final Context context;
    private static Helper instance;
    String applang;
    Loading loading = new Loading();
    boolean loadingState = false;


    public Helper(@NonNull Context context) {
        this.context = context;
    }

    public static Helper getInstance(@NonNull Context context) {
        synchronized (Helper.class) {
            if (instance == null) {
                instance = new Helper(context);
            }
            return instance;
        }
    }


    public void setLanguage() {
        SharedPrefUtil sharedPrefUtil = new SharedPrefUtil(context);
        String applang = sharedPrefUtil.getValueFromSharePref("appLang");
        if (applang.equals("")) {
            applang = "en";
        }
        setLocale();
        Configuration configuration = context.getResources().getConfiguration();
        configuration.setLayoutDirection(new Locale(applang.toLowerCase()));
        context.getResources().updateConfiguration(configuration, context.getResources().getDisplayMetrics());
    }

    public void setLocale() {
        SharedPrefUtil sharedPrefUtil = new SharedPrefUtil(context);
        String applang = sharedPrefUtil.getValueFromSharePref("appLang");
        if (applang.equals("")) {
            applang = "en";
        }
        Locale myLocale = new Locale(applang);
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        Configuration conf = context.getResources().getConfiguration();
        conf.locale = myLocale;
        context.getResources().updateConfiguration(conf, dm);
    }


    public HashMap<String, String> header() {
        SharedPrefUtil sharedPrefUtil = new SharedPrefUtil(context);
        applang = sharedPrefUtil.getValueFromSharePref("appLang");

        HashMap<String, String> map2 = new HashMap<>();
        map2.put("Accept", "application/json");
        map2.put("Content-Type", "text/plain");
        map2.put("From", "c213348c8e34e7dd");
        map2.put("User-Agent", "android");
        map2.put("Accept-Language", "en");
        return map2;
    }

    public HashMap<String, String> reservationHeader() {
        SharedPrefUtil sharedPrefUtil = new SharedPrefUtil(context);
        applang = sharedPrefUtil.getValueFromSharePref("appLang");
        String accessToken = sharedPrefUtil.getValueFromSharePref("accessToken");

        HashMap<String, String> map2 = new HashMap<>();
        map2.put("Accept", "application/json");
        map2.put("Content-Type", "text/plain");
        map2.put("From", "c213348c8e34e7dd");
        map2.put("User-Agent", "android");
        map2.put("Accept-Language", "en");
        map2.put("Institution", "699");
        map2.put("Authorizations", "xkKrXLEbSXXt9oAXrFElvmhytze2PIOhlgOm4QpAapv1uCxq3my9bv42N6iA");//accessToken
        return map2;
    }

    public String getLanguage() {
        SharedPrefUtil sharedPrefUtil = new SharedPrefUtil(context);
        applang = sharedPrefUtil.getValueFromSharePref("appLang");
        return applang;
    }

    public void getError(Throwable error) {
        Log.e("viewModel", error.getMessage());

    }

    public void showAlertMessage(String title, String body) {
        Bundle bundle = new Bundle();
        if (title != null) {
            bundle.putString("title", title);
        }
        if (body != null) {
            bundle.putString("message", body);
        }
        FragmentActivity activity = (FragmentActivity) (context);
        FragmentManager fm = activity.getSupportFragmentManager();

        ErrorDialog errorDialog = new ErrorDialog();
        errorDialog.setArguments(bundle);
        errorDialog.show(fm, "fragment_alert");

    }

    public void showLoading() {
        if (!loadingState) {
            try {
                FragmentActivity activity = (FragmentActivity) (context);
                FragmentManager fm = activity.getSupportFragmentManager();
                if (loading.getDialog() == null) {
                    loading.show(fm, "fragment_alert");
                }
            } catch (Exception e) {
                Log.d("showLoadingError", "showLoading: " + e);
            }
            setState(true);

        }

    }

    public void setState(Boolean b) {
        loadingState = b;
    }

    public void dismissLoading() {
        try {
            if (loading.getDialog() != null) {
                loading.dismiss();
                loading.getDialog().dismiss();
                loading.closeFragment();
                setState(false);

            }
        } catch (Exception e) {
            Log.d("dismissLoadingError", "dismissLoading: " + e);
        }
        setState(false);

    }

    public void uploadeImage(String url, ProgressBar progressBar, ImageView imageView) {
        try {
            Glide.with(context)
                    .load(url)
                    .listener(new RequestListener<Drawable>() {
                        @Override
                        public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                            progressBar.setVisibility(View.GONE);
                            return false;
                        }

                        @Override
                        public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                            progressBar.setVisibility(View.GONE);
                            return false;
                        }
                    })
                    .into(imageView);
        } catch (Exception e) {
            imageView.setImageResource(R.drawable.logo);
        }

    }
}
