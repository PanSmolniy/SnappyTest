package com.smolianinov.app.snappytest;


import android.app.Activity;
import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import com.smolianinov.app.snappytest.activities.MainActivity;

import org.json.JSONException;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

import static com.smolianinov.app.snappytest.Constants.PATH;

public class Downloader extends AsyncTask<String, String, String> {

    MainActivity activity;
    JSONProcessor processor = new JSONProcessor();

    public Downloader(Activity activity) {
        this.activity = (MainActivity) activity;
    }

    @Override
    protected String doInBackground(String... params) {
        File f = new File(PATH);
        if (!f.exists()) {
            Log.e("Doesnt Exist", "file not found");
            int count;
            try {
                URL url = new URL(params[0]);
                URLConnection conection = url.openConnection();
                conection.connect();

                // this will be useful so that you can show a tipical 0-100%
                // progress bar
                int lenghtOfFile = conection.getContentLength();

                // download the file
                InputStream input = new BufferedInputStream(url.openStream(),
                        8192);

                // Output stream
            /*OutputStream output = new FileOutputStream(Environment
                    .getExternalStorageDirectory().toString()
                    + "/" + Constants.URL_FILE_NAME + ".dat");*/
                OutputStream output = new FileOutputStream(Constants.PATH);

                byte data[] = new byte[1024];

                long total = 0;

                while ((count = input.read(data)) != -1) {
                    total += count;
                    // publishing the progress....
                    // After this onProgressUpdate will be called
                    publishProgress("" + (int) ((total * 100) / lenghtOfFile));

                    // writing data to file
                    output.write(data, 0, count);
                }

                // flushing output
                output.flush();

                // closing streams
                output.close();
                input.close();
                Log.e("Success: ", "\\m/");

            } catch (Exception e) {
                Log.e("Error: ", e.getMessage());
            }
        } else
        {
            Log.e("Exists", "file exists");
        }

        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        try {
            String[] args = processor.getLinksList();
            new RetrieveFeedTask(activity).execute(args);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Toast.makeText(activity, "Downloaded successfully", Toast.LENGTH_SHORT).show();
    }
}
