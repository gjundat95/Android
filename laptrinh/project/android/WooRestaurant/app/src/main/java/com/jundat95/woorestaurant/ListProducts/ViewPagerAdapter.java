package com.jundat95.woorestaurant.ListProducts;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by jundat95 on 28/03/2016.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {

    ArrayList<Fragment> listFragment = new ArrayList<Fragment>();
    ArrayList<String> listTitle = new ArrayList<String>();

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public void addFragment(Fragment fragment,String tabTitle){

        this.listFragment.add(fragment);
        this.listTitle.add(tabTitle);
    }

    @Override
    public Fragment getItem(int position) {
        return listFragment.get(position);
    }

    @Override
    public int getCount() {
        return listFragment.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return listTitle.get(position);
    }
}
