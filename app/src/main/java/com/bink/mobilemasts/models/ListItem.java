package com.bink.mobilemasts.models;

/**
 * Created by Cyan on 02/03/2018.
 */

public class ListItem {
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

    public ListItem(String mTitle, String mSubTitle) {
        this.mTitle = mTitle;
        this.mSubTitle = mSubTitle;
    }
}
