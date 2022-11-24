package com.example.and08_activityintent;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class NoneContext {

    LayoutInflater inflater;

    public NoneContext(LayoutInflater inflater) {
        this.inflater = inflater;
    }

    //method1이 호출되기 전 inflater가 null이 아니게 만들어보기.
    //method1호출은 MainActivity 버튼2에서 한다.
    public void method1(){
        if(inflater==null){
            Log.d("인플레이터", " null : ");
        }else{
            Log.d("인플레이터", " null 아님: ");
        }
    }

    public void showToast(MainActivity activity){
        // NoneContext.class에서 토스트 메세지를 띄워보기.
        Toast.makeText(activity, "무슨의미?", Toast.LENGTH_SHORT).show();
    }

    //
    public void v1Setting(View v1){
        TextView tv_sub1 = v1.findViewById(R.id.tv_sub1);//붙이는처리 attachToroot를 나중에 함.
        tv_sub1.setText("글씨글씨");
        Button btn_sub1 = v1.findViewById(R.id.btn_sub1);
        btn_sub1.setText("버튼글씨!");
    }






}
