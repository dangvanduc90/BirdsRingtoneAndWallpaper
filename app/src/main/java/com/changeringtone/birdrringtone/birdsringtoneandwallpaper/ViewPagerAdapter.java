package com.changeringtone.birdrringtone.birdsringtoneandwallpaper;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new FragmentRingTone();
                break;
            case 1:
                fragment = new FragmentRecommend();
                break;
            default:
                fragment = new FragmentRingTone();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        switch (position) {
            case 0:
                title = "RINGTOBES";
                break;
            case 1:
                title = "RECOMMEND";
                break;
            default:
                title = "RINGTOBES";
                break;
        }
        return title;
    }
}
