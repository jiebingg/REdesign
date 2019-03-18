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
        ArrayList<String> notifs = new ArrayList<String>();
        notifs.add("Upcoming appointments");
        notifs.add("Settings");
        notifs.add("Clear history");
        notifs.add("Contact Support");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String> (getContext(),android.R.layout.simple_list_item_1,notifs);

        ListView list = (ListView) view.findViewById(R.id.morelist);
        list.setAdapter(arrayAdapter);

        return view;
    }

}
