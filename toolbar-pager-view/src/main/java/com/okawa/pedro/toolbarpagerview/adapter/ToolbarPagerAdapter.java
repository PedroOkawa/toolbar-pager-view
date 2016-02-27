package com.okawa.pedro.toolbarpagerview.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by pokawa on 27/02/16.
 */
public class ToolbarPagerAdapter extends FragmentPagerAdapter {

    private static final String PAGE_DUPLICATED_MESSAGE = "You're trying to add a duplicated page, are you doublethinking? - Orwell, George / Index: ";

    private ArrayList<Fragment> pages;

    public ToolbarPagerAdapter(FragmentManager fm) {
        super(fm);
        pages = new ArrayList<>();
    }

    public void addPage(Fragment fragment) {
        pages.add(fragment);
        notifyDataSetChanged();
    }

    @Override
    public Fragment getItem(int position) {
        return pages.get(position);
    }

    @Override
    public int getCount() {
        return pages.size();
    }
}
