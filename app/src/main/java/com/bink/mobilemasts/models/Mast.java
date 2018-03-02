package com.bink.mobilemasts.models;

import java.util.Date;

/**
 * Created by Cyan on 02/03/2018.
 */

public class Mast {
    private String mPropertyName;
    private String mPropertyAddress1;
    private String mPropertyAddress2;
    private String mPropertyAddress3;
    private String mPropertyAddress4;
    private String mUnitName;
    private Date mLeaseStartDate;
    private Date mLeaseEndDate;
    private int mLeaseYears;
    private double mCurrentRent;

    public String getPropertyName() {
        return mPropertyName;
    }

    public void setPropertyName(String mPropertyName) {
        this.mPropertyName = mPropertyName;
    }

    public String getPropertyAddress1() {
        return mPropertyAddress1;
    }

    public void setPropertyAddress1(String mPropertyAddress1) {
        this.mPropertyAddress1 = mPropertyAddress1;
    }

    public String getPropertyAddress2() {
        return mPropertyAddress2;
    }

    public void setPropertyAddress2(String mPropertyAddress2) {
        this.mPropertyAddress2 = mPropertyAddress2;
    }

    public String getPropertyAddress3() {
        return mPropertyAddress3;
    }

    public void setPropertyAddress3(String mPropertyAddress3) {
        this.mPropertyAddress3 = mPropertyAddress3;
    }

    public String getPropertyAddress4() {
        return mPropertyAddress4;
    }

    public void setPropertyAddress4(String mPropertyAddress4) {
        this.mPropertyAddress4 = mPropertyAddress4;
    }

    public String getUnitName() {
        return mUnitName;
    }

    public void setUnitName(String mUnitName) {
        this.mUnitName = mUnitName;
    }

    public Date getLeaseStartDate() {
        return mLeaseStartDate;
    }

    public void setLeaseStartDate(Date mLeaseStartDate) {
        this.mLeaseStartDate = mLeaseStartDate;
    }

    public Date getLeaseEndDate() {
        return mLeaseEndDate;
    }

    public void setLeaseEndDate(Date mLeaseEndDate) {
        this.mLeaseEndDate = mLeaseEndDate;
    }

    public int getLeaseYears() {
        return mLeaseYears;
    }

    public void setLeaseYears(int mLeaseYears) {
        this.mLeaseYears = mLeaseYears;
    }

    public double getCurrentRent() {
        return mCurrentRent;
    }

    public void setCurrentRent(double mCurrentRent) {
        this.mCurrentRent = mCurrentRent;
    }
}
