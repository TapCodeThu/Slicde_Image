package com.example.slider_image;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator3;

public class MainActivity extends AppCompatActivity {
    private ViewPager2 mViewPager2;
    private List<PhoTo> mListPhoTo;
    private CircleIndicator3 circleIndicator3;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private Runnable mRunnable = new Runnable() {
        @Override
        public void run() {
            int currentPosition = mViewPager2.getCurrentItem();
            if(currentPosition == mListPhoTo.size() - 1){
                mViewPager2.setCurrentItem(0);
            }
            else
            {
                mViewPager2.setCurrentItem(currentPosition+1);
            }


        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewPager2 = findViewById(R.id.viewpager2);
        circleIndicator3 = findViewById(R.id.circle_indicator3);
        mListPhoTo =  getListPhoTo();
        ViewPagerAdapter adapter = new ViewPagerAdapter(this,mListPhoTo);
        mViewPager2.setAdapter(adapter);
        circleIndicator3.setViewPager(mViewPager2);
        mViewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                mHandler.removeCallbacks(mRunnable);
                mHandler.postDelayed(mRunnable,3000);
            }
        });
    }
    private List<PhoTo> getListPhoTo(){
        List<PhoTo> list = new ArrayList<>();
        list.add(new PhoTo(R.drawable.drink1));
        list.add(new PhoTo(R.drawable.drink2));
        list.add(new PhoTo(R.drawable.drink3));
        list.add(new PhoTo(R.drawable.drink4));

        return list;
    }

    @Override
    protected void onPause() {
        super.onPause();
        mHandler.removeCallbacks(mRunnable);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mHandler.postDelayed(mRunnable,3000);
    }
}