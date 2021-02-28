package com.egyvision.ahmedehabtask.ui.branchdetails;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.egyvision.ahmedehabtask.R;
import com.egyvision.ahmedehabtask.databinding.ActivityBranchDetailsBinding;
import com.egyvision.ahmedehabtask.model.branchdate.BranchDateCall;
import com.egyvision.ahmedehabtask.model.branchdate.BranchDateData;
import com.egyvision.ahmedehabtask.model.branchdetails.BranchDetailsData;
import com.egyvision.ahmedehabtask.model.branchdetails.BranchDetailsModel;
import com.egyvision.ahmedehabtask.model.branchdetails.BranchDetailsView;
import com.egyvision.ahmedehabtask.model.branchtime.BranchTimeCall;
import com.egyvision.ahmedehabtask.model.branchtime.BranchTimeData;
import com.egyvision.ahmedehabtask.model.doctors.DoctorsCall;
import com.egyvision.ahmedehabtask.model.doctors.DoctorsData;
import com.egyvision.ahmedehabtask.model.reservation.ReservationCall;
import com.egyvision.ahmedehabtask.ui.homescreen.HomeScreen;
import com.egyvision.ahmedehabtask.utilities.Helper;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import retrofit2.Response;

public class BranchDetails extends AppCompatActivity implements BranchDetailsView {
    DepartmentsAdapter adapter;
    ActivityBranchDetailsBinding binding;
    BranchDetailsPresenter presenter;
    DoctorsAdapter doctorsAdapter;
    String branch_id, id, image, Title, branch_lat, branch_lng;
    private static BranchDetails instance;
    DateAdapter dateAdapter;
    String dayDate = "", dayTime = "", price, paid_price;
    ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_branch_details);

        presenter = new BranchDetailsPresenter(this, this);
        branch_id = getIntent().getStringExtra("branch_id");
        id = getIntent().getStringExtra("id");
        image = getIntent().getStringExtra("image");
        Title = getIntent().getStringExtra("Title");
        branch_lat = getIntent().getStringExtra("branch_lat");
        branch_lng = getIntent().getStringExtra("branch_lng");
        Helper.getInstance(this).uploadeImage(image, binding.progressBar, binding.departmentImage);
        binding.branchName.setText(Title);
        instance = this;

        getDate();
        reyclerLayout();
        recDepartmentLayout();
        getListOfDepartments();
        ShowLocationOnMap();
        closeBranch();
        dateRecLayout();
        timeRecLayout();
        submitButton();
    }

    private void closeBranch() {
        binding.closeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    private void ShowLocationOnMap() {
        binding.branchLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String labelLocation = Title;
                String uri = String.format(Locale.ENGLISH, "geo:%f,%f", Double.valueOf(branch_lat), Double.valueOf(branch_lng)) + "<long>(Label+Name)";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:<" + branch_lat + ">,<" + branch_lng + ">?q=<" + branch_lat + ">,<" + branch_lng + ">(" + labelLocation + ")"));
                startActivity(intent);
            }
        });

    }

    private void reyclerLayout() {
        // for recycler
        LinearLayoutManager mLayoutManager;
        mLayoutManager = new LinearLayoutManager(BranchDetails.this, LinearLayoutManager.HORIZONTAL, false);

        binding.departmentRec.setLayoutManager(mLayoutManager);
        binding.departmentRec.setItemAnimator(new DefaultItemAnimator());
        binding.departmentRec.setNestedScrollingEnabled(false);
    }

    private void recDepartmentLayout() {
        // for recycler
        LinearLayoutManager mLayoutManager;
        mLayoutManager = new LinearLayoutManager(this);

        binding.doctorsRec.setLayoutManager(mLayoutManager);
        binding.doctorsRec.setItemAnimator(new DefaultItemAnimator());
        binding.doctorsRec.setNestedScrollingEnabled(false);

    }

    private void dateRecLayout() {
        LinearLayoutManager mLayoutManager2;
        mLayoutManager2 = new GridLayoutManager(this, 4);

        binding.dateRec.setLayoutManager(mLayoutManager2);
        binding.dateRec.setItemAnimator(new DefaultItemAnimator());
        binding.dateRec.setNestedScrollingEnabled(false);
    }

    private void timeRecLayout() {
        // for recycler
        LinearLayoutManager mLayoutManager;
        mLayoutManager = new LinearLayoutManager(BranchDetails.this, LinearLayoutManager.HORIZONTAL, false);

        binding.timeRec.setLayoutManager(mLayoutManager);
        binding.timeRec.setItemAnimator(new DefaultItemAnimator());
        binding.timeRec.setNestedScrollingEnabled(false);
    }

    public void getListOfDepartments() {
        HashMap<String, String> map = new HashMap<>();
        map.put("branch_id", "1277"); //You can add branch_id var to get actual data
        map.put("id", "1096");//You can add id var to get actual data
        Helper.getInstance(this).showLoading();
        presenter.getData(Helper.getInstance(this).header(), map);
    }


    public void getListOfDoctors() {
        HashMap<String, String> map = new HashMap<>();
        map.put("branch_id", "1277");
        map.put("id", "1096");
        map.put("specialty_id", "13994");
        Helper.getInstance(this).showLoading();
        presenter.getDoctorsData(Helper.getInstance(this).header(), map);
    }

    public void hideDate() {
        binding.firstStep.setVisibility(View.GONE);
        binding.dateLayout.setVisibility(View.VISIBLE);
    }

    public void getDate() {
        Helper.getInstance(this).showLoading();
        HashMap<String, String> map = new HashMap<>();
        map.put("branch_id", "1277");
        map.put("doctor_id", "1444");
        map.put("type", "normal");
        Helper.getInstance(this).showLoading();
        presenter.getBranchDate(Helper.getInstance(this).header(), map);
    }

    public void timeCall(String day_number, String date) {
        dayDate = date;
        Helper.getInstance(this).showLoading();
        HashMap<String, String> map = new HashMap<>();
        map.put("branch_id", "1277");
        map.put("doctor_id", "1444");
        map.put("id", "1096");
        map.put("type", "normal");
        map.put("day_number", day_number);
        map.put("date", date);
        presenter.getBranchTime(Helper.getInstance(this).header(), map);
    }

    public void dayTime(String time) {
        dayTime = time;
    }

    private void submitButton() {
        binding.submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (dayTime.equals("") || dayDate.equals("")) {
                    Toast.makeText(BranchDetails.this, "please scelct Date and Time", Toast.LENGTH_SHORT).show();
                } else {
                    reservation();
                }
            }
        });
    }

    public void price(String max, String min) {
        price = min;
        paid_price = max;
    }

    private void reservation() {
        Helper.getInstance(this).showLoading();
        HashMap<String, String> map = new HashMap<>();
        map.put("institution_branch_id", "3198");
        map.put("institution_id", "2571");
        map.put("date", dayDate);
        map.put("doctor_id", "3822");
        map.put("timefrom", dayTime);
        map.put("price", price);
        map.put("paid_price", paid_price);
        map.put("type", "normal_reservation");
        presenter.reservation(Helper.getInstance(this).reservationHeader(), map);
    }

    @Override
    public void onGetData(Response<BranchDetailsModel> branchDetailsModelResponse) {
        try {
            BranchDetailsModel branchDetailsModel = branchDetailsModelResponse.body();
            if (branchDetailsModel.getCode() == 100) {
                List<BranchDetailsData> branchDetailsData = branchDetailsModel.getItem().getData();
                if (branchDetailsData.size() != 0) {
                    binding.noDepatrments.setVisibility(View.GONE);
                    adapter = new DepartmentsAdapter(branchDetailsData, BranchDetails.this);
                    binding.departmentRec.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                    getListOfDoctors();
                }
            } else binding.noDepatrments.setVisibility(View.VISIBLE);
        } catch (Exception e) {
            Log.d("error", "onChanged: " + e);
        }
    }

    @Override
    public void onGetDoctors(Response<DoctorsCall> branchDetailsModelResponse) {
        try {
            DoctorsCall doctorsCall = branchDetailsModelResponse.body();
            if (doctorsCall.getCode() == 100) {
                List<DoctorsData> doctorsData = doctorsCall.getItem().getData();
                if (doctorsData.size() != 0) {
                    doctorsAdapter = new DoctorsAdapter(doctorsData, BranchDetails.this);
                    binding.doctorsRec.setAdapter(doctorsAdapter);
                    doctorsAdapter.notifyDataSetChanged();
                }
            }
        } catch (Exception e) {
            Log.d("error", "onChanged: " + e);
        }
    }

    @Override
    public void onGetBranchDate(Response<BranchDateCall> branchDateCallResponse) {
        try {
            BranchDateCall branchDateCall = branchDateCallResponse.body();
            if (branchDateCall.getCode() == 100) {
                List<BranchDateData> branchDateData = branchDateCall.getItem().getData();
                if (branchDateData.size() != 0) {
                    dateAdapter = new DateAdapter(branchDateData, BranchDetails.this);
                    binding.dateRec.setAdapter(dateAdapter);
                    dateAdapter.notifyDataSetChanged();
                }
            }
        } catch (Exception e) {
            Log.d("error", "onChanged: " + e);
        }
    }

    @Override
    public void onGetBranchTime(Response<BranchTimeCall> branchTimeCallResponse) {
        try {
            TimeAdapter timeAdapter;
            BranchTimeCall branchTimeCall = branchTimeCallResponse.body();
            if (branchTimeCall.getCode() == 100) {
                List<BranchTimeData> branchTimeData = branchTimeCall.getItem().getData();
                if (branchTimeData.size() != 0) {
                    timeAdapter = new TimeAdapter(branchTimeData, BranchDetails.this);
                    binding.timeRec.setAdapter(timeAdapter);
                    timeAdapter.notifyDataSetChanged();
                }
            }
        } catch (Exception e) {
            Log.d("error", "onChanged: " + e);
        }
    }

    @Override
    public void reservationCallResponse(Response<ReservationCall> reservationCallResponse) {
        try {
            ReservationCall reservationCall = reservationCallResponse.body();
            if (reservationCall.getCode() == 100) {
                Intent intent = new Intent(BranchDetails.this, HomeScreen.class);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                Toast.makeText(BranchDetails.this, reservationCall.getMessage(), Toast.LENGTH_SHORT).show();

            } else {
                Toast.makeText(BranchDetails.this, reservationCall.getMessage(), Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            Log.d("error", "onChanged: " + e);
        }
    }

    public static BranchDetails getInstance() {
        return instance;
    }


}