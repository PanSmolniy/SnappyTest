package com.smolianinov.app.snappytest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import org.json.JSONException;

import java.util.List;

//import static com.smolianinov.app.snappytest.R.id.imageView;

public class MainActivity extends AppCompatActivity {

    JSONProcessor proc = new JSONProcessor();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        /*
        String[] args = new String[2];
        args[0] = "http://i570.photobucket.com/albums/ss149/hipogripho/url6.jpg";
        args[1] = "http://i229.photobucket.com/albums/ee318/viusmproelium/LANDENBERG_SARNEN_flyer-1-1.jpg";
        */

        String[] args;
        try {
            args = proc.getLinksList();
            //ImageView imageView = (ImageView) findViewById(R.id.imageView);
            //ImageView imageView1 = (ImageView) findViewById(R.id.imageView2);
            new RetrieveFeedTask(this).execute(args);
        } catch (JSONException e) {
            e.printStackTrace();
        }




        //List<String> args = null;// = new


        //ImageView imageView = (ImageView) findViewById(R.id.imageView);
        //ImageView imageView1 = (ImageView) findViewById(R.id.imageView2);


    }


}
