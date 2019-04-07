package com.example.jiebing.redesign;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class upcomingAppt extends AppCompatActivity {


    ListView list;
    String titles[] = {"January", "February", "March", "April", "June", "July"};
    String descriptions[] = {"Appt1", "Appt2", "Appt3"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upcoming_appt);


        ListView list = (ListView) findViewById(R.id.apptList);

        ArrayList<String> apptList = new ArrayList<>();


        apptList.add("17 May 2019 \n1:00pm @ Thomson Medical Centre");
        apptList.add("28 Jun 2019 \n11:30am @ Thomson Medical Centre");
        apptList.add("19 Aug 2019 \n 10:30am @ National University Hospital");
        apptList.add("10 Sept 2019 \n 2:00pm @ Thomson Medical Centre");


        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, apptList);

        list.setAdapter(arrayAdapter);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        }
    }


