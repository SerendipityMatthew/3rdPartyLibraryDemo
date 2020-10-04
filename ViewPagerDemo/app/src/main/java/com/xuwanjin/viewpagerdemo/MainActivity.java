package com.xuwanjin.viewpagerdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";
    ViewPager viewPager;
    List<String> stringList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        stringList.add("Harry Potter");
        stringList.add("Flipped");
        stringList.add("His Darkness Materials");
        stringList.add("Handmaid Tale");
        stringList.add("Downton Abbey");
        stringList.add("Poisonwood Bible");
        viewPager = findViewById(R.id.view_pager);
        FragmentPagerAdapter pagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                Log.d(TAG, "Matthew: pagerAdapter: getItem: ");
                return new SlidePageFragment(stringList.get(position), position, stringList.size());
            }

            @Override
            public int getCount() {
                return stringList.size();
            }

            @Override
            public int getItemPosition(@NonNull Object object) {
                return POSITION_NONE;
            }
        };
        viewPager.setAdapter(pagerAdapter);
    }


}