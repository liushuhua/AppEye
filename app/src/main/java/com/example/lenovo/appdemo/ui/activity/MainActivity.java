package com.example.lenovo.appdemo.ui.activity;

import android.os.Bundle;
import android.util.Log;

import com.example.lenovo.appdemo.R;
import com.example.lenovo.appdemo.ui.view.bottom.BottomBar;
import com.example.lenovo.appdemo.ui.view.bottom.BottomItem;

public class MainActivity extends BaseActivity {

    private static final String TAG = "MainActivity";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initBottomBar();
    }

    private void initBottomBar() {
        BottomBar bottomBar = findViewById(R.id.bottom_navigation_bar);
        bottomBar.addItem(new BottomItem(getString(R.string.home), R.drawable.ic_tab_strip_icon_feed, R.drawable.ic_tab_strip_icon_feed_selected));
        bottomBar.addItem(new BottomItem(getString(R.string.discover), R.drawable.ic_tab_strip_icon_follow, R.drawable.ic_tab_strip_icon_follow_selected));
        bottomBar.addItem(new BottomItem(getString(R.string.focus), R.drawable.ic_tab_strip_icon_category, R.drawable.ic_tab_strip_icon_category_selected));
        bottomBar.addItem(new BottomItem(getString(R.string.mine), R.drawable.ic_tab_strip_icon_profile, R.drawable.ic_tab_strip_icon_profile_selected));
        bottomBar.initialise();

        bottomBar.setOnTabSelectedListener(new BottomBar.onTabSelectedListener() {
            @Override
            public void onTabSelected(int position, int prePosition) {
                Log.i(TAG, "onTabSelected: " + position);
            }

            @Override
            public void onTabReselected(int position) {
                Log.i(TAG, "onTabReselected: " + position);
            }
        });

    }
}
