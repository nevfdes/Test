package com.persistent.esansad.fragments;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.utils.Legend;
import com.persistent.esansad.R;

import java.util.ArrayList;

/**
 * Created by ashwin_valento on 03-Feb-15.
 */
public class NotificationFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_notification,container,false);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        PieChart chart = (PieChart) getActivity().findViewById(R.id.chart);

        chart.setDescription("Money Utilization");
        chart.setDrawYValues(true);

        ArrayList<Entry> valsComp1 = new ArrayList<Entry>();
        //ArrayList<Entry> valsComp2 = new ArrayList<Entry>();

        Entry c1e1 = new Entry(10.000f, 0); // 0 == quarter 1
        valsComp1.add(c1e1);
        Entry c1e2 = new Entry(50.000f, 1); // 1 == quarter 2 ...
        valsComp1.add(c1e2);
        Entry c2e1 = new Entry(20.000f, 2); // 0 == quarter 1
        valsComp1.add(c2e1);
        Entry c2e2 = new Entry(30.000f, 3); // 1 == quarter 2 ...
        valsComp1.add(c2e2);

        ArrayList<String> xVals = new ArrayList<String>();
        xVals.add("10");
        xVals.add("20");
        xVals.add("30");
        xVals.add("40");

        PieDataSet setComp1 = new PieDataSet(valsComp1, "Money");
        PieData data = new PieData(xVals, setComp1);
        chart.setData(data);
        //PieDataSet setComp2 = new PieDataSet(valsComp2, "Company 2");

        setComp1.setColors(new int[] { R.color.blue,R.color.red,R.color.green,R.color.darkorange }, getActivity());
        // sets colors for the dataset, resolution of the resource name to a "real" color is done internally
        //chart.setData(data);
        chart.setHoleColor(Color.rgb(235, 235, 235));
        chart.setHoleRadius(60f);
        chart.setDescription("Money Utilization");
        chart.setDrawYValues(true);
        chart.setDrawCenterText(true);
        chart.setDrawHoleEnabled(true);
        chart.setRotationAngle(0);
        // draws the corresponding description value into the slice
        chart.setDrawXValues(true);
        // enable rotation of the chart by touch
        chart.setRotationEnabled(true);
        // display percentage values
        chart.setUsePercentValues(true);
        // mChart.setUnit(" €");
        // mChart.setDrawUnitsInChart(true);
        // add a selection listener
        // mChart.setTouchEnabled(false);

        chart.setCenterText("Money Utilization");
        chart.animateXY(1500, 1500);
        // mChart.spin(2000, 0, 360);

        Legend l = chart.getLegend();
        l.setPosition(Legend.LegendPosition.RIGHT_OF_CHART);
        l.setXEntrySpace(7f);
        l.setYEntrySpace(5f);

    }


}
