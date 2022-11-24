package com.example.and08_activityintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    LinearLayout ln_layout , ln_layout2;
    Button btn_new;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // xml파일과 java파일이 연결이 되었는지?
                                                 //view타입이 null이면 연결 x
                                                 // R.layout.activity_main에 있는 view타입인지..
                                // 레이아웃 인플레이션 : xml에 있는 내용이 메모리에 올라가는 부분

        btn_new = findViewById(R.id.btn_new);
        btn_new.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //MainActivity => Intent => SubActivity
                // 현재 액티비티에서 인텐트라는 객체를 통해 다음 액티비티를 띄우기.
                //                                         현재 액티비티,다음액티비티 클래스
                // MemberDTO를 하나 생성해서 Intent를 통해 전송해보기
                //String sVal1, String sVal2, String sVal3

                // MemberDTO 10개를 묶어놓은 ArrayList를 하나 만들어보기
                ArrayList<MemberDTO> list = new ArrayList<>();
                for (int i = 0; i < 10; i++) {
                    list.add(new MemberDTO("sv1" , "sv2" , "sv3"));
                    //MemberDto dto add (=)
                }


                MemberDTO dto = new MemberDTO("sv1" , "sv2" , "sv3");
                Intent intent = new Intent(MainActivity.this , SubActivity.class);
                intent.putExtra("sVal" , "KYM");
                intent.putExtra("dto", dto);
                intent.putExtra("list", list);
                // SubActivity로 int값 100을 보내고 SubActivity에서 받아보기

                startActivity(intent);//startActivity <= AppCompatActivity를 상속받은 액티비티만 사용가능.
            }
        });


        ln_layout = findViewById(R.id.ln_layout);
        ln_layout2 = findViewById(R.id.ln_layout2);

        LayoutInflater inflater = getLayoutInflater();//Os에서 레이아웃을 붙이는 기능을 가진 객체를 줌.
        View v1 = inflater.inflate(R.layout.layout_sub1 , ln_layout , true);//레이아웃을 붙이는 처리를하면
        //xml에 있는 내용이 메모리에 올라감. 그리고나서 메모리에 올라간 모든 내용을 다시 return
        View v2 =inflater.inflate(R.layout.layout_sub2 , ln_layout2 , true);//추후 false


        //레이아웃을 붙이는 처리를 하면(==레이아웃 인플레이션) 붙은 레이아웃이 메모리에 올라가면서
        //레이아웃의 모든 내용을 View타입으로 return을 해줌.
        //return 해준View타입을 활용해서 위젯을 찾거나 하는 작업을 한다.

        Button btn_sub2 = v2.findViewById(R.id.btn_sub2);
        btn_sub2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tv_sub2 = v2.findViewById(R.id.tv_sub2);
                tv_sub2.setText("글씨 바꿈~");
                // 버튼을 클릭 했을때 토스트 메세지가 나오게 처리해보기.
                Toast.makeText(MainActivity.this, "무슨의미?", Toast.LENGTH_SHORT).show();

                NoneContext nc = new NoneContext(getLayoutInflater());
                nc.method1();
                nc.showToast(MainActivity.this);
                nc.v1Setting(v1);
            }
        });
        //※ context ※
        //Context : 현재 화면에 떠있는 객체에게 어떤 기능들을 사용할수있는 권한을 줌.
        //Context <= 1.Activity를 넘겨주면된다.
        Toast.makeText(this, "메세지", Toast.LENGTH_SHORT).show();

        // v2에 있는 위젯을 활용하여 문제를 해결해보기
        //v2에 있는 버튼을 클릭하면 v2의 텍스트가 바뀌게 처리.!



    }
}