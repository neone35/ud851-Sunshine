package com.example.android.sunshine;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DetailActivity extends AppCompatActivity {

    private static final String FORECAST_SHARE_HASHTAG = " #SunshineApp";

    TextView mDetailWeather;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        String intentExtraName = "weatherForDay";
        // COMPLETE (2) Display the weather forecast that was passed from MainActivity
        Intent externalIntent = this.getIntent();
        if (externalIntent.hasExtra(intentExtraName)) {
            String weatherMain = externalIntent.getStringExtra(intentExtraName);
            mDetailWeather = (TextView) findViewById(R.id.tv_detail_data);
            mDetailWeather.setText(weatherMain);
        }
    }
}