package com.smolianinov.app.snappytest.activities;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

import com.smolianinov.app.snappytest.Compressor;
import com.smolianinov.app.snappytest.R;

import static android.R.attr.data;

public class ImageActivity extends Activity {

    public ImageActivity() {
    }

    //Bitmap bmp;

    public ImageActivity(Bitmap bmp) {
        //this.bmp = bmp;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_layout);

        Intent intent = getIntent();
        //Bitmap bmp = (Bitmap) intent.getParcelableExtra("BitmapImage");

        byte[] bytes1 = intent.getByteArrayExtra("BMP");

        //byte[] bytes = data.getByteArrayExtra("BMP");
        Bitmap bmp = null;//BitmapFactory.decodeByteArray(bytes1, 0, bytes1.length);
        try {
            bmp = Compressor.uncompress(bytes1);
            ImageView imageView = (ImageView) findViewById(R.id.image);
            imageView.setImageBitmap(bmp);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //ImageView imageView = (ImageView) findViewById(R.id.image);
        //imageView.setImageBitmap(bmp);


    }
}
