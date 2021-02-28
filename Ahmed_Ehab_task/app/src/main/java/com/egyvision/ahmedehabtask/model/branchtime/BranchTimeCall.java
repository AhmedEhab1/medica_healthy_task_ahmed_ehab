package com.egyvision.ahmedehabtask.model.branchtime;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BranchTimeCall {
    @SerializedName("code")
    @Expose
    private int code;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("item")
    @Expose
    private BranchTimeItem item;

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

    public BranchTimeItem getItem() {
        return item;
    }

    public void setItem(BranchTimeItem item) {
        this.item = item;
    }
}
