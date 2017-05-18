package com.example.yanisbourabaa.finalproject.ui.stat;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yanisbourabaa.finalproject.R;
import com.example.yanisbourabaa.finalproject.datamanagers.DataManagerImpl;
import com.example.yanisbourabaa.finalproject.model.Day;
import com.example.yanisbourabaa.finalproject.model.Thing;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;

import java.util.ArrayList;
import java.util.List;


public class StatsFragment extends Fragment {



    public static Fragment newInstance() {
        return new StatsFragment();
    }

    public StatsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_stats, container, false);

        BarChart chart = (BarChart) v.findViewById(R.id.chart);

        initChart(chart);
        return v;
    }

    private void initChart(BarChart chart) {
        List<BarEntry> entries = new ArrayList<BarEntry>();
        final List<Day> days = DataManagerImpl.getInstance().getDays();
        int i = 0;
        for (Day day : days) {
            i++;
            List<Thing> things = day.getThings();
            if (things.size() == 3) {
                int average = (things.get(0).getProgress() + things.get(1).getProgress() + things.get(2).getProgress()) / 3;
                entries.add(new BarEntry((float) i, (float) average));
            }

        }

        BarDataSet dataSet = new BarDataSet(entries, "level happyness");
        dataSet.setColor(getContext().getResources().getColor(R.color.colorPrimary));
        dataSet.setHighlightEnabled(false);
        BarData barData = new BarData(dataSet);
        barData.setBarWidth(0.9f);
        XAxis xAxis = chart.getXAxis();
        xAxis.setEnabled(false);
        xAxis.setDrawGridLines(false);
        xAxis.setDrawAxisLine(false);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        YAxis yAxis = chart.getAxisRight();
        yAxis.setEnabled(false);
        yAxis = chart.getAxisLeft();
        yAxis.setEnabled(false);
        yAxis.setAxisMinimum(0);
        yAxis.setAxisMaximum(100f);
        chart.setDrawGridBackground(false);
        chart.setData(barData);
        chart.setDescription(null);
        chart.getLegend().setEnabled(false);
        chart.setFocusable(false);
        chart.invalidate();
        chart.animateY(1000);
    }

}
