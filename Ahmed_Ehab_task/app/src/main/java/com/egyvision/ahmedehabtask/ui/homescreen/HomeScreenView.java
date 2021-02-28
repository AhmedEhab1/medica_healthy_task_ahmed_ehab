package com.egyvision.ahmedehabtask.ui.homescreen;

import com.egyvision.ahmedehabtask.model.ListBranches;

import retrofit2.Response;

public interface HomeScreenView {
    void onGetData(Response<ListBranches> listBranches);
}
