package com.example.and02_relativelayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //context(맥락) : 현재 화면에 보여지는 객체의 상태정보를 의미함.
        Button btn = new Button(this);
        btn.setText("자바코드로 버튼넣음");
        TextView tv = new TextView(this);
        tv.setText(" K Y M K Y M K Y M K Y M K Y M K Y M K Y M K Y M K Y M K Y M K Y M K Y M ");
        // 위젯(TextViewx1,Button x 2 ) ==>
        ConstraintLayout layout = new ConstraintLayout(this);
        layout.addView(tv);
        layout.addView(btn);
        setContentView(layout); // ViewGroup <= View상속
        //setContentView(R.layout.activity_main);

        //Object obj = "";//1.기능
        //String str = "";//2.기능
        //str<= Object를 상속받은 자식 객체
        //1세대폰이 기능이좋냐 , 2세대폰이 기능이좋냐
        //obj는 모든 타입을 담을수있는 객체(최상위)
        //왜? 변수타입을 나눠서 사용을할까?????

    }
}