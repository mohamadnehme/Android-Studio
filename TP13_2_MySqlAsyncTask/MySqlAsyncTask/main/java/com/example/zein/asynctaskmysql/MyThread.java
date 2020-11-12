package com.example.zein.asynctaskmysql;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Ali on 3/10/2017.
 */

public class MyThread extends Thread implements Runnable {

    private String id;
    public MyThread(String id)
    {
        this.id = id;
    }
    @Override
    public void run() {
        try{
            URL url = new URL("http://192.168.88.27/android/getUser.php?id="+id);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            InputStream inputStream = connection.getInputStream();

            BufferedReader rd = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            String answer = "";
            while ((line = rd.readLine()) != null) {
                answer += line;
            }

            System.out.println("User name = " + answer);

        }catch(Exception e)
        {
            System.out.println(e.toString());
        }
    }
}
