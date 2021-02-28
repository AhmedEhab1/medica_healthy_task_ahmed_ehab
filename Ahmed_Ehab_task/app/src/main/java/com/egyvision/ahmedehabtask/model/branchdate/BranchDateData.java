package com.egyvision.ahmedehabtask.model.branchdate;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BranchDateData {
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("time_from")
    @Expose
    private String timeFrom;
    @SerializedName("time_to")
    @Expose
    private String timeTo;
    @SerializedName("day_number")
    @Expose
    private int dayNumber;
    @SerializedName("dates")
    @Expose
    private BranchDates dates;

    public BranchDates getDates() {
        return dates;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTimeFrom() {
        return timeFrom;
    }

    public void setTimeFrom(String timeFrom) {
        this.timeFrom = timeFrom;
    }

    public String getTimeTo() {
        return timeTo;
    }

    public void setTimeTo(String timeTo) {
        this.timeTo = timeTo;
    }

    public int getDayNumber() {
        return dayNumber;
    }

    public void setDayNumber(int dayNumber) {
        this.dayNumber = dayNumber;
    }

}
