package com.smolianinov.app.snappytest;


import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.smolianinov.app.snappytest.activities.MainActivity;

import org.json.JSONException;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import static com.smolianinov.app.snappytest.Constants.URL_FILE_NAME;

public class Downloader extends AsyncTask<String, String, String> {

    private MainActivity activity;
    private JSONProcessor processor;

    public Downloader(Activity activity) {
        this.activity = (MainActivity) activity;
        this.processor = new JSONProcessor(activity);
    }

    private boolean fileExistance(String fname) {
        File file = activity.getBaseContext().getFileStreamPath(fname);
        return file.exists();
    }

    @Override
    protected String doInBackground(String... params) {
        if (!fileExistance(URL_FILE_NAME)) {
            int count;
            try {
                URL url = new URL(params[0]);
                URLConnection conection = url.openConnection();
                conection.connect();
                int lenghtOfFile = conection.getContentLength();

                InputStream input = new BufferedInputStream(url.openStream(),
                        8192);
                FileOutputStream output = activity.openFileOutput(URL_FILE_NAME, Context.MODE_PRIVATE);

                byte data[] = new byte[1024];

                long total = 0;

                while ((count = input.read(data)) != -1) {
                    total += count;
                    publishProgress("" + (int) ((total * 100) / lenghtOfFile));
                    output.write(data, 0, count);
                }
                output.flush();

                output.close();
                input.close();

            } catch (Exception e) {
                Log.e("Error: ", e.getMessage());
            }
        }
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        try {
            String[] args = processor.getLinksList();
            new ShowImagesTask(activity).execute(args);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
