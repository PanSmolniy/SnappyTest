package com.smolianinov.app.snappytest;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.smolianinov.app.snappytest.activities.ImageActivity;
import com.smolianinov.app.snappytest.activities.MainActivity;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import java.io.ByteArrayOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;

public class RetrieveFeedTask extends AsyncTask<String, Void, List<Bitmap>> {

    MainActivity activity;

    public RetrieveFeedTask(MainActivity activity) {

        this.activity = activity;
    }

    protected List<Bitmap> doInBackground(String... urls) {

        List<Bitmap> listBmp = new ArrayList<>();
        try {

            for (int i = 0; i < urls.length; i++) {
                URL url = new URL(urls[i]);
                Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
                listBmp.add(bmp);
            }

            return listBmp;
        } catch (Exception e) {

            return null;
        }
    }

    protected void onPostExecute(List<Bitmap> feed) {


        //imgList.get(0).setImageBitmap(feed.get(0));
        //imgList.get(1).setImageBitmap(feed.get(3));
        activity.findViewById(R.id.textView).setVisibility(View.GONE);
        //View view = ((FrameLayout) activity.getWindow().getDecorView().getRootView());

        final ImageAdapter adapt = new ImageAdapter(activity, feed);
        GridView gridview = (GridView) activity.findViewById(R.id.gridview);
        gridview.setAdapter(adapt);

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    final int position, long id) {

                Thread a = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        callImageActivity((Bitmap) adapt.getItem(position));
                    }
                });
                a.start();
                //callImageActivity((Bitmap) adapt.getItem(position));
            }
        });






        /*for (int i = 0; i < feed.size(); i++) {
            imgList.get(i).setImageBitmap(feed.get(i));
        }*/
        // TODO: check this.exception
        // TODO: do something with the feed
    }

    private void callImageActivity(Bitmap bitmap) {

        Intent intent = new Intent(activity, ImageActivity.class);
        /*ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] bytes = stream.toByteArray();*/
        //byte[] bytes = (MainActivity) activity.getCompressor();


        intent.putExtra("BMP", Compressor.compress(bitmap));
        //intent.putExtra("compressor", activity.getCompressor());
        activity.startActivity(intent);
    }








}
