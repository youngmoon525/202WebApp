package com.example.and11_allview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.ListView;

import java.util.ArrayList;

public class SubActivity extends AppCompatActivity {
    ListView listv_sub;
    ArrayList<ListDTO> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        // inflater를 List_Adapter가 사용할수있게하려면 어떻게 해야할까?
        // ListAdapter생성해보기.
        for (int i = 0; i < 20; i++) { // ==> DB에서 가져옴(추후)
            list.add(new ListDTO("name" + i, "cnt" + i));
        }

        listv_sub = findViewById(R.id.listv_sub);
        List_Adapter adapter = new List_Adapter(getLayoutInflater() , list);
        listv_sub.setAdapter(adapter);

        // List_Adapter의 아이템 갯수 == list.size와 같게 처리해보기.

        Log.d("로그", " 리스트의 사이즈 : " + list.size());


    }
}