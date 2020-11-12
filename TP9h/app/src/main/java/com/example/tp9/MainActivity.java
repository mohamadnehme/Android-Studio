package com.example.tp9;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private String correct;
    private int score = 0;
    private int click = 0;
    private int attempt = 1;
    private ArrayList<Integer> th = new ArrayList<>();
    private ArrayList<Integer> random_Num = new ArrayList<>();
    private ArrayList<Integer> random_img = new ArrayList<>();
    private ArrayList<Button> done = new ArrayList<>();
    private ArrayList<Integer> continent = new ArrayList<>();
    private Button b;
    private int last;
    private ArrayList<Integer> ini = new ArrayList<>();
    private boolean[] fal=new boolean[4];
    private ArrayList<Integer> checked = new ArrayList<>();
    private TextView txt;
    TextView view ;
    private String[] reg={"Attention","Interdit","Obligation","Indication"};
    int j;
    String niveau;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view = findViewById(R.id.textView2);
        niveau = "Facile";
        j=2;
        for(int i=0;i<105;i++){
            ini.add(i);
        }
        createButton(2,ini);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.tp9, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(final MenuItem item) {
        final GridLayout g = (GridLayout) findViewById(R.id.grid);
        switch (item.getItemId()) {
            case R.id.choices:
                final String[] items = {"Facile", "Moyen", "Difficile"};
                final AlertDialog.Builder build = new AlertDialog.Builder(MainActivity.this);
                build.setTitle("Niveau");
                build.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        if (click == 1) {
                            Toast.makeText(MainActivity.this, "Veuillez passer a la question suivante.", Toast.LENGTH_LONG).show();
                        } else {
                            if (items[i].toString().equals(items[0])) {
                                g.removeAllViews();
                                j=2;
                                niveau = "Facile";
                                check_cont(j);
                                dialog.dismiss();
                            }
                            if (items[i].toString().equals(items[1])) {
                                g.removeAllViews();
                                j=4;
                                niveau = "Moyen";
                                check_cont(j);
                                dialog.dismiss();
                            }
                            if (items[i].toString().equals(items[2])) {
                                g.removeAllViews();
                                j=6;
                                niveau = "Difficile";
                                check_cont(j);
                                dialog.dismiss();
                            }
                        }
                    }
                });
                build.create().show();
                return true;

            case R.id.regions:
            default:
                final AlertDialog.Builder alert= new AlertDialog.Builder((MainActivity.this));
                alert.setMultiChoiceItems(reg, fal, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        System.out.println(isChecked);
                        if (isChecked){
                                checked.add(which);
                        }
                        else {
                                checked.remove(Integer.valueOf(which));
                        }
                    }
                });
                alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        continent.clear();
                        for(int i=0;i<checked.size();i++){
                            continent.addAll(Array(reg[checked.get(i)]));
                        }
                        if(click==0) {
                            if(checked.isEmpty()) {
                                g.removeAllViews();
                                createButton(last,ini);
                                dialog.dismiss();
                            }
                            else {
                                g.removeAllViews();
                                createButton(last, continent);
                                dialog.dismiss();
                            }
                        }
                        else {
                            Toast.makeText(MainActivity.this, "Veuillez passer a la question suivante.", Toast.LENGTH_LONG).show();
                        }
                    }
                });
                alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                alert.create().show();
                return super.onOptionsItemSelected(item);
        }
    }

    public void createButton(int i,ArrayList<Integer> num) {
        GridLayout g = (GridLayout) findViewById(R.id.grid);
        g.setRowCount(i);
        ImageView img = (ImageView) findViewById(R.id.imageView);
        try {
            AssetManager assets = this.getAssets(); //get reference on assets folder
            String[] images = assets.list("png");
            Random r = new Random();
            int x = num.get(r.nextInt(num.size()));
            //int x = (int) (Math.random() * num);
            while (th.contains(x)) {
                x = num.get(r.nextInt(num.size()));
                //x = (int) (Math.random() * num);
            }
            th.add(x);
            int place = (int) (Math.random() * (i));
            String nomUneImage = "png/" + images[x]; //contient le chemin du premier fichier
            String imageName = images[x];
            String[] nom = imageName.split("-");
            int p1 = nom[1].lastIndexOf(".");
            String imgnom = nom[1].substring(0, p1);
            correct = imgnom;
            Drawable image = Drawable.createFromStream(assets.open(nomUneImage), imageName);
            img.setImageDrawable(image);
            random_Num.add(place);
            random_img.add(x);
            while (random_Num.size() != i) {
                int c = (int) (Math.random() * i);
                if (!random_Num.contains(c)) {
                    random_Num.add(c);
                }
            }
            while (random_img.size() != i) {
                int c =num.get(r.nextInt(num.size()));
                if (!random_img.contains(c)) {
                    random_img.add(c);
                }
            }
            for (int j = 0; j < i; j++) {
                final Button b = new Button(this);
                if (j == place) {
                    b.setText(imgnom);
                }
                b.setWidth(1100);
                b.setId(j);
                b.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String z = b.getText().toString();
                        if (v.getId() == b.getId() && z.equals(correct)) {
                            b.setBackgroundColor(Color.GREEN);
                            score++;
                        } else {
                            b.setBackgroundColor(Color.RED);
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
                g.addView(b);
                done.add(b);
            }
            for (int p = 1; p < i; p++) {
                int q = random_img.get(p);
                int w = random_Num.get(p);
                String imageName2 = images[q];
                String[] nom2 = imageName2.split("-");
                int p2 = nom2[1].lastIndexOf(".");
                String imgnom2 = nom2[1].substring(0, p2);
                b = (Button) findViewById(w);
                b.setText(imgnom2);
            }
            last=i;
            random_Num.clear();
            random_img.clear();
            txt=findViewById(R.id.textView2);
            StringBuilder str=new StringBuilder();
            String choix_reg;
            if(!checked.isEmpty()) {
                for (int v = 0; v < checked.size(); v++) {
                    str.append(reg[checked.get(v)] + ", ");
                }
                choix_reg = str.substring(0,str.length()-2);
                txt.setText("Niveau :\n--------------------\n"+niveau+"\n\nType :\n--------------\n"+choix_reg);
            }
            else txt.setText("Niveau :\n--------------------\n"+niveau+"\n\nType :\n--------------\nALL");
        } catch (Exception e) { }
    }

    public void next(View v) {
            if (click == 1) {
                if (attempt < 10) {
                    GridLayout g = (GridLayout) findViewById(R.id.grid);
                    g.removeAllViews();
                    last=3;
                    click = 0;
                    TextView txt = (TextView) findViewById(R.id.textView);
                    String x = txt.getText().toString();
                    String[] a = x.split(" ");
                    int y = Integer.parseInt(a[1]);
                    attempt++;
                    y++;
                    txt.setText("Question " + y + " de 10");
                    check_cont(j);
                }else {
                int pr = score * 10;
                int wrong = 10 - score;
                final Intent x = new Intent(this, MainActivity.class);
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage(Integer.toString(wrong) + " Mauvais Clic ," + pr + "%correctes")
                        .setPositiveButton("Reinitialiser le Quiz", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                startActivity(x);
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
            }
        } else {
            Toast.makeText(MainActivity.this, "Veuillez choisir une reponse avant de passer a la question suivante.", Toast.LENGTH_LONG).show();
        }
    }

    private void check_cont(int i){
        if(continent.isEmpty()) {
            createButton(i,ini);
        }
        else {
            createButton(i,continent);
        }
    }

    public ArrayList<Integer> Array(String s) {
        ArrayList<Integer> ar=new ArrayList<>();
        try {
            AssetManager assets = this.getAssets(); //get reference on assets folder
            String[] images = assets.list("png");
            for (int i = 0; i < images.length; i++) {
                String x = images[i];
                String[] y = x.split("-");
                String z = y[0];
                try {
                    String[] c = z.split("_");
                    if (c[1].equals(s)) {
                        if (continent.contains(i)) {
                            continent.remove(Integer.valueOf(i));
                        } else {
                            ar.add(i);
                        }
                    }
                } catch (Exception e) {
                    if (y[0].equals(s)) {
                        if (continent.contains(i)) {
                            continent.remove(Integer.valueOf(i));
                        } else {
                            ar.add(i);
                        }
                    }
                }
            }
        }
        catch (Exception e){

        }
        return ar;
    }
    public void test(View v){
        Intent i = new Intent(MainActivity.this, Main2Activity.class);
        startActivity(i);
    }
}