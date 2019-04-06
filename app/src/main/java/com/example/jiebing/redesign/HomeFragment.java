package com.example.jiebing.redesign;


import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }

    private TextView theDate;
    private Button button;

    ListView list;
    String [] notifArray = {"Panadol @ 11am", "Fedac @ 2pm", "Ibuprofen @ 5pm"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home,container,false);
        // Inflate the layout for this fragment

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

        list = (ListView) view.findViewById(R.id.notifs);
        MyListAdapter adapter = new MyListAdapter(getContext(), notifArray);

        list.setAdapter(adapter);
        return view;
    }



    private class MyListAdapter extends ArrayAdapter<String> {
        Context context;
        String myTitles[];



        public MyListAdapter(Context c, String[] titles) {
            super(c, R.layout.notiflist, R.id.notiflist_text, titles);
            this.context = c;
            this.myTitles= titles;


        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            ViewHolder mainViewHolder = null;


            if (convertView == null){
                LayoutInflater inflater = LayoutInflater.from(getContext());
                convertView = inflater.inflate(R.layout.notiflist, parent, false);
                ViewHolder viewHolder = new ViewHolder();

                TextView title = (TextView) convertView.findViewById(R.id.notiflist_text);
                title.setText(myTitles[position]);

                viewHolder.button1 = (Button) convertView.findViewById(R.id.notiflist_button1);
                ViewHolder.button1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getContext(), "Taken button was clicked for notification" + (position +1), Toast.LENGTH_SHORT).show();
                    }
                });
                viewHolder.button2 = (Button) convertView.findViewById(R.id.notiflist_button2);
                ViewHolder.button2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getContext(), "Skip button was clicked for notification" + (position +1), Toast.LENGTH_SHORT).show();
                    }
                });
                viewHolder.button3 = (Button) convertView.findViewById(R.id.notiflist_button3);
                ViewHolder.button3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getContext(), "Snooze button was clicked for notification" + (position + 1), Toast.LENGTH_SHORT).show();
                    }
                });
                convertView.setTag(viewHolder);
            }

            else {
                mainViewHolder = (ViewHolder) convertView.getTag();
                mainViewHolder.title.setText(getItem(position));

            }

            return convertView;
        }
    }

    public static class ViewHolder{

        TextView title;
        static Button button1;
        static Button button2;
        static Button button3;
    }
}

