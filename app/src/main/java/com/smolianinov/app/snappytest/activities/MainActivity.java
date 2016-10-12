package com.smolianinov.app.snappytest.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.smolianinov.app.snappytest.Compressor;
import com.smolianinov.app.snappytest.JSONProcessor;
import com.smolianinov.app.snappytest.R;
import com.smolianinov.app.snappytest.RetrieveFeedTask;

import org.json.JSONException;

import java.util.List;

//import static com.smolianinov.app.snappytest.R.id.imageView;

public class MainActivity extends AppCompatActivity {

    JSONProcessor proc = new JSONProcessor();
    //Compressor compressor = new Compressor();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        String[] args;
        try {
            args = proc.getLinksList();
            new RetrieveFeedTask(this).execute(args);
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }


}
