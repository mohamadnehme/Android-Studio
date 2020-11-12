package com.example.tp9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class Login extends AppCompatActivity {
    Button b1;
    EditText t1,t2;
    Button b2;
    String s1,s2;
    Sqlite db;
    int k;
    ArrayList<User> users;
    int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        b1=findViewById(R.id.b1);
        t1=findViewById(R.id.user);
        t2=findViewById(R.id.pass);
        users = new ArrayList<>();
        b2=findViewById(R.id.b2);
        db= new Sqlite(this);
        k=0;
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                users = db.GetAllUser();

                s1=t1.getText().toString();
                s2=t2.getText().toString();

                for(i = 0 ; i < users.size() ; i++){
                    if(s1.equals(users.get(i).email) && s2.equals(users.get(i).password)){
                        Intent i1=new Intent(Login.this,MainActivity.class);
                        i1.putExtra("email",s1);
                        i1.putExtra("pass",s2);
                        i1.putExtra("id",users.get(i).id);
                        k=1;
                        startActivity(i1);
                    }
                }
                if(i == users.size() && k== 0){
                    Toast.makeText(Login.this,"Please Create An Account",Toast.LENGTH_SHORT).show();
                }


            }
        });


b2.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent i=new Intent(Login.this,Register.class);

        startActivity(i);

    }
});

        getSupportActionBar().setTitle("Login Page");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }
}
