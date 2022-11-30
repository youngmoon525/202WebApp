package com.example.and11_allview.listfrag;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.and11_allview.R;

import java.util.ArrayList;

public class ListFragment extends Fragment {
    ListView list_frag;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_list, container, false);
        ArrayList<ListFDTO> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(new ListFDTO("name"+i , "cnt"+i));
        }

        list_frag = v.findViewById(R.id.listv_frag);
        list_frag.setAdapter(new ListF_Adapter(inflater,list));


        return v;
    }
}