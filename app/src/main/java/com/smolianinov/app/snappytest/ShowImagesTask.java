package com.smolianinov.app.snappytest;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.smolianinov.app.snappytest.activities.ImageActivity;
import com.smolianinov.app.snappytest.activities.MainActivity;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class ShowImagesTask extends AsyncTask<String, Void, List<Bitmap>> {

    private MainActivity activity;

    public ShowImagesTask(MainActivity activity) {
        this.activity = activity;
    }

    protected List<Bitmap> doInBackground(String... urls) {

        Log.d("Downloaded", " start packing");

        List<Bitmap> listBmp = new ArrayList<>();
        try {

            for (String url1 : urls) {
                URL url = new URL(url1);
                Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
                listBmp.add(bmp);
            }

            return listBmp;
        } catch (Exception e) {

            return null;
        }
    }

    protected void onPostExecute(List<Bitmap> feed) {

        activity.findViewById(R.id.textView).setVisibility(View.GONE);

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
            }
        });
    }

    private void callImageActivity(Bitmap bitmap) {
        Intent intent = new Intent(activity, ImageActivity.class);
        intent.putExtra("BMP", Compressor.compress(bitmap));
        activity.startActivity(intent);
    }
}
