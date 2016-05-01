package com.example.android.landonhotels;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

    private boolean isRunning = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RelativeLayout container = (RelativeLayout) findViewById(R.id.container);
        container.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
//                Start the timer here
            }
        });
    }

    private void showTimer(boolean show) {
        LinearLayout layout = (LinearLayout) findViewById(R.id.linearLayout);
        TextView textView = (TextView) findViewById(R.id.tvStatus);

        if (show) {
            layout.setVisibility(View.VISIBLE);
            textView.setVisibility(View.INVISIBLE);
        } else {
            layout.setVisibility(View.INVISIBLE);
            textView.setVisibility(View.VISIBLE);
        }
    }
}
