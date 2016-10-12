package com.smolianinov.app.snappytest;

import android.app.Activity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;

import static com.smolianinov.app.snappytest.Constants.URL_FILE_NAME;

class JSONProcessor {

    private Activity activity;

    JSONProcessor(Activity activity) {
        this.activity = activity;
    }


    String[] getLinksList() throws JSONException {

        JSONObject links = new JSONObject(getJsonString());
        JSONArray linksArr = links.getJSONArray(Constants.IMAGES);

        String[] res = new String[linksArr.length()];
        for (int i = 0; i < linksArr.length(); i++) {
            res[i] = linksArr.getJSONObject(i).getString(Constants.IMAGE_LINK);
        }
        return res;
    }

    private String getJsonString() {
        String json;

        InputStream is;
        try {
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
    }
}
