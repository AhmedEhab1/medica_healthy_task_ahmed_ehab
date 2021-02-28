package com.egyvision.ahmedehabtask.model.branchdate;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BranchDateItem {
    @SerializedName("data")
    @Expose
    private List<BranchDateData> data = null;

    public List<BranchDateData> getData() {
        return data;
    }

    public void setData(List<BranchDateData> data) {
        this.data = data;
    }
}
