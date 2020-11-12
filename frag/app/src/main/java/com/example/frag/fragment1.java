package com.example.frag;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class fragment1 extends Fragment {
    ListView l ;
    DataBase db;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView=inflater.inflate(R.layout.fragment_fragment1, container, false);
        l = rootView.findViewById(R.id.list);
        return rootView;
    }

    public void onActivityCreated(Bundle savedState) {
        super.onActivityCreated(savedState);
        db = new DataBase(getActivity());
        final TextView t = getActivity().findViewById(R.id.t1);

        ArrayList<Contacts> a = new ArrayList<>();

        a = db.getc();

        ArrayList<String> arrayList = new ArrayList<>();
        for(int i = 0 ; i < a.size() ; i++){
            arrayList.add(Integer.toString(a.get(i).id));
        }
        ArrayAdapter<String> ad = new ArrayAdapter<>(getActivity(),android.R.layout.simple_list_item_1,arrayList);
        l.setAdapter(ad);
        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String s = l.getItemAtPosition(position).toString();
                Contacts c = db.getone(s);
                t.setText(" Id : "+c.getId()+"\n Name : "+c.getName() +"\n Phone_Number :  "+c.getPh());
            }
        });
    }
}