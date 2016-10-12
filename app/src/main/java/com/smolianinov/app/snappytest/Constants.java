package com.smolianinov.app.snappytest;


import android.os.Environment;

public interface Constants
{
    String URL = "https://docs.google.com/uc?authuser=0&id=0B-yx9N-CwvshMi1Kc3pxbEJUdGM&export=download";
    String URL_FILE_NAME = "links.dat";
    String PATH = Environment
            .getExternalStorageDirectory().toString()
            + "/" + URL_FILE_NAME;
    String IMAGES = "images";
    String IMAGE_LINK = "image_url";
}
