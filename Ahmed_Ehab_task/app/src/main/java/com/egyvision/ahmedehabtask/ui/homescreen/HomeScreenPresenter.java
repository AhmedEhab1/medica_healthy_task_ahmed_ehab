package com.egyvision.ahmedehabtask.ui.homescreen;

import android.content.Context;
import android.util.Log;

import com.egyvision.ahmedehabtask.di.RetrofitModule;
import com.egyvision.ahmedehabtask.model.ListBranches;
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
import retrofit2.Response;

public class HomeScreenPresenter {
    HomeScreenView view;
    Context context ;

    public HomeScreenPresenter(HomeScreenView view , Context context) {
        this.view = view;
        this.context = context;
    }

    public void getData(HashMap<String, String> header, HashMap<String, String> map) {
        try {
            Observable<Response<ListBranches>> observable = RetrofitModule.anInterface().getBranches(map ,header);
            observable
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Subject<Response<ListBranches>>() {
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
                        protected void subscribeActual(@NonNull Observer<? super Response<ListBranches>> observer) {

                        }

                        @Override
                        public void onSubscribe(@NonNull Disposable d) {

                        }

                        @Override
                        public void onNext(@NonNull Response<ListBranches> listBranches) {
                            Helper.getInstance(context).dismissLoading();
                            setData(listBranches);
                        }

                        @Override
                        public void onError(@NonNull Throwable e) {
                            Log.d("loginerror", "getData: error  " + e);
                            Helper.getInstance(context).dismissLoading();
                        }

                        @Override
                        public void onComplete() {
                        }
                    });


        } catch (Exception e) {
            Log.d("loginerror", "catch error : " + e);
            Helper.getInstance(context).dismissLoading();
        }
    }

    public void setData(Response<ListBranches> listBranches) {
        view.onGetData(listBranches);
    }
}
