package com.example.and11_allview.melon;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.and11_allview.R;

import java.util.ArrayList;

public class MelonFragment extends Fragment {

        RecyclerView recv_melon ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_melon, container, false);
        recv_melon = v.findViewById(R.id.recv_melon);
        ArrayList<MelonDTO> list = new ArrayList<>();
        list.add(new MelonDTO(R.drawable.img1 , 1 , "사건의 지평선", "윤하 (YOUNHA)"));
        list.add(new MelonDTO(R.drawable.img2 , 2 , "ANTIFRAGILE", "LE SSERAFIM (르세라핌)"));
        list.add(new MelonDTO(R.drawable.img3 , 3 , "Hype boy", "NewJeans"));
        list.add(new MelonDTO(R.drawable.img4 , 4 , "Nxde", "(여자)아이들"));
        list.add(new MelonDTO(R.drawable.img5 , 5 , "After LIKE", "IVE (아이브)"));
        recv_melon.setAdapter(new MelonAdapter(inflater, list));
        recv_melon.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
        return  v;
    }
}