package com.example.vendingmachine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {

    TextView tv_money,tv_sub_get1,tv_sub_get2,tv_sub_get3,tv_sub_get4,total;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        tv_money = findViewById(R.id.tv_money);
        tv_sub_get1=findViewById(R.id.tv_sub_get1);
        tv_sub_get2=findViewById(R.id.tv_sub_get2);
        tv_sub_get3=findViewById(R.id.tv_sub_get3);
        tv_sub_get4=findViewById(R.id.tv_sub_get4);
        total=findViewById(R.id.total);

        Intent intent = getIntent();
        MoneyDTO dto = (MoneyDTO)intent.getSerializableExtra("m_dto");
        ArrayList<ResultDTO> r_dto = (ArrayList<ResultDTO>) intent.getSerializableExtra("r_dto");

        Log.d("TAG", "onCreate: "+ dto.getMoney());
        tv_money.setText(""+dto.getMoney());

        tv_sub_get1.setText(r_dto.get(0).getName() + " " + r_dto.get(0).getQty()+" 개");
        tv_sub_get2.setText(r_dto.get(1).getName() + " " + r_dto.get(1).getQty()+" 개");
        tv_sub_get3.setText(r_dto.get(2).getName() + " " + r_dto.get(2).getQty()+" 개");
        tv_sub_get4.setText(r_dto.get(3).getName() + " " + r_dto.get(3).getQty()+" 개");

        int total1 = 0;
        for (ResultDTO r: r_dto) {
            total1 += r.getQty()*r.getPrice();
        }

        total.setText("총 구매 금액 : " + total1+ "  원" );



    }
}