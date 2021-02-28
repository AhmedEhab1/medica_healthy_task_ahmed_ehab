package com.egyvision.ahmedehabtask.model.branchtime;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BranchTimeData {
    @SerializedName("time")
    @Expose
    private String time;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("available")
    @Expose
    private int available;
    @SerializedName("day_name")
    @Expose
    private String dayName;
    @SerializedName("price")
    @Expose
    private String price;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public String getDayName() {
        return dayName;
    }

    public void setDayName(String dayName) {
        this.dayName = dayName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
