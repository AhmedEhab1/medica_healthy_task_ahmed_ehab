package com.egyvision.ahmedehabtask.model.branchdate;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BranchDates {
    @SerializedName("data")
    @Expose
    private List<BranchDay> data = null;

    public List<BranchDay> getData() {
        return data;
    }

    public void setData(List<BranchDay> data) {
        this.data = data;
    }
}
