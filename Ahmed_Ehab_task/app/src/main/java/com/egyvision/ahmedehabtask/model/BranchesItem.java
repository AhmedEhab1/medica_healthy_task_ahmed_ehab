package com.egyvision.ahmedehabtask.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BranchesItem {
    @SerializedName("data")
    @Expose
    private List<BranchData> data = null;
    @SerializedName("meta")
    @Expose
    private Meta meta;

    public List<BranchData> getData() {
        return data;
    }

    public void setData(List<BranchData> data) {
        this.data = data;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }
}
