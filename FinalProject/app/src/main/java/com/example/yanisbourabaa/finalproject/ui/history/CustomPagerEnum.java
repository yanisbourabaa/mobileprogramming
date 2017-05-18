package com.example.yanisbourabaa.finalproject.ui.history;

import com.example.yanisbourabaa.finalproject.R;

/**
 * Created by yanisbourabaa on 17/05/2017.
 */

public enum CustomPagerEnum {

    RED(R.string.red, R.layout.view_red, R.id.first_textview),
    ORANGE(R.string.orange, R.layout.view_orange, R.id.second_textview),
    BLUE(R.string.blue, R.layout.view_blue, R.id.third_textview);

    private int mTitleResId;
    private int mLayoutResId;
    private int mTextviewId;

    CustomPagerEnum(int titleResId, int layoutResId, int textviewId) {
        mTitleResId = titleResId;
        mLayoutResId = layoutResId;
        mTextviewId = textviewId;
    }

    public int getTitleResId() {
        return mTitleResId;
    }

    public int getLayoutResId() {
        return mLayoutResId;
    }

    public int getmTextviewId() {
        return mTextviewId;
    }
}