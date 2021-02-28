package com.egyvision.ahmedehabtask.ui.homescreen;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.egyvision.ahmedehabtask.R;
import com.egyvision.ahmedehabtask.databinding.ActivityHomeScreenBinding;
import com.egyvision.ahmedehabtask.model.BranchData;
import com.egyvision.ahmedehabtask.model.BranchesItem;
import com.egyvision.ahmedehabtask.model.ListBranches;
import com.egyvision.ahmedehabtask.ui.institutionsmap.InstitutionsOnMap;
import com.egyvision.ahmedehabtask.utilities.Helper;
import com.egyvision.ahmedehabtask.utilities.SharedPrefUtil;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import retrofit2.Response;

public class HomeScreen extends AppCompatActivity implements HomeScreenView , Serializable {
    public static final int MY_PERMISSIONS_REQUEST_LOCATION = 99;
    ListBranchesAdapter adapter;
    ActivityHomeScreenBinding binding;
    HomeScreenPresenter presenter;
    int current_page = 1;
    private boolean loading = true;
    private int previousTotal = 0;
    private int visibleThreshold = 5;
    int firstVisibleItem, visibleItemCount, totalItemCount;
    List<BranchData> branchData ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home_screen);

        presenter = new HomeScreenPresenter(this, this);



        checkLocationPermission();
        reyclerLayout();
        openMaps();
    }
    private void openMaps(){
        binding.maps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeScreen.this , InstitutionsOnMap.class);
                startActivity(intent);

            }
        });
    }

    public void getListOfBranches() {
        SharedPrefUtil sharedPrefUtil = new SharedPrefUtil(HomeScreen.this);
        String lat = sharedPrefUtil.getValueFromSharePref("lat");
        String lng = sharedPrefUtil.getValueFromSharePref("lng");
        HashMap<String, String> map = new HashMap<>();
        map.put("lat", lat);
        map.put("lng", lng);
        map.put("type", "3");
        map.put("page", String.valueOf(current_page));

        Helper.getInstance(this).showLoading();

        presenter.getData(Helper.getInstance(this).header(), map);
    }

    public void reyclerLayout() {
        // for recycler
        LinearLayoutManager mLayoutManager;
        mLayoutManager = new LinearLayoutManager(this);

        binding.listBranchesRec.setLayoutManager(mLayoutManager);
        binding.listBranchesRec.setItemAnimator(new DefaultItemAnimator());
        binding.listBranchesRec.setNestedScrollingEnabled(false);

        binding.listBranchesRec.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                visibleItemCount = recyclerView.getChildCount();
                totalItemCount = mLayoutManager.getItemCount();
                firstVisibleItem = mLayoutManager.findFirstVisibleItemPosition();
                if (loading) {
                    if (totalItemCount > previousTotal) {
                        loading = false;
                        previousTotal = totalItemCount;
                    }
                }
                if (!loading && (totalItemCount - visibleItemCount)
                        <= (firstVisibleItem + visibleThreshold)) {
                    // End has been reached
                    Log.i("Yaeye!", "end called");
                    // Do something
                    getListOfBranches();

                    loading = true;
                }
            }
        });
    }

    private void getCurrentLocation() {
        try {
            Helper.getInstance(HomeScreen.this).showLoading();
            LocationRequest locationRequest = new LocationRequest();
            locationRequest.setInterval(10000);
            locationRequest.setFastestInterval(3000);
            locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);

            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                    ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            LocationServices.getFusedLocationProviderClient(HomeScreen.this)
                    .requestLocationUpdates(locationRequest, new LocationCallback() {
                        @Override
                        public void onLocationResult(LocationResult locationResult) {
                            super.onLocationResult(locationResult);
                            LocationServices.getFusedLocationProviderClient(HomeScreen.this)
                                    .removeLocationUpdates(this);
                            if (locationRequest != null && locationResult.getLocations().size() > 0) {
                                int latestLocationIndex = locationResult.getLocations().size() - 1;
                                double latitude =
                                        locationResult.getLocations().get(latestLocationIndex).getLatitude();
                                double longitude =
                                        locationResult.getLocations().get(latestLocationIndex).getLongitude();
                                SharedPrefUtil sharedPrefUtil = new SharedPrefUtil(HomeScreen.this);
                                sharedPrefUtil.setValueInSharePref("lat", String.valueOf(latitude));
                                sharedPrefUtil.setValueInSharePref("lng", String.valueOf(longitude));

                                Geocoder geocoder;
                                List<Address> addresses = null;
                                geocoder = new Geocoder(HomeScreen.this, Locale.getDefault());

                                try {
                                    addresses = geocoder.getFromLocation(latitude, longitude, 1); // Here 1 represent max location result to returned, by documents it recommended 1 to 5
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                String address = addresses.get(0).getAddressLine(0); // If any additional address line present than only, check with max available address lines by getMaxAddressLineIndex()
                                String city = addresses.get(0).getLocality();
                                String state = addresses.get(0).getAdminArea();
                                String country = addresses.get(0).getCountryName();
                                String postalCode = addresses.get(0).getPostalCode();
                                String knownName = addresses.get(0).getFeatureName(); // Only i
                                getListOfBranches();

                            }
                        }
                    }, Looper.getMainLooper());

        }catch (Exception e){
            Log.d("error", "onGetData: " + e);
        }

    }


    public boolean checkLocationPermission() {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            // No explanation needed, we can request the permission.
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    MY_PERMISSIONS_REQUEST_LOCATION);
            return false;
        } else {
            getCurrentLocation();
            return true;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_LOCATION: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the
                    // location-related task you need to do.
                    if (ContextCompat.checkSelfPermission(this,
                            Manifest.permission.ACCESS_FINE_LOCATION)
                            == PackageManager.PERMISSION_GRANTED) {
                        getCurrentLocation();

                    }

                } else {
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                    checkLocationPermission();

                }
                return;
            }

        }
    }

    @Override
    public void onGetData(Response<ListBranches> listBranches1) {
        try {
            //     Log.e("Success", new Gson().toJson(listBranches));
            ListBranches listBranches = listBranches1.body();
            BranchesItem branchesItem = listBranches.getItem();
            current_page = branchesItem.getMeta().getPagination().getCurrentPage();
             branchData = branchesItem.getData();
            if (current_page == 1){
                if (branchData.size() != 0) {
                    Log.d("error", "onChanged: ");
                    adapter = new ListBranchesAdapter(branchData, HomeScreen.this);
                    binding.listBranchesRec.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }
            }else {
                adapter.addAll(branchData);
            }
            current_page = current_page+1 ;

        } catch (Exception e) {
            Log.d("error", "onGetData: " + e);
        }


    }
}