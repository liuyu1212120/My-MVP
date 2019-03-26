package com.engineer.jetpack.ui;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.engineer.jetpack.R;
import com.engineer.jetpack.model.LiveDataTimerViewModel;

public class VMActivity extends AppCompatActivity {
    private static final String TAG = "VMActivity";
    private LiveDataTimerViewModel mLiveDataTimerViewModel;
    private TextView mTimerText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vm);
        mTimerText = findViewById(R.id.timer_text);
        mLiveDataTimerViewModel = ViewModelProviders.of(this).get(LiveDataTimerViewModel.class);

        subscribe();

        findViewById(R.id.button).setOnClickListener(v -> mLiveDataTimerViewModel.startRealTime());
    }

    private void subscribe() {
        mLiveDataTimerViewModel.getElapsedTime().observe(this, aLong -> {
            String value = String.valueOf(aLong);
            mTimerText.setText(value);

            Log.e(TAG, "onChanged: aLong==" + aLong);
        });
    }
}
