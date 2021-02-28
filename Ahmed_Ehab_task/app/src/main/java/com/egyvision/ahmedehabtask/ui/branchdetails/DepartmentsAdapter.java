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
import com.egyvision.ahmedehabtask.model.branchdetails.BranchDetailsData;
import com.egyvision.ahmedehabtask.utilities.Helper;

import java.util.ArrayList;
import java.util.List;



public class DepartmentsAdapter extends RecyclerView.Adapter<DepartmentsAdapter.ImagesViewHolder> {
    private ArrayList<BranchDetailsData> branchDetailsData;
    private Context context;


    public DepartmentsAdapter(List<BranchDetailsData> images, Context context ) {
        this.branchDetailsData = (ArrayList<BranchDetailsData>) images;
        this.context = context;
    }

    @NonNull
    @Override
    public ImagesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ImagesViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.departments_item, parent, false));
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
        holder.branch_image.setClipToOutline(true);
        Helper.getInstance(context).uploadeImage(branchDetailsData.get(position).getImage(), holder.progressBar, holder.branch_image);
        holder.department_name.setText(branchDetailsData.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return branchDetailsData.size();
    }

    public class ImagesViewHolder extends RecyclerView.ViewHolder {
        ImageView branch_image;
        ProgressBar progressBar;
        TextView department_name ;

        public ImagesViewHolder(@NonNull View itemView) {
            super(itemView);
            department_name = itemView.findViewById(R.id.department_name);
            progressBar = itemView.findViewById(R.id.progressBar);
            branch_image = itemView.findViewById(R.id.branch_image);
        }
    }


}

