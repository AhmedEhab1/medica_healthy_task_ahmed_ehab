package com.egyvision.ahmedehabtask.ui.institutionsmap;

import android.content.Context;
import android.util.Log;

import com.egyvision.ahmedehabtask.di.RetrofitModule;
import com.egyvision.ahmedehabtask.model.maps.MapsCall;
import com.egyvision.ahmedehabtask.utilities.Helper;

import java.util.HashMap;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import io.reactivex.rxjava3.subjects.Subject;

public class MapsPresenter {
    MapsView view;
    Context context ;

    public MapsPresenter(MapsView view , Context context) {
        this.view = view;
        this.context = context;
    }

    public void getData(HashMap<String, String> header, HashMap<String, String> map) {
        try {
            Observable<MapsCall> observable = RetrofitModule.anInterface().mapsCall(map,header);
            observable
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Subject<MapsCall>() {
                        @Override
                        protected void subscribeActual(@NonNull Observer<? super MapsCall> observer) {
                        }

                        @Override
                        public boolean hasObservers() {
                            return false;
                        }

                        @Override
                        public boolean hasThrowable() {
                            return false;
                        }

                        @Override
                        public boolean hasComplete() {
                            return false;
                        }

                        @Override
                        public @Nullable Throwable getThrowable() {
                            return null;
                        }

                        @Override
                        public void onSubscribe(@NonNull Disposable d) {

                        }

                        @Override
                        public void onNext(@NonNull MapsCall mapsCall) {
                            Helper.getInstance(context).dismissLoading();
                            setData(mapsCall);
                        }

                        @Override
                        public void onError(@NonNull Throwable e) {
                            Log.d("loginerror", "getData: error" + e);
                            Helper.getInstance(context).dismissLoading();
                        }

                        @Override
                        public void onComplete() {

                        }
                    });

        } catch (Exception e) {
            Log.d("loginerror", "error : " + e);
            Helper.getInstance(context).dismissLoading();
        }

    }

    public void setData(MapsCall mapsCall) {
        view.onGetData(mapsCall);
    }
}

