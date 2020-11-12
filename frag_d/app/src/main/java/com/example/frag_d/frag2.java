package com.example.frag_d;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.fragment.app.Fragment;


public class frag2 extends Fragment {
    TextView output;
    EditText text;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle b) {
        View view = inflater.inflate(R.layout.fragment_frag2, container, false);
        output= view.findViewById(R.id.msg2);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle b) {
        super.onActivityCreated(b);
        text = getActivity().findViewById(R.id.text);
        try {
            output.setText(getArguments().getString("test"));
        }catch (Exception e){
            output.setText(text.getText());
        }
    }
}
