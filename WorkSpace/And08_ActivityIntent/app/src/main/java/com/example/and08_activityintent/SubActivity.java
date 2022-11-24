package com.example.and08_activityintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        Intent intent = getIntent();// MainActivity에서 SubActivity를 띄울때 통신용으로 사용한 Intent
        String sVal = intent.getStringExtra("sVal");
        int iVal = intent.getIntExtra("iVal" , -1);//int타입은 null을 사용못함 , 기본으로 담을값
        MemberDTO dto = (MemberDTO) intent.getSerializableExtra("dto");
        ArrayList<MemberDTO> list = (ArrayList<MemberDTO>) intent.getSerializableExtra("list");

        Log.d("로그", " 값 : " + sVal);
        Log.d("로그", " 값 : " + iVal);
        Log.d("로그", " 값 : " + dto.getsVal1());
        Log.d("로그", " 리스트 사이즈 " +  list.size());


    }
}