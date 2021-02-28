package com.egyvision.ahmedehabtask.model.doctors;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DoctorsItem {
    @SerializedName("data")
    @Expose
    private List<DoctorsData> data = null;

    public List<DoctorsData> getData() {
        return data;
    }

    public void setData(List<DoctorsData> data) {
        this.data = data;
    }
}
