package com.example.MyLandlordStudio;

import android.content.Context;
import android.os.Build;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context) {
        this.context = context;
    }


    @Override
    public int getCount() {

        return 3;
    }


    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        LayoutInflater inflater = (LayoutInflater) container.getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);


        int resId = 0;
        switch (position) {
            case 0:
                resId = R.layout.address_slider_layout;
                break;
            case 1:
                resId = R.layout.description_slider_layout;
                break;
            case 2:
                resId = R.layout.confirm_slider_layout;
                break;

        }

        View view = inflater.inflate(resId, null);
        ((ViewPager) container).addView(view, 0);

        return view;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        ((ViewPager) container).removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == ((View) object);
    }

    @Nullable
    @Override
    public Parcelable saveState() {
        return null;
    }


}
