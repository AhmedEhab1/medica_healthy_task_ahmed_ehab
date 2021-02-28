package com.egyvision.ahmedehabtask.ui.branchdetails;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.egyvision.ahmedehabtask.R;
import com.egyvision.ahmedehabtask.model.branchtime.BranchTimeData;

import java.util.ArrayList;
import java.util.List;


public class TimeAdapter extends RecyclerView.Adapter<TimeAdapter.ImagesViewHolder> {
    private ArrayList<BranchTimeData> branchTimeData;
    private Context context;
    int row_index = 100;


    public TimeAdapter(List<BranchTimeData> images, Context context) {
        this.branchTimeData = (ArrayList<BranchTimeData>) images;
        this.context = context;
    }

    @NonNull
    @Override
    public ImagesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ImagesViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.date_item, parent, false));
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
        holder.day_name.setText(branchTimeData.get(position).getTime());

        if (row_index == position) {
            holder.frameLayout.setBackgroundResource(R.drawable.selected_frame);
        } else {
            holder.frameLayout.setBackgroundResource(R.drawable.date_frame);
        }


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                row_index = position;
                notifyDataSetChanged();
                BranchDetails.getInstance().dayTime(branchTimeData.get(position).getTime()) ;

            }
        });


    }


    @Override
    public int getItemCount() {
        return branchTimeData.size();
    }

    public class ImagesViewHolder extends RecyclerView.ViewHolder {
        TextView day_name;
        FrameLayout frameLayout ;

        public ImagesViewHolder(@NonNull View itemView) {
            super(itemView);
            day_name = itemView.findViewById(R.id.day_name);
            frameLayout = itemView.findViewById(R.id.dateFrame);
        }
    }

}
