package com.example.slider_image;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.List;

public class ViewPagerAdapter extends FragmentStateAdapter {
    private List<PhoTo> mlistPhoTo;
    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity,List<PhoTo> list) {
        super(fragmentActivity);
        this.mlistPhoTo = list;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        PhoTo phoTo = mlistPhoTo.get(position);
        Bundle bundle = new Bundle();
        bundle.putSerializable("object_photo",phoTo);
        PhoToFragment phoToFragment = new PhoToFragment();
        phoToFragment.setArguments(bundle);
        return phoToFragment;
    }

    @Override
    public int getItemCount() {
        return mlistPhoTo.size();
    }
}
