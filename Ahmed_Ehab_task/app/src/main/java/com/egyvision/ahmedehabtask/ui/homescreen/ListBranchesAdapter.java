package com.egyvision.ahmedehabtask.ui.homescreen;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.egyvision.ahmedehabtask.R;
import com.egyvision.ahmedehabtask.model.BranchData;
import com.egyvision.ahmedehabtask.ui.branchdetails.BranchDetails;
import com.egyvision.ahmedehabtask.utilities.Helper;
import com.egyvision.ahmedehabtask.utilities.SharedPrefUtil;

import java.util.ArrayList;
import java.util.List;



public class ListBranchesAdapter extends RecyclerView.Adapter<ListBranchesAdapter.ImagesViewHolder> {
    private ArrayList<BranchData> branchData;
    private Context context;
    String base_url, applang, ObjectsId , type;


    public ListBranchesAdapter(List<BranchData> images, Context context) {
        this.branchData = (ArrayList<BranchData>) images;
        this.context = context;
    }

    @NonNull
    @Override
    public ImagesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        SharedPrefUtil sharedPrefUtil = new SharedPrefUtil(context);
        applang = sharedPrefUtil.getValueFromSharePref("applang");
        return new ImagesViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_branch_item, parent, false));
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


        holder.branch_name.setText(String.valueOf(branchData.get(position).getTitle()));
        String distance = String.valueOf((int)branchData.get(position).getDistance())+" m" ;
        holder.branch_distance.setText(distance);
        holder.branch_location.setText(String.valueOf(branchData.get(position).getAddress()));
        holder.branch_rate.setText(String.valueOf(branchData.get(position).getRate()));
        holder.branch_type.setText(String.valueOf(branchData.get(position).getSpecialty()));
        holder.branch_image.setClipToOutline(true);
        Helper.getInstance(context).uploadeImage(branchData.get(position).getImage(), holder.progressBar, holder.branch_image);
        // holder.rating_bar.setRating(5);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context , BranchDetails.class);
                intent.putExtra("branch_id", String.valueOf(branchData.get(position).getBranchId()));
                intent.putExtra("id", String.valueOf(branchData.get(position).getDoctorId()));
                intent.putExtra("image", String.valueOf(branchData.get(position).getImage()));
                intent.putExtra("Title", String.valueOf(branchData.get(position).getTitle()));
                intent.putExtra("branch_lat", String.valueOf(branchData.get(position).getLat()));
                intent.putExtra("branch_lng", String.valueOf(branchData.get(position).getLng()));
                context.startActivity(intent);
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
    public void add(BranchData branchData1) {
        branchData.add(branchData1);
        notifyItemInserted(branchData.size() -1 );
    }
    public void addAll(List<BranchData> moveResults) {
        for (BranchData result : moveResults) {
            add(result);
        }
    }

}
