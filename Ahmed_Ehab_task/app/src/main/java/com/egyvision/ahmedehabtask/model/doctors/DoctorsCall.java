package com.egyvision.ahmedehabtask.model.doctors;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DoctorsCall {
    @SerializedName("code")
    @Expose
    private int code;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("item")
    @Expose
    private DoctorsItem item;

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

    public DoctorsItem getItem() {
        return item;
    }

    public void setItem(DoctorsItem item) {
        this.item = item;
    }
}
