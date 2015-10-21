package com.example.study.studyproject.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.study.studyproject.R;
import com.example.study.studyproject.obj.WeatherObject;
import com.example.study.studyproject.presenter.impl.WeatherPresenterImpl;
import com.example.study.studyproject.ui.inter.WeatherView;

public class WeatherActivity extends Activity implements WeatherView, View.OnClickListener {

    private TextView mInfo;
    private EditText mEdit;
    private WeatherPresenterImpl weatherPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        mInfo = (TextView) findViewById(R.id.weather_text);
        mEdit = (EditText) findViewById(R.id.city_name);

        findViewById(R.id.request_btn).setOnClickListener(this);
        weatherPresenter = new WeatherPresenterImpl(this);
    }

    @Override
    public void show(WeatherObject object) {
        mInfo.setText(object.getWeatherInfo());
    }

    @Override
    public void onClick(View v) {
        String city = mEdit.getText().toString();
        weatherPresenter.getWeather(city);
    }

    @Override
    public void fail(String failInfo) {
        mInfo.setText(failInfo);
    }
}
