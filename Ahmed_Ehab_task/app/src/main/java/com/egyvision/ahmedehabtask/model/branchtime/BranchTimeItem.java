package com.egyvision.ahmedehabtask.model.branchtime;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BranchTimeItem {

    @SerializedName("data")
    @Expose
    private List<BranchTimeData> data = null;

    public List<BranchTimeData> getData() {
        return data;
    }

    public void setData(List<BranchTimeData> data) {
        this.data = data;
    }
}
