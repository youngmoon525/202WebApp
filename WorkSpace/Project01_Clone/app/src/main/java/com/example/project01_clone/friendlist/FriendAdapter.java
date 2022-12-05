package com.example.project01_clone.friendlist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project01_clone.R;

import java.util.ArrayList;
import java.util.HashMap;

// 리사이클러뷰에 대표적으로 많이 사용되고 외워야할어댑터 : RecyclerView.Adapter
public class FriendAdapter extends RecyclerView.Adapter<FriendAdapter.ViewHolder> {

    LayoutInflater inflater;
    ArrayList<FriendDTO> list;

    public FriendAdapter(LayoutInflater inflater, ArrayList<FriendDTO> list) {
        this.inflater = inflater;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_recv_friend ,parent,false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
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
        h.imgv_friend_profile.setImageResource(list.get(i).getImgRes());
        h.tv_friend_name.setText(list.get(i).getName());
        h.tv_friend_msg.setText(list.get(i).getMsg());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgv_friend_profile;
        TextView tv_friend_name , tv_friend_msg;
        public ViewHolder(@NonNull View v) {
            super(v);
            imgv_friend_profile = v.findViewById(R.id.imgv_friend_profile);
            tv_friend_name = v.findViewById(R.id.tv_friend_name);
            tv_friend_msg = v.findViewById(R.id.tv_friend_msg);
        }
    }
}
