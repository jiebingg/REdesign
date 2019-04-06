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

                if (position == 3){
                    customDialog("Warning", "All details in app will be reset. Click OK to proceed.", "methodCancel1", "methodOK1");
                }

                if (position == 4){
                    //send email
                    Intent in = new Intent(getActivity(), SendEmail.class);
                    startActivity(in);
                }
            }
        });



        return view;

    }


    private static final String TAG = "HomeFragment";

    private void cancelMethod1(){
        Log.d(TAG, "cancelmethod1: Called");
        toastMessage("Cancel Method.");

    }

    private void okMethod1(){
        Log.d(TAG, "okmethod1: Called");
        toastMessage("OK Method.");

    }

    public void customDialog(String title, String message, final String cancelMethod, final String okMethod){
        final android.support.v7.app.AlertDialog.Builder builderSingle = new AlertDialog.Builder(getActivity());

        builderSingle.setIcon(R.drawable.ic_warning);
        builderSingle.setTitle(title);
        builderSingle.setMessage(message);


        builderSingle.setNegativeButton(
                "Cancel",
                new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which){
                        Log.d(TAG, "onClick: Cancel Called.");
                        if(cancelMethod.equals("cancelMethod1")){
                            cancelMethod1();
                        }

                    }
                }
        );

        builderSingle.setPositiveButton("OK",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.d(TAG, "onClick: OK Called.");
                        if (okMethod.equals("okMethod1")){
                            okMethod1();
                        }
                    }
                }
        );

        builderSingle.show();
    }

    public void toastMessage(String message){

        Toast.makeText(getActivity(),message, Toast.LENGTH_SHORT).show();
    }
}
