package com.egyvision.ahmedehabtask.model.branchdetails;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BranchDetailsModel {

    @SerializedName("code")
    @Expose
    private int code;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("item")
    @Expose
    private BranchDetailsItem item;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public BranchDetailsItem getItem() {
        return item;
    }

    public void setItem(BranchDetailsItem item) {
        this.item = item;
    }
}
