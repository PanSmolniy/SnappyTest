package com.smolianinov.app.snappytest.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.smolianinov.app.snappytest.Constants;
import com.smolianinov.app.snappytest.Downloader;
import com.smolianinov.app.snappytest.R;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Downloader downloader = new Downloader(this);
        downloader.execute(Constants.URL);
    }
}
