package com.example.jiebing.redesign;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

import static com.github.mikephil.charting.utils.ColorTemplate.PASTEL_COLORS;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }

    private BarChart mChart;
    private TextView theDate;
    private Button button;

    RecyclerView list;
    String [] notifArray = {"Panadol @ 11am", "Fedac @ 2pm", "Ibuprofen @ 5pm"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home,container,false);
        // Inflate the layout for this fragment

        mChart = (BarChart) view.findViewById(R.id.barchart);
        ArrayList<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(4f, 0));
        entries.add(new BarEntry(8f, 1));
        entries.add(new BarEntry(6f, 2));
        entries.add(new BarEntry(12f, 3));
        entries.add(new BarEntry(8f, 4));

        ArrayList<String> labels = new ArrayList<String>();
        labels.add("Panadol");
        labels.add("Zyrtec");
        labels.add("Fedac");
        labels.add("Ibuprofen");
        labels.add("Med");

        BarDataSet dataset = new BarDataSet(entries, "# of pills left");
        BarData data = new BarData(labels, dataset);
        int color = ContextCompat.getColor(getContext(), R.color.chartColor);
        dataset.setColor(color);
        mChart.setDescription("");
        mChart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
        mChart.getAxisLeft().setDrawGridLines(false);
        mChart.getXAxis().setDrawGridLines(false);
        mChart.setData(data);

        theDate = (TextView) view.findViewById(R.id.date);
        button = (Button) view.findViewById(R.id.goToCalendar);

        Intent incomingIntent = getActivity().getIntent();
        String date = incomingIntent.getStringExtra("date");
        theDate.setText(date);

        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                Intent intent = new Intent(getActivity(), CalendarActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }


}

