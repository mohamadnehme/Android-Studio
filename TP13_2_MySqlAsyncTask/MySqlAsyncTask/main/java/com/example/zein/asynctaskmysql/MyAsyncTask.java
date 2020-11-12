package com.example.zein.asynctaskmysql;

import android.os.AsyncTask;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class MyAsyncTask extends AsyncTask<String, String, Void> {


    private TextView resultTextView;

    public MyAsyncTask(TextView textView) {

        this.resultTextView = textView;
    }

    @Override
    protected Void doInBackground(String... params) {

        String id = params[0];
        try {
            URL url = new URL("http://192.168.43.71/testandroidconnection/getUser.php?id=" + id);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            InputStream inputStream = connection.getInputStream();

            BufferedReader rd = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            String answer = "";
            while ((line = rd.readLine()) != null) {
                answer += line;
            }

            publishProgress(answer);

        } catch (Exception e) {
            System.out.println("Error:   " + e.toString());
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(String... progress) {
        super.onProgressUpdate();

        // Update the UI
        this.resultTextView.setText(progress[0]);

    }

}
