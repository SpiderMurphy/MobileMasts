package com.bink.mobilemasts.models;

import com.bink.mobilemasts.adapters.AdapterViewPager;

/**
 * Created by Cyan on 02/03/2018.
 */

public class PageModel {
    // Layout res id
    private int mLayoutResourceId;

    // Title id
    private int mTitleId;

    // View listener
    private AdapterViewPager.ViewListener mViewListener;

    public int getLayoutResourceId() {
        return mLayoutResourceId;
    }

    public void setLayoutResourceId(int mLayoutResourceId) {
        this.mLayoutResourceId = mLayoutResourceId;
    }

    public int getTitleId() {
        return mTitleId;
    }

    public void setTitleId(int mTitleId) {
        this.mTitleId = mTitleId;
    }

    public AdapterViewPager.ViewListener getViewListener() {
        return mViewListener;
    }

    public void setViewListener(AdapterViewPager.ViewListener mViewListener) {
        this.mViewListener = mViewListener;
    }

    public PageModel(int mLayoutResourceId, int mTitleId, AdapterViewPager.ViewListener mViewListener) {
        this.mLayoutResourceId = mLayoutResourceId;
        this.mTitleId = mTitleId;
        this.mViewListener = mViewListener;
    }
}
