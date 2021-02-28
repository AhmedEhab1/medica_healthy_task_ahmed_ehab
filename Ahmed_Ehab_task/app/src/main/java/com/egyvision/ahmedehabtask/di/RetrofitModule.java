package com.egyvision.ahmedehabtask.di;

import com.egyvision.ahmedehabtask.network.Interface;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitModule {
    public static String baseUrl ="http://medicahealthy.net" ;

    public static Interface anInterface() {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build()
                .create(Interface.class);
    }
}