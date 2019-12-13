package com.un.android.test.model;

public class ModTimeDate {
    private long mInitialTime;
    private int mTimeValue1;
    private int mTimeValue2;
    private int mTimeValue3;

    public ModTimeDate() {
    }

    public ModTimeDate(long mInitialTime, int mTimeValue1, int mTimeValue2, int mTimeValue3) {
        this.mInitialTime = mInitialTime;
        this.mTimeValue1 = mTimeValue1;
        this.mTimeValue2 = mTimeValue2;
        this.mTimeValue3 = mTimeValue3;
    }

    public long getmInitialTime() {
        return mInitialTime;
    }

    public void setmInitialTime(long mInitialTime) {
        this.mInitialTime = mInitialTime;
    }

    public int getmTimeValue1() {
        return mTimeValue1;
    }

    public void setmTimeValue1(int mTimeValue1) {
        this.mTimeValue1 = mTimeValue1;
    }

    public int getmTimeValue2() {
        return mTimeValue2;
    }

    public void setmTimeValue2(int mTimeValue2) {
        this.mTimeValue2 = mTimeValue2;
    }

    public int getmTimeValue3() {
        return mTimeValue3;
    }

    public void setmTimeValue3(int mTimeValue3) {
        this.mTimeValue3 = mTimeValue3;
    }
}
