package com.smolianinov.app.snappytest;


import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;



class RetrieveFeedTask extends AsyncTask<String, Void, List<Bitmap>> {

    //ImageView img;
    //ImageView img2;
    List<ImageView> imgList = new ArrayList<>();
    Activity activity;

    public RetrieveFeedTask(Activity activity) {

        this.activity = activity;
       // this.img = img;
        //this.img2 = img2;
       // imgList.add(img);
       // imgList.add(img2);
    }

    private Exception exception;

    protected List<Bitmap> doInBackground(String... urls) {

        List<Bitmap> listBmp = new ArrayList<>();
        try {

            for (int i = 0; i < urls.length; i++) {
                URL url = new URL(urls[i]);
                Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
                listBmp.add(bmp);
            }

            //mageView.setImageBitmap(bmp);

            return listBmp;
        } catch (Exception e) {
            this.exception = e;

            return null;
        }
    }

    protected void onPostExecute(List<Bitmap> feed) {


        //imgList.get(0).setImageBitmap(feed.get(0));
        //imgList.get(1).setImageBitmap(feed.get(3));
        activity.findViewById(R.id.textView).setVisibility(View.GONE);
        View view = ((FrameLayout) activity.getWindow().getDecorView().getRootView());




        /*for (int i = 0; i < feed.size(); i++) {
            imgList.get(i).setImageBitmap(feed.get(i));
        }*/
        // TODO: check this.exception
        // TODO: do something with the feed
    }


}
