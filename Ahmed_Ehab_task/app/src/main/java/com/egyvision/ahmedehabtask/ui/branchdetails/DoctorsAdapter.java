package com.egyvision.ahmedehabtask.ui.branchdetails;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.egyvision.ahmedehabtask.R;
import com.egyvision.ahmedehabtask.model.doctors.DoctorsData;
import com.egyvision.ahmedehabtask.utilities.Helper;

import java.util.ArrayList;
import java.util.List;


public class DoctorsAdapter extends RecyclerView.Adapter<DoctorsAdapter.ImagesViewHolder> {
    private ArrayList<DoctorsData> branchData;
    private Context context;

    public DoctorsAdapter(List<DoctorsData> images, Context context) {
        this.branchData = (ArrayList<DoctorsData>) images;
        this.context = context;
    }

    @NonNull
    @Override
    public ImagesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ImagesViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.doctor_item, parent, false));
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public void onBindViewHolder(@NonNull ImagesViewHolder holder, int position) {


        holder.branch_name.setText(String.valueOf(branchData.get(position).getName()));
        String distance = String.valueOf((int)branchData.get(position).getMaxPrice())+" EGP" ;
        holder.branch_distance.setText(distance);
        holder.branch_location.setText(String.valueOf(branchData.get(position).getDescription()));
        holder.branch_rate.setText(String.valueOf(branchData.get(position).getRate()));
        holder.branch_type.setText(String.valueOf(branchData.get(position).getSpecialtyDescription()));
        holder.branch_image.setClipToOutline(true);
        Helper.getInstance(context).uploadeImage(branchData.get(position).getImage(), holder.progressBar, holder.branch_image);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String max = String.valueOf(branchData.get(position).getMaxPrice());
                String min = String.valueOf(branchData.get(position).getMinPrice());
                BranchDetails.getInstance().hideDate();
                BranchDetails.getInstance().getDate();
                BranchDetails.getInstance().price(max , min);
            }
        });
    }

    @Override
    public int getItemCount() {
        return branchData.size();
    }

    public class ImagesViewHolder extends RecyclerView.ViewHolder {
        ProgressBar progressBar ;
        ImageView branch_image ;
        TextView branch_name , branch_type , branch_distance , branch_rate ,branch_location ;

        public ImagesViewHolder(@NonNull View itemView) {
            super(itemView);
            progressBar = itemView.findViewById(R.id.progressBar);
            branch_image = itemView.findViewById(R.id.branch_image);
            branch_name = itemView.findViewById(R.id.branch_name);
            branch_type = itemView.findViewById(R.id.branch_type);
            branch_distance = itemView.findViewById(R.id.branch_distance);
            branch_rate = itemView.findViewById(R.id.branch_rate);
            branch_location = itemView.findViewById(R.id.branch_location);
        }
    }


}

