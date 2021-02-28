package com.egyvision.ahmedehabtask.ui.branchdetails;

import android.content.Context;
import android.util.Log;

import com.egyvision.ahmedehabtask.di.RetrofitModule;
import com.egyvision.ahmedehabtask.model.branchdate.BranchDateCall;
import com.egyvision.ahmedehabtask.model.branchdetails.BranchDetailsModel;
import com.egyvision.ahmedehabtask.model.branchdetails.BranchDetailsView;
import com.egyvision.ahmedehabtask.model.branchtime.BranchTimeCall;
import com.egyvision.ahmedehabtask.model.doctors.DoctorsCall;
import com.egyvision.ahmedehabtask.model.reservation.ReservationCall;
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

public class BranchDetailsPresenter {
    BranchDetailsView view;
    Context context;

    public BranchDetailsPresenter(BranchDetailsView view, Context context) {
        this.view = view;
        this.context = context;
    }

    public void getData(HashMap<String, String> header, HashMap<String, String> map) {
        try {
            Observable<Response<BranchDetailsModel>> observable = RetrofitModule.anInterface().getDepartments(map, header);
            observable
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Subject<Response<BranchDetailsModel>>() {
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
                        protected void subscribeActual(@NonNull Observer<? super Response<BranchDetailsModel>> observer) {

                        }

                        @Override
                        public void onSubscribe(@NonNull Disposable d) {

                        }

                        @Override
                        public void onNext(@NonNull Response<BranchDetailsModel> branchDetailsModelResponse) {
                            Helper.getInstance(context).dismissLoading();
                            setData(branchDetailsModelResponse);
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

    public void getDoctorsData(HashMap<String, String> header, HashMap<String, String> map) {
        try {
            Observable<Response<DoctorsCall>> observable = RetrofitModule.anInterface().getDoctors(map, header);
            observable
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Subject<Response<DoctorsCall>>() {
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
                        protected void subscribeActual(@NonNull Observer<? super Response<DoctorsCall>> observer) {

                        }

                        @Override
                        public void onSubscribe(@NonNull Disposable d) {

                        }

                        @Override
                        public void onNext(@NonNull Response<DoctorsCall> branchDetailsModelResponse) {
                            Helper.getInstance(context).dismissLoading();
                            setDoctorsData(branchDetailsModelResponse);
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

    public void getBranchDate(HashMap<String, String> header, HashMap<String, String> map) {
        try {
            Observable<Response<BranchDateCall>> observable = RetrofitModule.anInterface().getDate(map, header);
            observable
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Subject<Response<BranchDateCall>>() {
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
                        protected void subscribeActual(@NonNull Observer<? super Response<BranchDateCall>> observer) {

                        }

                        @Override
                        public void onSubscribe(@NonNull Disposable d) {

                        }

                        @Override
                        public void onNext(@NonNull Response<BranchDateCall> branchDetailsModelResponse) {
                            Helper.getInstance(context).dismissLoading();
                            branchDate(branchDetailsModelResponse);
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

    public void getBranchTime(HashMap<String, String> header, HashMap<String, String> map) {
        try {
            Observable<Response<BranchTimeCall>> observable = RetrofitModule.anInterface().getTime(map, header);
            observable
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Subject<Response<BranchTimeCall>>() {
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
                        protected void subscribeActual(@NonNull Observer<? super Response<BranchTimeCall>> observer) {

                        }

                        @Override
                        public void onSubscribe(@NonNull Disposable d) {

                        }

                        @Override
                        public void onNext(@NonNull Response<BranchTimeCall> branchTimeCallResponse) {
                            Helper.getInstance(context).dismissLoading();
                            branchTime(branchTimeCallResponse);
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

    public void reservation(HashMap<String, String> header, HashMap<String, String> map) {
        try {
            Observable<Response<ReservationCall>> observable = RetrofitModule.anInterface().reservation(header , map);
            observable
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Subject<Response<ReservationCall>>() {
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
                        protected void subscribeActual(@NonNull Observer<? super Response<ReservationCall>> observer) {

                        }

                        @Override
                        public void onSubscribe(@NonNull Disposable d) {

                        }

                        @Override
                        public void onNext(@NonNull Response<ReservationCall> reservationCallResponse) {
                            Helper.getInstance(context).dismissLoading();
                            reservation(reservationCallResponse);
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

    public void setData(Response<BranchDetailsModel> branchDetailsModelResponse) {
        view.onGetData(branchDetailsModelResponse);
    }

    public void setDoctorsData(Response<DoctorsCall> doctorsData) {
        view.onGetDoctors(doctorsData);
    }

    public void branchDate(Response<BranchDateCall> branchDateCallResponse) {
        view.onGetBranchDate(branchDateCallResponse);
    }

    public void branchTime(Response<BranchTimeCall> branchDateCallResponse) {
        view.onGetBranchTime(branchDateCallResponse);
    }
    public void reservation(Response<ReservationCall> reservationCallResponse) {
        view.reservationCallResponse(reservationCallResponse);
    }
}

