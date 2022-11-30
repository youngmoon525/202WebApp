package com.example.and11_allview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

//1. 일반 클래스 => 어댑터 타입의 클래스 ( extends 상속 )
public class List_Adapter extends BaseAdapter {

    LayoutInflater inflater;//
    ArrayList<ListDTO> list;

    public List_Adapter(LayoutInflater inflater, ArrayList<ListDTO> list) {
        this.inflater = inflater;
        this.list = list;
    }


    //2. 리스트뷰에 들어가는 내용의 갯수를 지정한다.(item count)
    // ex) 10건의 목록을 보여주고싶음 => return 10;
    // ArrayList<Data> list => return list.size();
    @Override
    public int getCount() {
        return list.size();
    }

    //3. ArrayList<Data> list 가 있을때 index로 해당하는 칸의 정보를 빼올때사용.
    @Override
    public Object getItem(int position) {
        return position;
    }
    //4. 칸에 별도의 아이디를 주고싶다면 사용하는데 position값은 절대 중복안되서
    //그냥 position으로 사용한다.
    @Override
    public long getItemId(int position) {
        return position;
    }
    //5. 리스트뷰는 getCount에서 지정 된 칸만큼 getView를 실행하면서
    //한칸마다 ViewGroup을 제공함 (Layout) <= 까지만 OS가 자동으로 해주는 부분
    //ViewGroup에 들어가는 내용을 붙이는건 개발자가 직접함.
    @Override
    public View getView(int i, View v, ViewGroup root) {
        // Layout을 붙이는 처리를 해야함.
        // List_Adapter라는 클래스에서 LayoutInflater 사용하게 만들어보기.
        v = inflater.inflate(R.layout.item_sub_listv , root , false );
        TextView tv_name = v.findViewById(R.id.tv_name);
        TextView tv_cnt = v.findViewById(R.id.tv_cnt);
        tv_name.setText(list.get(i).getName());
        tv_cnt.setText(list.get(i).getCnt());

        return v;
    }
}
