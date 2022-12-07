package com.example.project01_clone.chat_exam;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.project01_clone.R;
import com.example.project01_clone.common.CommonMethod;

import java.util.ArrayList;

public class ChatExamFragment extends Fragment {
    RecyclerView recv_exam_chat;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.fragment_chat_exam, container, false);
        recv_exam_chat = v.findViewById(R.id.recv_exam_chat);

        ArrayList<ChatExamDTO> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            list.add(new ChatExamDTO(R.drawable.profile_img1, "이름"+i, "메세지"+i, "오후12:29"));
        }

        ChatExamAdapter adapter = new ChatExamAdapter(inflater , list);
        adapter.setContext(getContext());
        recv_exam_chat.setAdapter(adapter);//리사이클러뷰 <=> 어댑터 연결
        LinearLayoutManager manager = CommonMethod.getManager(getContext());
        recv_exam_chat.setLayoutManager(manager);

        return v;
    }

    public boolean add(ChatExamDTO e){
        e =  new ChatExamDTO(R.drawable.profile_img1,
                "이름",
                "메세지",
                "오후12:29");
        return false;
    }

}