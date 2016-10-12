package com.smolianinov.app.snappytest;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.ByteArrayOutputStream;

public class Compressor {

    public static byte[] compress(final Bitmap bitmap) {

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        return stream.toByteArray();

    }

    public static Bitmap uncompress(byte[] bytes1) {
        return BitmapFactory.decodeByteArray(bytes1, 0, bytes1.length);
    }


}
