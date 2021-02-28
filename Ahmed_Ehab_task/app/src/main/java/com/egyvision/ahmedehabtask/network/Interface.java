package com.egyvision.ahmedehabtask.network;

import com.egyvision.ahmedehabtask.model.ListBranches;
import com.egyvision.ahmedehabtask.model.branchdate.BranchDateCall;
import com.egyvision.ahmedehabtask.model.branchdetails.BranchDetailsModel;
import com.egyvision.ahmedehabtask.model.branchtime.BranchTimeCall;
import com.egyvision.ahmedehabtask.model.doctors.DoctorsCall;
import com.egyvision.ahmedehabtask.model.login.LoginModel;
import com.egyvision.ahmedehabtask.model.maps.MapsCall;
import com.egyvision.ahmedehabtask.model.reservation.ReservationCall;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

public interface Interface {

    @POST("/api/auth-client/login")
    Observable<LoginModel> login(@HeaderMap HashMap<String, String> header, @QueryMap(encoded = true) HashMap<String, String> map);

    @GET("/api/services")
    Observable<Response<ListBranches>> getBranches(@QueryMap(encoded = true) Map<String, String> params , @HeaderMap HashMap<String, String> header );

    @GET("/api/institutions/specialties")
    Observable<Response<BranchDetailsModel>> getDepartments(@QueryMap(encoded = true) Map<String, String> params , @HeaderMap HashMap<String, String> header );

    @GET("/api/institutions/doctors")
    Observable<Response<DoctorsCall>> getDoctors(@QueryMap(encoded = true) Map<String, String> params , @HeaderMap HashMap<String, String> header );

    @GET("/api/institutions/appointments")
    Observable<Response<BranchDateCall>> getDate(@QueryMap(encoded = true) Map<String, String> params , @HeaderMap HashMap<String, String> header );

    @GET("/api/institutions/appointments/time")
    Observable<Response<BranchTimeCall>> getTime(@QueryMap(encoded = true) Map<String, String> params , @HeaderMap HashMap<String, String> header );

    @POST("/api/client/reservation")
    Observable<Response<ReservationCall>> reservation(@HeaderMap HashMap<String, String> header , @QueryMap(encoded = true) Map<String, String> params );

    @GET("/api/services")
    Observable<MapsCall> mapsCall(@QueryMap(encoded = true) Map<String, String> params , @HeaderMap HashMap<String, String> header );

}
