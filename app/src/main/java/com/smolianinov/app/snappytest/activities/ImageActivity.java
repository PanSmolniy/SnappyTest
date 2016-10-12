package com.smolianinov.app.snappytest.activities;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;

import com.smolianinov.app.snappytest.Compressor;
import com.smolianinov.app.snappytest.R;

public class ImageActivity extends Activity {

    public ImageActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_layout);

        Intent intent = getIntent();
        byte[] bytes = intent.getByteArrayExtra("BMP");

        Bitmap bmp;
        bmp = Compressor.uncompress(bytes);

        ImageView imageView = (ImageView) findViewById(R.id.image);
        imageView.setImageBitmap(bmp);
    }
}
