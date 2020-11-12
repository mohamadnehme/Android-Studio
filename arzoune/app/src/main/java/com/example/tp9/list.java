package com.example.tp9;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class list extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ScrollView la = new ScrollView(this);
        LinearLayout l = new LinearLayout(this);
        l.setOrientation(LinearLayout.VERTICAL);
        l.setBackgroundColor(Color.YELLOW);
        la.setBackgroundColor(Color.YELLOW);
        TextView t = new TextView(this);
        t.setTextSize(20);
        t.setTextColor(Color.RED);
        t.setText("All Users");
        l.addView(t);
        TableLayout table = new TableLayout(this);
// Java. You succeed!
        Sqlite db = new Sqlite(this);

        ArrayList<User> users = db.GetAllUser();

        FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.FILL_PARENT,
                ViewGroup.LayoutParams.FILL_PARENT);
        table.setLayoutParams(lp);
        table.setStretchAllColumns(true);

        TableLayout.LayoutParams rowLp = new TableLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        TableRow.LayoutParams cellLp = new TableRow.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);

        TableRow row1 = new TableRow(this);

            Button btn1 = new Button(this);
            btn1.setText("ID");
            row1.addView(btn1, cellLp);

            Button btn2 = new Button(this);
            btn2.setText("Name");
            row1.addView(btn2, cellLp);

            Button btn3 = new Button(this);
            btn3.setText("Score");
            row1.addView(btn3, cellLp);

            table.addView(row1, rowLp);

        for (int r = 0; r < users.size(); r++)
        {
            TableRow row = new TableRow(this);

                Button btn = new Button(this);
                btn.setText(users.get(r).getId()+"");
                row.addView(btn, cellLp);

                Button btn4 = new Button(this);
                btn4.setText(users.get(r).getName()+"");
                row.addView(btn4, cellLp);

                Button btn5 = new Button(this);
                btn5.setText(users.get(r).getScore()+"");
                row.addView(btn5, cellLp);

            table.addView(row, rowLp);
        }
        l.addView(table);
        la.addView(l);
        setContentView(la);
    }
}
