package com.example.tp8;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    AssetManager assets;
    private Toolbar mTopToolbar;
    TextView t;
    ImageView img;
    Drawable green,red;
    Drawable def;
    int a=0,b=0,c=0,d=0;
    String [] images={},images1={},cou={};
    Drawable image;
    String nomUneImage1,nomUneImage2,nomUneImage3,imageName="mohamad",im1,im2,im3,p="",count,choix;
    Button b1,b2,b3,b4;
    Resources r;
    int I,s,aa;
    ArrayList<String> list ;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        s=0;
        aa=0;
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);
        r = getResources();
        b4.setBackground(r.getDrawable(R.drawable.n));
        t = findViewById(R.id.t);
        b4.setClickable(false);
        def = b1.getBackground();
        assets = this.getAssets();
        img = findViewById(R.id.myimage);
        testingimage();
        I=1;

        t.setText(I+"/"+10);
        cou = new String[]{"All","Asia","Africa","Europe","North_America","South_America","Oceania"};



    }
    public void o(View v) throws IOException {
            b4.setClickable(false);
            b1.setBackground(def);
            b2.setBackground(def);
            b3.setBackground(def);
            b1.setClickable(true);
            b2.setClickable(true);
            b3.setClickable(true);
            testingimage();
            I++;
            t.setText(I+"/"+10);
            list.add(p);
            p="";
            if(I >10){
                Intent i = new Intent(MainActivity.this,Main2Activity.class);
                i.putStringArrayListExtra("list",list);
                i.putExtra("s",s);
            startActivity(i);
            }
    }
    public void p(View v) throws IOException {
        b1.setClickable(false);
        b2.setClickable(false);
        b3.setClickable(false);
        if(v.getId() == R.id.b1){
            if(d==0){
                b1.setBackground(green);
                s++;
                p+="Your Answer : "+b1.getText().toString()+"\n";
                p+="Correct Answer : "+b1.getText().toString();
            }
            else{
                b1.setBackground(red);
                if(d == 1) {
                    p+="Your Answer : "+b1.getText().toString()+"\n";
                    p+="Correct Answer : "+b2.getText().toString();
                    b2.setBackground(green);
                }
                else if(d == 2) {
                    b3.setBackground(green);
                    p+="Your Answer : "+b1.getText().toString()+"\n";
                    p+="Correct Answer : "+b3.getText().toString();
                }
            }
            b4.setClickable(true);
        }
        else if(v.getId() == R.id.b2){
            if(d==1){
                p+="Your Answer : "+b2.getText().toString()+"\n";
                p+="Correct Answer : "+b2.getText().toString();
                b2.setBackground(green);
                s++;
            }
            else{
                b2.setBackground(red);
                if(d == 0) {
                    b1.setBackground(green);
                    p+="Your Answer : "+b2.getText().toString()+"\n";
                    p+="Correct Answer : "+b1.getText().toString();
                }
                else if(d == 2) {
                    b3.setBackground(green);
                    p+="Your Answer : "+b2.getText().toString()+"\n";
                    p+="Correct Answer : "+b3.getText().toString();
                }
            }
            b4.setClickable(true);
        }
        else if(v.getId() == R.id.b3){
            if(d==2){
                s++;
                p+="Your Answer : "+b3.getText().toString()+"\n";
                p+="Correct Answer : "+b3.getText().toString();
                b3.setBackground(green);
            }
            else{
                b3.setBackground(red);
                if(d == 0) {
                    b1.setBackground(green);
                    p+="Your Answer : "+b3.getText().toString()+"\n";
                    p+="Correct Answer : "+b1.getText().toString();
                }
                else if(d == 1) {
                    b2.setBackground(green);
                    p+="Your Answer : "+b3.getText().toString()+"\n";
                    p+="Correct Answer : "+b2.getText().toString();
                }
            }
            b4.setClickable(true);
        }
    }
    public void testingimage(){
        try {
            do {
                a = (int) (Math.random() * 222);
                b = (int) (Math.random() * 222);
                c = (int) (Math.random() * 222);
            }while(a==b || b==c || a==c);
            d = (int)(Math.random()*3);
            images = assets.list("png");
            nomUneImage1 = "png/" + images[a];
            nomUneImage2 = "png/" + images[b];
            nomUneImage3 = "png/" + images[c];
            im1 = images[a].substring(0,images[a].length()-4);
            im2 = images[b].substring(0,images[b].length()-4);
            im3 = images[c].substring(0,images[c].length()-4);
            if(d == 0){
                image = Drawable.createFromStream(assets.open(nomUneImage1), imageName);
                b1.setText(im1);
                b2.setText(im2);
                b3.setText(im3);
            }
            if(d == 1){
                image = Drawable.createFromStream(assets.open(nomUneImage2), imageName);
                b1.setText(im1);
                b2.setText(im2);
                b3.setText(im3);
            }
            if(d == 2){
                image = Drawable.createFromStream(assets.open(nomUneImage3), imageName);
                b1.setText(im1);
                b2.setText(im2);
                b3.setText(im3);
            }
            img.setImageDrawable(image);
        } catch (IOException e) {
            e.printStackTrace();
        }
        green = r.getDrawable(R.drawable.green);
        red = r.getDrawable(R.drawable.red);
    }
    protected void onStart() {
        super.onStart();
        I=0;
        p="";
        t.setText(I+"/"+10);
        Toast.makeText(this,"New Game",Toast.LENGTH_SHORT).show();
    }
    public void image(ArrayList<String> array){
        try {
            do {
                a = (int) (Math.random() * 222);
                b = (int) (Math.random() * 222);
                c = (int) (Math.random() * 222);
            }while(a==b || b==c || a==c);
            d = (int)(Math.random()*3);
            images1 = (String[]) array.toArray();
            System.out.println(images1);
            nomUneImage1 = "png/" + images1[a];
            nomUneImage2 = "png/" + images1[b];
            nomUneImage3 = "png/" + images1[c];
            im1 = images1[a].substring(0,images1[a].length()-4);
            im2 = images1[b].substring(0,images1[b].length()-4);
            im3 = images1[c].substring(0,images1[c].length()-4);
            if(d == 0){
                image = Drawable.createFromStream(assets.open(nomUneImage1), imageName);
                b1.setText(im1);
                b2.setText(im2);
                b3.setText(im3);
            }
            if(d == 1){
                image = Drawable.createFromStream(assets.open(nomUneImage2), imageName);
                b1.setText(im1);
                b2.setText(im2);
                b3.setText(im3);
            }
            if(d == 2){
                image = Drawable.createFromStream(assets.open(nomUneImage3), imageName);
                b1.setText(im1);
                b2.setText(im2);
                b3.setText(im3);
            }
            img.setImageDrawable(image);
        } catch (IOException e) {
            e.printStackTrace();
        }
        green = r.getDrawable(R.drawable.green);
        red = r.getDrawable(R.drawable.red);
    }
}
