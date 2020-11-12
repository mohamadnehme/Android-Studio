package com.example.tp9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MoreInformations extends AppCompatActivity {
    Spinner spin;
    TextView v;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_informations);
        v=(TextView) findViewById(R.id.v);
        final  String[] s={"Le fait de se déplacer ou pas","Le choix de la destination","Le choix du mode","Le choix du chemin"};

        spin=(Spinner)findViewById(R.id.spin);
        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,android.R.layout.simple_dropdown_item_1line,s);
        spin.setAdapter(adapter);
spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String m = "";
        if (s[position] == s[0]) {
            m = "Le fait de se déplacer ou pas (étape dite de génération)." +
                    " Ainsi, seule une partie des actifs va effectivement réaliser un déplacement domicile-travail " +
                    "à l'heure du point de matin (les autres étant en congé, ou travaillant en horaire décalé…)." +
                    " Cette étape aboutit au nombre de déplacements ayant lieu en Île-de-France sur la période considérée.\n" +
                    "\n";

            v.setText(m + "");

        }

        else        if(s[position]==s[1])
        {
            m="Le choix de la destination (étape dite de distribution)." +
                    " Dans le cas du déplacement domicile-travail, ce choix est conditionné par la géographie" +
                    " des emplois et leur accessibilité au sens large (l'agent arbitre entre les opportunités selon" +
                    " le temps de parcours, le coût…) : par exemple, vaut-il mieux aller travailler sur le pôle" +
                    " d'emplois A ou le pôle d'emplois B, sachant que A offre plus d'opportunités mais est moins " +
                    "accessible que B? Cette étape aboutit à la répartition par origine-destination (couple dit OD)" +
                    " du volume de déplacements issu de l'étape précédente de génération : à chaque OD est désormais" +
                    " attaché un nombre de déplacements.\n" +
                    "\n";


            v.setText(m+"");



        }


        else        if(s[position]==s[2])
        {
            m="Le choix du mode (étape dite de choix modal)." +
                    " L'agent arbitre entre les différents modes lui permettant de rejoindre" +
                    " son lieu de destination, et compare pour cela l'efficacité des alternatives" +
                    " qui s'offrent à lui (temps, coût…) : pour aller au pôle d'emplois A," +
                    " vaut-il mieux emprunter les transports en commun ou prendre sa voiture?" +
                    " La réponse dépendra évidemment du lieu de domicile de l'agent. Cette étape" +
                    " aboutit au nombre de déplacements par mode pour chaque OD.\n" +
                    "\n";
            v.setText(m+"");
        }





        else {
            m = "Le choix du chemin (étape dite d' affectation)." +
                    " L'agent arbitre entre les différents parcours possibles pour rejoindre" +
                    " sa destination dans le mode choisi précédemment, en en comparant à nouveau " +
                    "l'efficacité : pour aller au pôle d'emplois A en transports collectifs, " +
                    "quelle(s) ligne(s) de bus, tram, métro, train… choisir ? Cette étape aboutit" +
                    " à l'obtention de réseaux de transport \"chargés\" : le nombre d'usagers de chaque" +
                    " tronçon routier et service TC est désormais connu.";
            v.setText(m+"");

        }



    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
});


getSupportActionBar().setTitle("Plus d'Informations");
getSupportActionBar().setDisplayHomeAsUpEnabled(true);



    }
}
