package com.egyvision.ahmedehabtask.model.doctors;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DoctorsData {
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("doctor_id")
    @Expose
    private String doctorId;
    @SerializedName("branch_id")
    @Expose
    private int branchId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("specialty_description")
    @Expose
    private String specialtyDescription;
    @SerializedName("degree")
    @Expose
    private String degree;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("rate")
    @Expose
    private int rate;
    @SerializedName("max_price")
    @Expose
    private double maxPrice;
    @SerializedName("min_price")
    @Expose
    private String minPrice;
    @SerializedName("institution_id")
    @Expose
    private int institutionId;
    @SerializedName("member_id")
    @Expose
    private int memberId;
    @SerializedName("preBooking")
    @Expose
    private Object preBooking;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSpecialtyDescription() {
        return specialtyDescription;
    }

    public void setSpecialtyDescription(String specialtyDescription) {
        this.specialtyDescription = specialtyDescription;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(double maxPrice) {
        this.maxPrice = maxPrice;
    }

    public String getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(String minPrice) {
        this.minPrice = minPrice;
    }

    public int getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(int institutionId) {
        this.institutionId = institutionId;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public Object getPreBooking() {
        return preBooking;
    }

    public void setPreBooking(Object preBooking) {
        this.preBooking = preBooking;
    }
}
