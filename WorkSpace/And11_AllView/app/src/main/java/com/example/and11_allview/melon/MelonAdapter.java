package com.example.and11_allview.melon;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.and11_allview.R;

import java.util.ArrayList;

public class MelonAdapter extends RecyclerView.Adapter<MelonAdapter.ViewHolder> {
    LayoutInflater inflater ;
    ArrayList<MelonDTO> list;

    public MelonAdapter(LayoutInflater inflater, ArrayList<MelonDTO> list) {
        this.inflater = inflater;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.item_recv_melon,parent,false));
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder h, int i) {
        h.imgv_title.setImageResource(list.get(i).getImgRes());
        h.tv_title.setText(list.get(i).getTitle());
        h.tv_rank.setText(list.get(i).getRank()+"");
        h.tv_singer.setText(list.get(i).getSinger());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imgv_title ;
        TextView tv_title , tv_rank , tv_singer ;
        public ViewHolder(@NonNull View v) {
            super(v);

            imgv_title = v.findViewById(R.id.imgv_title);
            tv_title = v.findViewById(R.id.tv_title);
            tv_rank = v.findViewById(R.id.tv_rank);
            tv_singer = v.findViewById(R.id.tv_singer);
        }
    }
}
