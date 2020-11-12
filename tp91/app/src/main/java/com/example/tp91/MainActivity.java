package com.example.tp91;

import android.content.DialogInterface;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Button> done;
    AssetManager assets;
    String [] images,asia,africa,europe,na,sa,oc,standar;
    int a,b,c,d,e,f,h,count,click;
    String m;
    ImageView img;
    int choix,score;
    LinearLayout g;
    Button next;
    TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t = findViewById(R.id.t);
        score = 0;
        count = 1;
        click = 0;
        t.setText(count+"/10");
        a=b=c=d=e=f=h=0;
        next = findViewById(R.id.next);
        standar = new String[222];
        asia = new String[200];
        africa = new String[200];
        europe = new String[200];
        na = new String[200];
        sa = new String[200];
        oc = new String[200];
        img = findViewById(R.id.imageView);
        done = new ArrayList<>();
        assets = this.getAssets();
        g = findViewById(R.id.lay);
        choix = 3;
        try {
            images = assets.list("png");
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(int i = 0 ; i < images.length ; i++){
                m = images[i].split("-")[0];
                if(m.equals("Asia")) {
                    asia[a]=(images[i]);
                    a++;
                }
                if(m.equals("Africa")) {
                    africa[b]=(images[i]);
                    b++;
                }
                if(m.equals("Europe")) {
                    europe[c]=(images[i]);
                    c++;
                }
                if(m.equals("North_America")) {
                    na[d]=(images[i]);
                    d++;
                }
                if(m.equals("South_America")) {
                    sa[e]=images[i];
                    e++;
                }
                if(m.equals("Oceania")) {
                    oc[f]=(images[i]);
                    f++;
                }
            }
         //remplir les pays dans arrays lists
        createbutton(3,images);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch(item.getItemId())
        {
            case R.id.asia:
                g.removeAllViews();
                standar = asia;
               createbutton(choix,asia);
                count=0;
                click = 0;
                t.setText(count+"/10");
                return true;
            case R.id.af:
                g.removeAllViews();
                standar = africa;
                createbutton(choix,africa);
                count=0;
                click = 0;
                t.setText(count+"/10");
                return true;
            case R.id.eu:
                g.removeAllViews();
                standar = europe;
                createbutton(choix,europe);
                count=0;
                click = 0;
                t.setText(count+"/10");
                return true;
            case R.id.na:
                g.removeAllViews();
                standar = na;
                createbutton(choix,na);
                count=0;
                click = 0;
                t.setText(count+"/10");
                return true;
            case R.id.sa:
                g.removeAllViews();
                standar = sa;
                createbutton(choix,sa);
                count=0;
                click = 0;
                t.setText(count+"/10");
                return true;
            case R.id.oc:
                g.removeAllViews();
                standar = oc;
                createbutton(choix,oc);
                count=0;
                click = 0;
                t.setText(count+"/10");
                return true;
            case R.id.nine:
                g.removeAllViews();
                choix = 9;
                createbutton(choix,images);
                count=0;
                click = 0;
                t.setText(count+"/10");
                return true;
            case R.id.six:
                g.removeAllViews();
                choix = 6;
                createbutton(choix,images);
                count=0;
                click = 0;
                t.setText(count+"/10");
                return true;
            case R.id.three:
                g.removeAllViews();
                choix = 3;
                createbutton(choix,images);
                count=0;
                click = 0;
                t.setText(count+"/10");
                return true;
            case R.id.all:
                g.removeAllViews();
                createbutton(choix,images);
                count=0;
                click = 0;
                t.setText(count+"/10");
                return true;
            default:
                standar = images;
                count=0;
                click = 0;
                t.setText(count+"/10");
                return super.onOptionsItemSelected(item);
        }
    }
    public void createbutton(int i , String [] s)
    {
        int r=0;
        int r1=0;
        int place = (int) (Math.random() * i);
        if(s == images){
            r = (int)(Math.random()*222);
        }
        if(s == asia){
            r = (int)(Math.random()*a);
        }
        if(s == africa){
            r = (int)(Math.random()*b);
        }
        if(s == europe){
            r = (int)(Math.random()*c);
        }
        if(s == na){
            r = (int)(Math.random()*d);
        }
        if(s == sa){
            r = (int)(Math.random()*e);
        }
        if(s == oc){
            r = (int)(Math.random()*f);
        }
        final String correct;
        String imagename;
        imagename = s[r];
        imagename = imagename.split("-")[1];
        correct = imagename.substring(0,imagename.length()-4);
        imagename = imagename.substring(0,imagename.length()-4);
        String nomUneImage = "png/" + s[r];
        try {
            Drawable image = Drawable.createFromStream(assets.open(nomUneImage), imagename);
            img.setImageDrawable(image);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int j = 0 ; j < i ; j++) {
            final Button btn = new Button(this);
        if(s==images) {
            do {
                r1 = (int) (Math.random() * 222);
            } while (r1 == place);
            if (j == place) {

                btn.setText(correct);
            } else {
                imagename = s[r1];
                imagename = imagename.split("-")[1];
                btn.setText(imagename.substring(0, imagename.length() - 4));
            }
        }
        if(s==asia){
            do {
                r1 = (int) (Math.random() * a);
            }while (r1 == place);
            if (j == place) {

                btn.setText(correct);
            }
            else {
                imagename = s[r1];
                imagename = imagename.split("-")[1];
                btn.setText(imagename.substring(0, imagename.length() - 4));
            }
        }
            if(s==africa){
                do {
                    r1 = (int) (Math.random() * b);
                }while (r1 == place);
                if (j == place) {

                    btn.setText(correct);
                }
                else {
                    imagename = s[r1];
                    imagename = imagename.split("-")[1];
                    btn.setText(imagename.substring(0, imagename.length() - 4));
                }
            }
            if(s==europe){
                do {
                    r1 = (int) (Math.random() * c);
                }while (r1 == place);
                if (j == place) {

                    btn.setText(correct);
                }
                else {
                    imagename = s[r1];
                    imagename = imagename.split("-")[1];
                    btn.setText(imagename.substring(0, imagename.length() - 4));
                }
            }
            if(s==na){
                do {
                    r1 = (int) (Math.random() * d);
                }while (r1 == place);
                if (j == place) {

                    btn.setText(correct);
                }
                else {
                    imagename = s[r1];
                    imagename = imagename.split("-")[1];
                    btn.setText(imagename.substring(0, imagename.length() - 4));
                }
            }
            if(s==sa){
                do {
                    r1 = (int) (Math.random() * e);
                }while (r1 == place);
                if (j == place) {

                    btn.setText(correct);
                }
                else {
                    imagename = s[r1];
                    imagename = imagename.split("-")[1];
                    btn.setText(imagename.substring(0, imagename.length() - 4));
                }
            }
            if(s==oc){
                do {
                    r1 = (int) (Math.random() * f);
                }while (r1 == place);
                if (j == place) {

                    btn.setText(correct);
                }
                else {
                    imagename = s[r1];
                    imagename = imagename.split("-")[1];
                    btn.setText(imagename.substring(0, imagename.length() - 4));
                }
            }
            btn.setWidth(150);
            btn.setId(j);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String z = btn.getText().toString();
                    if(v.getId() == btn.getId() && z.equals(correct)){
                        btn.setBackgroundColor(Color.GREEN);
                        score++;
                    }
                    else {
                        btn.setBackgroundColor(Color.RED);
                        for (Button button : done) {
                            if(button.getText()==correct)
                                button.setBackgroundColor(Color.GREEN);
                        }
                    }
                    for (Button button : done) {
                        button.setClickable(false);
                    }
                    click = 1;
                }
            });
            g.addView(btn);
            done.add(btn);
        }
    }
    public void next(View v){
        if(click == 1) {
            g.removeAllViews();
            if (standar[0] == null) {
                standar = images;
            }
            click = 0;
            for (Button button : done) {
                button.setClickable(true);
            }

            count++;
            if(count == 11){
                AlertDialog.Builder build = new AlertDialog.Builder(MainActivity.this);
                build.setTitle("Your Score is : \n"+score+" from 10");
                build.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        createbutton(3,images);
                        score = 0;
                        count = 1;
                        click = 0;
                        t.setText(count+"/10");
                        dialog.dismiss();
                    }
                });
                build.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {
                        createbutton(3,images);
                        score = 0;
                        count = 1;
                        click = 0;
                        t.setText(count+"/10");
                        dialog.dismiss();
                    }
                });
                build.create().show();
            }
            else {
                t.setText(count + "/10");
                createbutton(choix, standar);
            }
        }
    }
}
