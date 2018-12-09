package com.example.alexandr.myapplication;

public class ExampleIetm {
    private int mImageResource;
    private String mText1;
    private String mText2;
    private boolean mCheckBox;

    public ExampleIetm(int imageResource, String text1, String text2, boolean checked) {
        mImageResource = imageResource;
        mText1 = text1;
        mText2 = text2;
        mCheckBox = checked;
    }

    public int getmImageResource() {
        return mImageResource;
    }

    public String getmText1() {
        return mText1;
    }
    public String getmText2() {
        return mText2;
    }

}