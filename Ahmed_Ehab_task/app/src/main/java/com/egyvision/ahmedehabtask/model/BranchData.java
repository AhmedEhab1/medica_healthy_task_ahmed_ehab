package com.egyvision.ahmedehabtask.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class BranchData  implements Serializable {


    @SerializedName("branch_id")
    @Expose
    private int branchId;
    @SerializedName("member_id")
    @Expose
    private int memberId;
    @SerializedName("encode_branch_id")
    @Expose
    private String encodeBranchId;
    @SerializedName("institution_id")
    @Expose
    private int institutionId;
    @SerializedName("doctor_id")
    @Expose
    private int doctorId;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("institution_title")
    @Expose
    private String institutionTitle;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("lat")
    @Expose
    private String lat;
    @SerializedName("lng")
    @Expose
    private String lng;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("type")
    @Expose
    private int type;
    @SerializedName("distance")
    @Expose
    private double distance;
    @SerializedName("specialty")
    @Expose
    private String specialty;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("is_favorite")
    @Expose
    private String isFavorite;
    @SerializedName("rate")
    @Expose
    private int rate;
    @SerializedName("home_visit")
    @Expose
    private String homeVisit;


    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getEncodeBranchId() {
        return encodeBranchId;
    }

    public void setEncodeBranchId(String encodeBranchId) {
        this.encodeBranchId = encodeBranchId;
    }

    public int getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(int institutionId) {
        this.institutionId = institutionId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInstitutionTitle() {
        return institutionTitle;
    }

    public void setInstitutionTitle(String institutionTitle) {
        this.institutionTitle = institutionTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getIsFavorite() {
        return isFavorite;
    }

    public void setIsFavorite(String isFavorite) {
        this.isFavorite = isFavorite;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getHomeVisit() {
        return homeVisit;
    }

    public void setHomeVisit(String homeVisit) {
        this.homeVisit = homeVisit;
    }


}
