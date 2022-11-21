package com.example.and05_scrollview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv; // 변수의 선언 (클래스의 선언)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.tv); // TextView 초기화 (디자인<=>java)
        tv.setText("글씨SET TEXT");//기존 글자를 없애고 새로운 글자를 넣음.
        tv.append("글씨 append"); //기존글자+=새로운글자
        // ↑두개중에 하나의 메소드를 이용 ( 줄바꿈 )
        // 화면 영역보다 글자가 더 많게끔 반복처리 해보기.
        //append
        for(int i = 0 ;  i < 50 ; i ++){
           tv.append("\n글씨 append글씨 append글씨 append글씨 append글씨 append글씨 append글씨 append글씨 append글씨 append글씨 append글씨 append글씨 append글씨 append글씨 append글씨 append글씨 append글씨 append글씨 append글씨 append글씨 append글씨 append" + i);
        }

    }
}