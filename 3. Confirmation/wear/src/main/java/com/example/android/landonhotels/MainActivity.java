package com.example.android.landonhotels;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.activity.ConfirmationActivity;
import android.support.wearable.view.DelayedConfirmationView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends Activity implements DelayedConfirmationView.DelayedConfirmationListener {
    private boolean isRunning = false;
    private DelayedConfirmationView delayedConfirmationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        delayedConfirmationView = (DelayedConfirmationView)findViewById(R.id.delayed_confirm);
        delayedConfirmationView.setListener(this);
        delayedConfirmationView.setTotalTimeMs(3000);

        RelativeLayout container = (RelativeLayout) findViewById(R.id.container);
        container.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
//                Start the timer here
                if (!isRunning) {
                    showTimer(true);
                    delayedConfirmationView.start();
                    isRunning = true;
                }
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

    @Override
    public void onTimerFinished(View view) {
        showTimer(false);
        isRunning = false;
        showConfirmation(ConfirmationActivity.SUCCESS_ANIMATION, "Confirmed");
    }

    private void showConfirmation(int animation, String message) {
        Intent i = new Intent(this, ConfirmationActivity.class);
        i.putExtra(ConfirmationActivity.EXTRA_ANIMATION_TYPE, animation);
        i.putExtra(ConfirmationActivity.EXTRA_MESSAGE, message);
        startActivity(i);
    }

    @Override
    public void onTimerSelected(View view) {
        showTimer(false);
        isRunning = false;
        delayedConfirmationView.reset();
        showConfirmation(ConfirmationActivity.FAILURE_ANIMATION, "Cancelled");
    }
}
