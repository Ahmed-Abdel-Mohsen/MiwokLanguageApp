package com.example.android.miwok;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by ahmed on 3/1/2018.
 */

public class CategoryAdapter extends FragmentPagerAdapter {

    private Context mContext;
    private ArrayList<String> titles;

    public CategoryAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
        titles = new ArrayList<>();
        titles.add(mContext.getString(R.string.category_numbers));
        titles.add(mContext.getString(R.string.category_family));
        titles.add(mContext.getString(R.string.category_colors));
        titles.add(mContext.getString(R.string.category_phrases));
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new NumbersFragment();
        } else if (position == 1) {
            return new FamilyFragment();
        } else if (position == 2) {
            return new ColorsFragment();
        } else {
            return new PhrasesFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }
}
