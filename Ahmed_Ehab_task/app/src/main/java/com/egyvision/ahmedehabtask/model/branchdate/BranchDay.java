package com.egyvision.ahmedehabtask.model.branchdate;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BranchDay {
    @SerializedName("date")
    @Expose
    private String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
