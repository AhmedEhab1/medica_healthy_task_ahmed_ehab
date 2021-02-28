package com.egyvision.ahmedehabtask.model.maps;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MapsItem {
    @SerializedName("data")
    @Expose
    private List<MapsData> data = null;


    public List<MapsData> getData() {
        return data;
    }

    public void setData(List<MapsData> data) {
        this.data = data;
    }


}
