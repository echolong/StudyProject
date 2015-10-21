package com.example.study.studyproject.ui.activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.example.study.studyproject.R;
import com.example.study.studyproject.ui.view.LEDTextView;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class LEDWatchActivity extends AppCompatActivity {

    private LEDTextView ledTextView;
    private Handler mHandler = new Handler();

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
            Date date = new Date();
            calendar.setTime(date);
            String str = dateFormat(calendar);
            ledTextView.setText(str);
            mHandler.postDelayed(runnable, 500);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ledwatch);
        ledTextView = (LEDTextView) findViewById(R.id.timeText);
        mHandler.postDelayed(runnable, 0);
    }

    private String dateFormat(Calendar calendar) {
        String format = "%02d:%02d:%02d";
        return String.format(format, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), calendar.get(Calendar.SECOND));
    }

    @Override
    protected void onResume() {
        super.onResume();
        mHandler.postDelayed(runnable, 500);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mHandler.removeCallbacks(runnable);
    }
}
