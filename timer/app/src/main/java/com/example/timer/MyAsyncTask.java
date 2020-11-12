package com.example.timer;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.widget.TextView;

public class MyAsyncTask extends AsyncTask<String, String, Void> {
    private TextView resultTextView;

    public MyAsyncTask(TextView textView) {
        this.resultTextView = textView;
    }
    @Override
    protected Void doInBackground(String... params) {
            int c = Integer.parseInt(params[0]);
            if(isCancelled()){
                return null;
            } else {
                c++;

            }
            publishProgress(Integer.toString(c));
        try {
            Thread.sleep((1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
    @SuppressLint("WrongThread")
    @Override
    protected void onProgressUpdate(String... progress) {
        super.onProgressUpdate();

        // Update the UI
        this.resultTextView.setText(progress[0]);

            doInBackground(progress[0]);
    }
}
