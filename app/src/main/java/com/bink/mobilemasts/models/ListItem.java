package com.bink.mobilemasts.models;

/**
 * Created by Cyan on 02/03/2018.
 */

public class ListItem<T> {
    // Object stored
    private T mItem;

    // Header text (title)
    private String mTitle;

    // Subheader text (subtitle)
    private String mSubTitle;

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getSubTitle() {
        return mSubTitle;
    }

    public void setSubTitle(String mSubTitle) {
        this.mSubTitle = mSubTitle;
    }

    public T getItem() {
        return mItem;
    }

    public void setItem(T mItem) {
        this.mItem = mItem;
    }

    public ListItem(String mTitle, String mSubTitle, T mItem) {
        this.mItem = mItem;
        this.mTitle = mTitle;
        this.mSubTitle = mSubTitle;
    }
}
