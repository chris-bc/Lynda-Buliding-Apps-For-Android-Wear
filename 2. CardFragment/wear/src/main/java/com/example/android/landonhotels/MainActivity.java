package com.example.android.landonhotels;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.wearable.view.CardFragment;
import android.support.wearable.view.WatchViewStub;
import android.widget.TextView;

public class MainActivity extends Activity {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        CardFragment fragment = CardFragment.create(getString(R.string.card_title),
                getString(R.string.card_description),
                R.drawable.landon_icon);
        transaction.add(R.id.frame_layout, fragment);
        transaction.commit();
    }
}
