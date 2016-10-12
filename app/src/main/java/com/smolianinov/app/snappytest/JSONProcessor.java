package com.smolianinov.app.snappytest;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static com.smolianinov.app.snappytest.Constants.IMAGES;
import static com.smolianinov.app.snappytest.Constants.IMAGE_LINK;

public class JSONProcessor {


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



        //return null;


        return "{\"images\":\n" +
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
                "}";
    }

}
