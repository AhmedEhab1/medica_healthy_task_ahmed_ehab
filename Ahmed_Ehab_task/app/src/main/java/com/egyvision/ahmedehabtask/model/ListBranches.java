package com.egyvision.ahmedehabtask.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ListBranches {
    @SerializedName("code")
    @Expose
    private int code;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("item")
    @Expose
    private BranchesItem item;

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

    public BranchesItem getItem() {
        return item;
    }

    public void setItem(BranchesItem item) {
        this.item = item;
    }
}
