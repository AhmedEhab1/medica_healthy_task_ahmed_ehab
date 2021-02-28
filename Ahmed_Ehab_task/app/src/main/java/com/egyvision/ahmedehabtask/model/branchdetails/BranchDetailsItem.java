package com.egyvision.ahmedehabtask.model.branchdetails;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BranchDetailsItem {

    @SerializedName("data")
    @Expose
    private List<BranchDetailsData> data = null;

    public List<BranchDetailsData> getData() {
        return data;
    }

    public void setData(List<BranchDetailsData> data) {
        this.data = data;
    }
}
