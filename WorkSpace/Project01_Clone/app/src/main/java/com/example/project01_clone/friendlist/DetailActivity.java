package com.example.project01_clone.friendlist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.project01_clone.R;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener{
    ImageView imgv_detail_profile ;
    TextView tv_name , tv_msg ;
    LinearLayout ln_menu1 , ln_menu2 , ln_menu3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getSupportActionBar().hide();//액션바를 가져와서 안보이게 처리

        ln_menu1 = findViewById(R.id.ln_menu1);
        ln_menu2 = findViewById(R.id.ln_menu2);
        ln_menu3 = findViewById(R.id.ln_menu3);

        ln_menu1.setOnClickListener(this);
        ln_menu2.setOnClickListener(this);
        ln_menu3.setOnClickListener(this);

        Intent intent = getIntent();

        FriendDTO dto = (FriendDTO) intent.getSerializableExtra("dto");

        imgv_detail_profile = findViewById(R.id.imgv_detail_profile);
        tv_name = findViewById(R.id.tv_name);
        tv_msg = findViewById(R.id.tv_msg);

        imgv_detail_profile.setImageResource(dto.getImgRes());
        tv_msg.setText(dto.getMsg());
        tv_name.setText(dto.getName());


    }

    @Override
    public void onClick(View v) {
        // Intent <= 컴포넌트들간의 통신을 맡고 있는 객체 ( 액티비티 )
        // 1. 명시적 인텐트 ( 우리가 만든 클래스 내부에서 사용하고 그 통제가 전부 가능한 상태 )
        // ex( Intent intent = new Intent ( 현재 위치(Context) , 다음 띄울 액티비티.class )
        // startActivity로 끝남

        // 2. 묵시적(암시적) 인텐트 ( 우리가 만든게 x , OS나 다른 기타 외부에서 제공하는 기능과 통신(호출)
        // 할때 사용하는 인텐트
        // 우리가 만든게 아니기 때문에 어떤 결과가 나올지 모름.
        // ex ( 인터넷 연결 , 전화 연결 , 카메라 , 갤러리 , 맵 등등 )
        Intent intent = null;

        if(v.getId() == R.id.ln_menu1){
            intent = new Intent(Intent.ACTION_VIEW , Uri.parse("http://m.naver.com"));
        }else if(v.getId() == R.id.ln_menu2){
            intent = new Intent(Intent.ACTION_DIAL , Uri.parse("tel:010-7997-2725"));
        }else if(v.getId() == R.id.ln_menu3){
            // Google에 검색해서 한가지 Intent 액션을 선정 후 넣어보기.
            intent = new Intent(Intent.ACTION_VIEW , Uri.parse("geo:35.159520, 126.852678"));

        }

        startActivity(intent);

    }
}