package com.egyvision.ahmedehabtask.model.reservation;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ReservationCall {
    @SerializedName("code")
    @Expose
    private int code;
    @SerializedName("message")
    @Expose
    private String message;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
