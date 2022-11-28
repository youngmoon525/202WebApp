package com.example.and10_fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    // LayoutInflater : 어떤 레이아웃을 따로 불러와서 사용.
    // ※ 붙을 공간 => ViewGroup(Layout) ※
    // ※ 붙일 내용 => .xml(Layout) ※
    // Fragment => ※ 반드시 LayoutInflater가 있는 상태로 붙음 ※
    // 반드시 액티비티 안에 있는 형태
    // 만드는 방법 : 패키지 마우스 오른쪽 클릭 후 Fragment 찾기
    // Blank Fragment 생성
    Button btn_frag1 , btn_frag2 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_frag1 = findViewById(R.id.btn_frag1);
        btn_frag2 = findViewById(R.id.btn_frag2);

        btn_frag1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // rollback , commit;
                getSupportFragmentManager().beginTransaction().replace(R.id.container,new MainFragment()).commit();
            }
        });

        btn_frag2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container,new SubFragment()).commit();

            }
        });

    }
}