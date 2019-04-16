package com.example.jiebing.redesign;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        ListView list = findViewById(R.id.settingsList);


        ArrayList<String> settingsList = new ArrayList<>();

        settingsList.add("About MiPi");
        settingsList.add("Alerts and Notifications");
        settingsList.add("Language Options");
        settingsList.add("Suspend Dispenser");



        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, settingsList);

        list.setAdapter(arrayAdapter);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Intent in = new Intent(getApplicationContext(), AboutMiPi.class);
                    startActivity(in);
                }

                if (position == 1) {

                }
                if (position == 2){

                }

                if (position == 3){
                    customDialog("Warning", "The MiPi dispenser will stop dispensing any medication. Click OK to proceed.", "methodCancel1", "methodOK1");
                }

            }
        });

    }

    private static final String TAG = "SettingsActivity";

    private void cancelMethod1(){
        Log.d(TAG, "cancelmethod1: Called");
        toastMessage("Cancel Method.");

    }

    private void okMethod1(){
        Log.d(TAG, "okmethod1: Called");
        toastMessage("OK Method.");

    }

    public void customDialog(String title, String message, final String cancelMethod, final String okMethod){
        final android.support.v7.app.AlertDialog.Builder builderSingle = new AlertDialog.Builder(this);

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

        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }
}


