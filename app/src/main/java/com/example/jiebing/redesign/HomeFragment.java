package com.example.jiebing.redesign;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
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



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home,container,false);
        // Inflate the layout for this fragment
        ArrayList<String> notifs = new ArrayList<String>();
        notifs.add("Panadol @ 9am");
        notifs.add("Fedac @ 10am");
        notifs.add("Pill3 @ 2pm");
        notifs.add("Pill4 @ 4pm");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String> (getContext(),android.R.layout.simple_list_item_1,notifs);

        ListView list = (ListView) view.findViewById(R.id.notifs);

        list.setAdapter(new MyListAdapter(getContext(), R.layout.notiflist, notifs));

        return view;
    }

    private class MyListAdapter extends ArrayAdapter<String> {
    private int layout;
        public MyListAdapter(Context context, int resource, List<String> objects) {
            super(context, resource, objects);

            layout = resource;
        }
        
        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            ViewHolder mainViewHolder = null;
            if (convertView == null){
                LayoutInflater inflater = LayoutInflater.from(getContext());
                convertView = inflater.inflate(layout, parent, false);
                ViewHolder viewHolder = new ViewHolder();
                viewHolder.title = (TextView) convertView.findViewById(R.id.notiflist_text);
                viewHolder.button1 = (Button) convertView.findViewById(R.id.notiflist_button1);
                ViewHolder.button1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getContext(), "Taken button was clicked for notification" + position, Toast.LENGTH_SHORT).show();
                    }
                });
                viewHolder.button2 = (Button) convertView.findViewById(R.id.notiflist_button2);
                ViewHolder.button2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getContext(), "Skip button was clicked for notification" + position, Toast.LENGTH_SHORT).show();
                    }
                });
                viewHolder.button3 = (Button) convertView.findViewById(R.id.notiflist_button3);
                ViewHolder.button3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getContext(), "Snooze button was clicked for notification" + position, Toast.LENGTH_SHORT).show();
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
