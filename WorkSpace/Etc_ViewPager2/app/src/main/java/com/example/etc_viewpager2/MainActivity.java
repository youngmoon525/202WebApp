package com.example.etc_viewpager2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    RecyclerView recv;
    ViewPager2 pager2;
    
    // ※ 뷰페이저 2 : 리사이클러뷰랑 사용법 완전 같으나 자식 요소(layout.xml)에 만든 아이템
    //의 넓이 높이가 부모크기여야함 
    
    // 차이점 : 리사이클러뷰는 아이템이 옆으로 넘길때 옆의 요소가 보이고
    // 뷰페이저는 안보임
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CommonAdapter adapter = new CommonAdapter(getLayoutInflater() );
        RecyclerView.LayoutManager manager = new LinearLayoutManager(
                this,RecyclerView.HORIZONTAL,false
        );
        recv = findViewById(R.id.recv);
        pager2 = findViewById(R.id.pager2);

        recv.setAdapter(adapter);
        recv.setLayoutManager(manager);

        pager2.setAdapter(adapter);
        recv.setLayoutManager(manager);

    }
}