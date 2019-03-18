package com.example.jiebing.redesign;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ExpandableListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ExpandableListView expandableListView;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment homeFragment = new HomeFragment();
            Fragment historyFragment = new HistoryFragment();
            Fragment drugsFragment = new DrugsFragment();
            Fragment moreFragment = new MoreFragment();

            switch (item.getItemId()) {
                case R.id.navigation_home:
                    setFragment(homeFragment);
                    return true;
                case R.id.navigation_history:
                    setFragment(historyFragment);
                    return true;
                case R.id.navigation_drugs:
                    setFragment(drugsFragment);
                    return true;
                case R.id.navigation_more:
                    setFragment(moreFragment);
                    return true;

                default:
                    return false;
            }

        }
    };

    private void setFragment(Fragment fragment){

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_frame,fragment);
        fragmentTransaction.commit();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.main_nav);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
