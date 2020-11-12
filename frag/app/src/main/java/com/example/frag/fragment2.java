package com.example.frag;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class fragment2 extends Fragment {
    TextView t1;
    int c;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_blank, container, false);
        t1 = v.findViewById(R.id.t1);
        return v;
    }
    public void onActivityCreated(Bundle savedState) {
        super.onActivityCreated(savedState);
    }

}
