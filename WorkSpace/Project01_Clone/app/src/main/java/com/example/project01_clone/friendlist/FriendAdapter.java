package com.example.project01_clone.friendlist;

import android.content.Context;
import android.content.Intent;
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
    Context context;

    public FriendAdapter(LayoutInflater inflater, ArrayList<FriendDTO> list, Context context) {
        this.inflater = inflater;
        this.list = list;
        this.context = context;
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
        // 아이템을 클릭 했을때 액티비티가 나올수있게 코딩해보기..
        // 액티비티를 띄울때 꼭 필요한것 ( 현재 화면의 정보 ??? )==> 용어 : ( Context )
        // Context는 일반 클래스에서 바로 접근 x <= 화면에 나오는 클래스로부터 받아옴
        // 꼭필요한것 2 : 통신을 통해 액티비티를 띄우게 하는 객체 ==> 용어 :( Intent  )
        final int idx = i;
        h.imgv_friend_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context , DetailActivity.class);
                intent.putExtra("dto" , list.get(idx) );// 오류 발생 원인 : ?
                context.startActivity(intent);
            }
        });

        // Intent intent = new Intent ( MainActivity.this , DetailActivity.class )


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
