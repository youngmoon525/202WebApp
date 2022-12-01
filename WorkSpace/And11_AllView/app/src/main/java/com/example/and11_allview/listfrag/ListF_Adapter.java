package com.example.and11_allview.listfrag;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.and11_allview.R;

import java.util.ArrayList;

public class ListF_Adapter extends BaseAdapter {
    LayoutInflater inflater; // Adapter <=> LayoutInflater
    ArrayList<ListFDTO> list;

    public ListF_Adapter(LayoutInflater inflater, ArrayList<ListFDTO> list) {
        this.inflater = inflater;
        this.list = list;
    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.item_listf_listv,parent,false);

        TextView tv_name =  convertView.findViewById(R.id.tv_name);
        TextView tv_cnt =  convertView.findViewById(R.id.tv_cnt);
        tv_name.setText(list.get(position).getName());
        tv_cnt.setText(list.get(position).getCnt());
        return convertView;
    }
}
