package com.example.gallery;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileInputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String [] tab = new String[1000];
        int k = 0;
        ImageView img = findViewById(R.id.img);
        File picsdir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
        File dirp = new File(picsdir+ File.separator + "Camera");
        if (dirp.exists()) {
            try {
                File[] fs = dirp.listFiles();
                for (File file : fs) {
                    tab[k] = file.getName() + "\n";
                    k++;
                }
                File directory = new File (picsdir.getAbsolutePath() + "/Camera");
                File file = new File(directory, tab[0]); //or any other format supported

                FileInputStream streamIn = new FileInputStream(file);

                Bitmap bitmap = BitmapFactory.decodeStream(streamIn); //This gets the image

                streamIn.close();
                img.setImageBitmap(bitmap);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        }
    }