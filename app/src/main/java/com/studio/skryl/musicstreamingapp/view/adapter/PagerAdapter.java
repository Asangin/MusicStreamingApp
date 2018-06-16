package com.studio.skryl.musicstreamingapp.view.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.studio.skryl.musicstreamingapp.view.MusicCollectionFragment;
import com.studio.skryl.musicstreamingapp.view.MusicSearchFragment;
import com.studio.skryl.musicstreamingapp.view.MusicUserFragment;

public class PagerAdapter extends FragmentPagerAdapter {

    public PagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new MusicCollectionFragment();
            case 1:
                return new MusicUserFragment();
            case 2:
                return new MusicSearchFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Home";
            case 1:
                return "My music";
            case 2:
                return "Search";
        }

        return null;
    }
}
