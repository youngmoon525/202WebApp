package com.example.and10_fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

public class SubFragment extends Fragment {
        Button btn_imgv;
        ImageView imgv1 , imgv2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_sub, container, false);
        btn_imgv = v.findViewById(R.id.btn_imgv);
        imgv1 = v.findViewById(R.id.imgv1);
        imgv2 = v.findViewById(R.id.imgv2);

        btn_imgv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // loop ( 일정 범위 내에서 int값이 증가하는것 0 => 1 = > 0 = > 1 )
                // 이미지뷰 자체를 이용해서 보이는 상태에 따라 분기 ( 이미지뷰가 2개일때 편함)
                if(imgv1.getVisibility() == View.VISIBLE){
                    imgv1.setVisibility(View.GONE);
                    imgv2.setVisibility(View.VISIBLE);
                }else if(imgv2.getVisibility() == View.VISIBLE){
                    imgv2.setVisibility(View.GONE);
                    imgv1.setVisibility(View.VISIBLE);
                }
            }
        });

        return v;
    }
}