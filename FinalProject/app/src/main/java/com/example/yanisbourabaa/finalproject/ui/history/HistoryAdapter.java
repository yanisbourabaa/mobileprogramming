package com.example.yanisbourabaa.finalproject.ui.history;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.yanisbourabaa.finalproject.R;
import com.example.yanisbourabaa.finalproject.datamanagers.DataManagerImpl;
import com.example.yanisbourabaa.finalproject.model.Day;

import java.util.List;

/**
 * Created by yanisbourabaa on 18/05/2017.
 */

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.MyViewHolder> {
    private final Context context;
    private final List<Day> days;

    public HistoryAdapter(Context context) {
        this.context = context;
        days = DataManagerImpl.getInstance().getDays();
        days.remove(days.get(days.size() -1));
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.history_cell, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Day currentDay = days.get(position);
        holder.viewPager.setAdapter(new CustomPagerAdapter(context, currentDay.getThings()));
        holder.date.setText(currentDay.getDate());
    }

    @Override
    public int getItemCount() {
        return days.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public final ViewPager viewPager;
        public TextView date;

        public MyViewHolder(View itemView) {
            super(itemView);
            viewPager = (ViewPager) itemView.findViewById(R.id.viewpager);
            date = (TextView) itemView.findViewById(R.id.history_date);
        }
    }
}
