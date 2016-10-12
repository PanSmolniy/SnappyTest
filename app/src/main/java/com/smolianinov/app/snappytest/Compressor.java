package com.smolianinov.app.snappytest;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.util.concurrent.Callable;

public class Compressor {

    public static byte[] compress(final Bitmap bitmap) {


       // Thread t = new Thread(new Callable<byte[]>() {


            /*public void run() {
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
                byte[] bytes = stream.toByteArray();
            }*/
       // });
        /*ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] bytes = stream.toByteArray();*/

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] bytes = stream.toByteArray();
        return bytes;

        //return new CompressorCollable(bitmap).call();
    }



    public static Bitmap uncompress(byte[] bytes1) {
        //byte[] bytes1 = intent.getByteArrayExtra("BMP");

        //byte[] bytes = data.getByteArrayExtra("BMP");
        return BitmapFactory.decodeByteArray(bytes1, 0, bytes1.length);
        //return new DecompressorCallable(bytes1).call();
    }

    /*static class DecompressorCallable implements Callable<Bitmap>
    {
        byte[] bytes;

        public DecompressorCallable(byte[] bytes) {
            this.bytes = bytes;
        }


        @Override
        public Bitmap call() throws Exception {
            return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
        }
    }

    static class CompressorCollable implements Callable<byte[]>
    {

        Bitmap bitmap;

        public CompressorCollable(Bitmap bitmap) {
            this.bitmap = bitmap;
        }

        @Override
        public byte[] call() throws Exception {

            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
            byte[] bytes = stream.toByteArray();
            return bytes;
        }
    }*/
}
