package com.example.project01_clone.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project01_clone.R;

import java.util.ArrayList;

public class ViewAdapter extends RecyclerView.Adapter<ViewAdapter.ViewHoler> {
    LayoutInflater inflater;
    ArrayList<ViewDTO> list ;

    public ViewAdapter(LayoutInflater inflater, ArrayList<ViewDTO> list) {
        this.inflater = inflater;
        this.list = list;
    }

    public ViewAdapter(LayoutInflater inflater) {
        this.inflater = inflater;
    }

    @NonNull
    @Override
    public ViewHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHoler(inflater.inflate(R.layout.item_recv_view,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoler h, int i) {
        h.imgv_logo.setImageResource(list.get(i).getImg_logo_title());
        h.imgv_content.setImageResource(list.get(i).getImg_content());
        h.tv_content_title.setText(list.get(i).getContent_title());
        h.tv_content_sub.setText(list.get(i).getContent_sub());
        h.tv_content_sub2.setText(list.get(i).getContent_sub2());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHoler extends RecyclerView.ViewHolder{
        ImageView imgv_logo  , imgv_content;
        TextView tv_content_title , tv_content_sub , tv_content_sub2;
        public ViewHoler(@NonNull View v) {
            super(v);
            imgv_logo = v.findViewById(R.id.imgv_logo);
            imgv_content = v.findViewById(R.id.imgv_content);
            tv_content_title = v.findViewById(R.id.tv_content_title);
            tv_content_sub = v.findViewById(R.id.tv_content_sub);
            tv_content_sub2 = v.findViewById(R.id.tv_content_sub2);
        }
    }
}
