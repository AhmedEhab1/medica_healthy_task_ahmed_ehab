package com.egyvision.ahmedehabtask.utilities;


import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefUtil {
    private Context context;
    private SharedPreferences prefs;

    public SharedPrefUtil(Context mContext) {
        this.context = mContext;
        prefs = this.context.getSharedPreferences("User_information", Context.MODE_PRIVATE);

    }


    public void setValueInSharePref(String keyName, String value) {
        prefs.edit().putString(keyName, value).apply();
        prefs.edit().apply();
    }
    public void isLoggedin(boolean login){
        prefs.edit().putBoolean("isLogged", login).apply();
        prefs.edit().apply();

    }
    public void deletekey(String keyName){
        SharedPreferences.Editor editor = prefs.edit();

        editor.remove(keyName);
        editor.apply();
        prefs.edit().apply();


    }

    public String getValueFromSharePref(String keyName) {
        return prefs.getString(keyName, "");
    }
    public boolean isloggedtrue(String keyName) {
        return prefs.getBoolean(keyName ,false);
    }
    public void deletedata(){
        prefs.edit().clear().apply();

    }
}

