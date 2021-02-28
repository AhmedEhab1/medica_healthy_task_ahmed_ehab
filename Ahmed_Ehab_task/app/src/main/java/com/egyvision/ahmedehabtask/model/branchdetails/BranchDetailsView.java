package com.egyvision.ahmedehabtask.model.branchdetails;

import com.egyvision.ahmedehabtask.model.branchdate.BranchDateCall;
import com.egyvision.ahmedehabtask.model.branchtime.BranchTimeCall;
import com.egyvision.ahmedehabtask.model.doctors.DoctorsCall;
import com.egyvision.ahmedehabtask.model.reservation.ReservationCall;

import retrofit2.Response;

public interface BranchDetailsView {
    void onGetData(Response<BranchDetailsModel> branchDetailsModelResponse);
    void onGetDoctors(Response<DoctorsCall> branchDetailsModelResponse);
    void onGetBranchDate(Response<BranchDateCall> branchDateCallResponse);
    void onGetBranchTime(Response<BranchTimeCall> branchTimeCallResponse);
    void reservationCallResponse(Response<ReservationCall> reservationCallResponse);
}
