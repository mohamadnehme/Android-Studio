package com.example.tp9;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Process;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

public class Main2Activity extends AppCompatActivity {

    AssetManager assets;
    String [] images,Attention,Interdit,Obligation,Indication,standar;
    int a,b,c,d;
    String m;
    ImageView img;
    TextView t,t1;
    Button next,prev;
    int i;
    Button btnexit;
    Button bb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
         bb=(Button)findViewById(R.id.bb);
        btnexit =(Button)findViewById(R.id.btnexit);
        //btnexit.setOnClickListener((View.OnClickListener) btnexit);

        next = findViewById(R.id.next);
        prev = findViewById(R.id.prev);
        a=b=c=d=i=0;
        Attention = new String[50];
        Interdit = new String[50];
        Obligation = new String[50];
        Indication = new String[50];
        standar = new String[105];
        img = findViewById(R.id.imageView);
        t = findViewById(R.id.t1);
        t1 = findViewById(R.id.t2);
        assets = this.getAssets();
        try {
            images = assets.list("png");      //sa7abna kl aseme l suwar w hataynehon bl tableau image
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(int j = 0 ; j < images.length ; j++) {   //image.length=nombre d image
            m = images[j].split("-")[0];  //a5adna mn awal 7aref la7ad l "-" ****
            if (m.equals("Attention")) {
                Attention[a] = (images[j]);    //si attention on la met dans le tableau des attention
                a++;
            }
            if (m.equals("Indication")) {
                Indication[b] = (images[j]);
                b++;
            }
            if (m.equals("Interdit")) {
                Interdit[c] = (images[j]);
                c++;
            }
            if (m.equals("Obligation")) {
                Obligation[d] = (images[j]);
                d++;
            }
        }

        i=0;
        standar = images;
        ShowImage(i,standar);    //afficher la premiere image ds tb standar[0]


        bb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Main2Activity.this,MoreInformations.class);
                startActivity(intent);

            }
        });



        getSupportActionBar().setTitle("Cours De Signalisation");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.tp9_1, menu);
        return super.onCreateOptionsMenu(menu);
    }
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch(item.getItemId())
        {
            case R.id.att:
                i=0;
                standar = Attention;
                ShowImage(i,standar);
                return true;
            case R.id.inte:
                i=0;
                standar = Interdit;
                ShowImage(i,standar);
                return true;
            case R.id.ob:
                i=0;
                standar = Obligation;
                ShowImage(i,standar);
                return true;
            case R.id.ind:
                i=0;
                standar = Indication;
                ShowImage(i,standar);
                return true;
            case R.id.all:
                i=0;
                standar = images;
                ShowImage(i,standar);
                return true;
            default:
                i=0;
                standar = images;
                ShowImage(i,standar);
                return super.onOptionsItemSelected(item);
        }
    }
    public void ShowImage(int i , String [] s)
    {
        next.setClickable(true);
        prev.setEnabled(true);
        String imagename;
        if(s == Attention){
            if(i == a-1)
                next.setEnabled(false);
            else
                next.setEnabled(true);
            if(i == 0)
                prev.setEnabled(false);
            else
                prev.setEnabled(true);
            t.setText(i+1+" Of "+(a));
        }
        if(s == Indication){
            if(i == b-1)
                next.setEnabled(false);
            else
                next.setEnabled(true);
            if(i == 0)
                prev.setEnabled(false);
            else
                prev.setEnabled(true);
            t.setText(i+1+" Of "+(b));
        }
        if(s == Interdit){
            if(i == c-1)
                next.setEnabled(false);
            else
                next.setEnabled(true);
            if(i == 0)
                prev.setEnabled(false);
            else
                prev.setEnabled(true);
            t.setText(i+1+" Of "+(c));
        }
        if(s == Obligation){
            if(i == d-1)
                next.setEnabled(false);
            else
                next.setEnabled(true);
            if(i == 0)
                prev.setEnabled(false);
            else
                prev.setEnabled(true);
            t.setText(i+1+" Of "+(d));
        }
        if(s == images){
            if(i == images.length-1)
                next.setEnabled(false);
            else
                next.setEnabled(true);
            if(i == 0)
                prev.setEnabled(false);
            else
                prev.setEnabled(true);
            t.setText(i+1+" Of "+(images.length));
        }
        imagename = s[i];
        imagename = imagename.substring(0,imagename.length()-4);
        String nomUneImage = "png/" + s[i];
        t1.setText(imagename);
        try {
            Drawable image = Drawable.createFromStream(assets.open(nomUneImage), imagename);
            img.setImageDrawable(image);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void next(View v) {
        i++;
        ShowImage(i ,standar);
    }
    public void prev(View v) {
        i--;
        ShowImage(i ,standar);
    }


    public void close(View v){
        // moveTaskToBack(true);
        // android.os.Process.killProcess(android.os.Process.myPid());
       // System.exit(1);
        finish();
        System.exit(0);
    }

}
