package com.example.android.landonhotels;

import android.graphics.Color;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends WearableActivity {

    private TextView mTextView;
    private RelativeLayout mLayoutContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setAmbientEnabled();

        mTextView = (TextView) findViewById(R.id.textView);
        mLayoutContainer = (RelativeLayout) findViewById(R.id.layoutContainer);

    }

    @Override
    public void onEnterAnimationComplete() {
        super.onEnterAnimationComplete();

        mLayoutContainer.setBackgroundResource(android.R.color.black);
        mTextView.setTextColor(Color.WHITE);
        mTextView.getPaint().setAntiAlias(true);
    }

    @Override
    public void onExitAmbient() {
        super.onExitAmbient();

        mLayoutContainer.setBackgroundResource(android.R.color.holo_blue_light);
        mTextView.setTextColor(Color.BLACK);
        mTextView.getPaint().setAntiAlias(false);
    }
}
