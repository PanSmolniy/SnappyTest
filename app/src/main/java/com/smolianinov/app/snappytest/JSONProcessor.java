package com.smolianinov.app.snappytest;


import android.app.Activity;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import static android.R.attr.data;
import static com.smolianinov.app.snappytest.Constants.IMAGES;
import static com.smolianinov.app.snappytest.Constants.IMAGE_LINK;
import static com.smolianinov.app.snappytest.Constants.URL_FILE_NAME;

public class JSONProcessor {

    Activity activity;

    public JSONProcessor(Activity activity) {
        this.activity = activity;
    }

    //private final String IMAGES = "images";
    //private final String IMAGE_LINK = "image_url";

    public String[] getLinksList() throws JSONException {


        JSONObject links = new JSONObject(getJsonString());

        JSONArray linksArr = links.getJSONArray(Constants.IMAGES);
        String[] res = new String[linksArr.length()];
        for (int i =0; i < linksArr.length(); i++)
        {
            res[i] = linksArr.getJSONObject(i).getString(Constants.IMAGE_LINK);
        }

        return res;

    }

    private String getJsonString()
    {

        String json;

        File file = new File(Constants.PATH);
        InputStream is;
        try {
            //is = new FileInputStream(file);
            is = activity.openFileInput(URL_FILE_NAME);


            int size = is.available();

            byte[] buffer = new byte[size];

            is.read(buffer);

            is.close();

            json = new String(buffer, "UTF-8");
            return json;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        //return null;


        /*return "{\"images\":\n" +
                "[\n" +
                "{\"image_url\":\"http://i1134.photobucket.com/albums/m614/Anadre5/3.jpg\"},\n" +
                "{\"image_url\":\"http://i229.photobucket.com/albums/ee318/viusmproelium/LANDENBERG_SARNEN_flyer-1-1.jpg\"},\n" +
                "{\"image_url\":\"http://i570.photobucket.com/albums/ss149/hipogripho/url6.jpg\"},\n" +
                "{\"image_url\":\"http://i707.photobucket.com/albums/ww74/25568380/7395793f.jpg\"},\n" +
                "{\"image_url\":\"http://i217.photobucket.com/albums/cc312/mastersig/Avitars/For%20Me/C_D_A.png\"},\n" +
                "{\"image_url\":\"http://i419.photobucket.com/albums/pp278/joros7/direccion-url.jpg\"},\n" +
                "{\"image_url\":\"http://i1187.photobucket.com/albums/z395/antonwahyu/098-1.jpg\"},\n" +
                "{\"image_url\":\"http://i599.photobucket.com/albums/tt79/cruzyd22/WEBVACABRAVA4-FG.jpg\"},\n" +
                "{\"image_url\":\"http://i314.photobucket.com/albums/ll412/hamerdude/Utube.jpg\"},\n" +
                "{\"image_url\":\"http://i570.photobucket.com/albums/ss149/hipogripho/jhcg.jpg\"},\n" +
                "{\"image_url\":\"http://i618.photobucket.com/albums/tt268/margmidd/INDMRGCOM-1Y-11.png\"},\n" +
                "{\"image_url\":\"http://i1088.photobucket.com/albums/i324/chishono/Short%20North%20Chiropractic/shortnorthchiropractic1.jpg\"}\n" +
                "]\n" +
                "}";*/
    }




}
