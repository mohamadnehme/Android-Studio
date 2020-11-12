package com.example.async;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btn ;
    EditText t;
    TextView f;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.button);
        t = findViewById(R.id.time);
        f = findViewById(R.id.s);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time = t.getText().toString();
                async a = new async();
                a.execute(time);
            }
        });
    }
    public class async extends AsyncTask<String,String,String> {
        ProgressDialog dialog;
        String resp = null;
        @Override
        protected String doInBackground(String... strings) {

            publishProgress("Sleeping...");
            int t = Integer.parseInt(strings[0])*1000;
            try {
                Thread.sleep(t);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            resp = "Slept For "+strings[0] + " Seconds";
            return resp;
        }
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            dialog.dismiss();
            f.setText(s);
        }
        @Override
        protected void onPreExecute() {
            dialog = ProgressDialog.show(MainActivity.this,
                    "ProgressDialog",
                    "Wait for "+t.getText().toString()+ " seconds");
        }
        @Override
        protected void onProgressUpdate(String... text) {
            f.setText(text[0]);
        }
    }
}
