package com.example.test01_layout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ImageView imgv1 , imgv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgv1 = findViewById(R.id.imgv1);
        imgv2 = findViewById(R.id.imgv2);
        TextView tv_arrow = findViewById(R.id.tv_arrow);
        tv_arrow.setText(">");

        Button btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(imgv1.getVisibility() == View.VISIBLE){
                    imgv1.setVisibility(View.GONE);
                    imgv2.setVisibility(View.VISIBLE);
                }else if(imgv2.getVisibility() == View.VISIBLE){
                    imgv2.setVisibility(View.GONE);
                    imgv1.setVisibility(View.VISIBLE);
                }
            }
        });

    }
}