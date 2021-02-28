package com.egyvision.ahmedehabtask.model.branchdate;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BranchDateCall {
    @SerializedName("code")
    @Expose
    private int code;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("item")
    @Expose
    private BranchDateItem item;

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

    public BranchDateItem getItem() {
        return item;
    }

    public void setItem(BranchDateItem item) {
        this.item = item;
    }
}
