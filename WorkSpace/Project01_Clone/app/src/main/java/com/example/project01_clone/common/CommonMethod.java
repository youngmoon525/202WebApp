package com.example.project01_clone.common;

import android.content.Context;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CommonMethod {

    // 매번 화면에서 Layout매니저를 직접 만드는 행위가 불편.
    // 재사용이 가능한 메소드 하나를 이용해서 코드를 줄여 보고자 한다

    // 레이아웃매니저를 리턴하는 메소드를 CommonMethod에 정의 해보고
    // ChatExamFragment에서 호출해서 사용해보기.

    //    RecyclerView.LayoutManager manager = new LinearLayoutManager(
    //                getContext() , RecyclerView.VERTICAL , false
    //        );

    // recv_exam_chat.setLayoutManager(  CommonMethod.getManager() ) ;

    //파라메터 개수 등등은 자유롭게 구현.
    public static LinearLayoutManager getManager(Context context){//Context를 화면에 보이는 객체로부터 받아온다.
        LinearLayoutManager manager = new LinearLayoutManager(
                context , RecyclerView.VERTICAL , false );
        return manager;
    }

    public static LinearLayoutManager getManager(Context context , int orientaion){//Context를 화면에 보이는 객체로부터 받아온다.
        LinearLayoutManager manager = new LinearLayoutManager(

                context , orientaion , false );
        return manager;
    }


}
