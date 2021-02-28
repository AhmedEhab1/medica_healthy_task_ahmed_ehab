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
import com.egyvision.ahmedehabtask.model.branchdate.BranchDateData;
import com.egyvision.ahmedehabtask.model.branchdate.BranchDay;

import java.util.ArrayList;
import java.util.List;


public class DateAdapter extends RecyclerView.Adapter<DateAdapter.ImagesViewHolder> {
    private ArrayList<BranchDateData> branchDateData;
    private Context context;
    int row_index = 100;


    public DateAdapter(List<BranchDateData> images, Context context) {
        this.branchDateData = (ArrayList<BranchDateData>) images;
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
        int dayNum = branchDateData.get(position).getDayNumber() ;
        holder.day_name.setText(dayName(dayNum));
        List<BranchDay> branchDates = branchDateData.get(position).getDates().getData();
        String day = branchDates.get(0).getDate();

        if (row_index == position) {
            holder.frameLayout.setBackgroundResource(R.drawable.selected_frame);
        } else {
            holder.frameLayout.setBackgroundResource(R.drawable.date_frame);
        }


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BranchDetails.getInstance().timeCall(String.valueOf(dayNum) ,day );
                row_index = position;
                notifyDataSetChanged();
            }
        });


    }


    @Override
    public int getItemCount() {
        return branchDateData.size();
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

    public String dayName(int id) {
        String dayName = "";
        if (id == 1) {
            dayName = "Saturday";
        } else if (id == 2) {
            dayName = "Sunday";
        } else if (id == 3) {
            dayName = "Monday";
        } else if (id == 4) {
            dayName = "Tuesday";
        } else if (id == 5) {
            dayName = "Wednesday";
        } else if (id == 6) {
            dayName = "Thursday";
        } else if (id == 7) {
            dayName = "Friday";
        }
        return dayName;
    }

}

