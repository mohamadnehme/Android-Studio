package com.example.test2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Resources r = getResources();
        //Toast.makeText(this,r.getString(R.string.data),Toast.LENGTH_SHORT).show();
        String [] array = r.getStringArray(R.array.array);
        //for(int i=0;i<array.length;i++)
          //  Toast.makeText(this,array[i],Toast.LENGTH_SHORT).show();
        Button b = (Button)findViewById(R.id.b);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConstraintLayout a = (ConstraintLayout)findViewById(R.id.a);
                ColorDrawable c = (ColorDrawable)r.getDrawable(R.drawable.blue);
                a.setBackgroundDrawable(c);
                //a.setBackgroundResource(R.drawable.ali);
            }
        });
    }
}
