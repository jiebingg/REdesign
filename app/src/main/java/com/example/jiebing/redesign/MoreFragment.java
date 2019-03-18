package com.example.jiebing.redesign;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MoreFragment extends Fragment {


    public MoreFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_more, container, false);
        ArrayList<String> settingsOpts = new ArrayList<String>();
        settingsOpts.add("Upcoming appointments");
        settingsOpts.add("Settings");
        settingsOpts.add("Clear history");
        settingsOpts.add("Contact Support");
        settingsOpts.add("Suspend MiPi dispenser");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String> (getContext(),android.R.layout.simple_list_item_1,settingsOpts);

        ListView list = (ListView) view.findViewById(R.id.morelist);
        list.setAdapter(arrayAdapter);

        return view;
    }

}
