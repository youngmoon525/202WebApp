package com.example.and10_fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class MainFragment extends Fragment {
    Button btn_main_frag;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main, container, false);
        
        btn_main_frag = v.findViewById(R.id.btn_main_frag);
        btn_main_frag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //토스트창 띄우기.
                Toast.makeText(getContext(), "", Toast.LENGTH_SHORT).show();
            }
        });
        return v;
    }
}