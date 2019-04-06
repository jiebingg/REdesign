package com.example.jiebing.redesign;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
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

        final String settingsOpts[] = new String[]{"Profile details", "Upcoming appointments", "Settings", "Clear history", "Contact Support"};

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, settingsOpts);

        ListView list = (ListView) view.findViewById(R.id.morelist);
        list.setAdapter(arrayAdapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Intent in = new Intent(getActivity(), ProfileDetails.class);
                    startActivity(in);
                }

                if (position == 1) {
                Intent in = new Intent(getActivity(), upcomingAppt.class);
                startActivity(in);
                }
                if (position == 2){
                    Intent in = new Intent(getActivity(), SettingsActivity.class);
                    startActivity(in);
                }
            }
        });

        return view;

    }

    public void customDialog(String title, String message, final String cancelMethod, final String okMethod){
        final android.support.v7.app.AlertDialog.Builder builderSingle = new AlertDialog.Builder(getActivity());

        builderSingle.setNegativeButton(
                "Cancel",
                new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which){

                    }
                }
        );
    }

}
