package com.example.project01_clone.chat_exam;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project01_clone.R;
import com.example.project01_clone.friendlist.FriendDTO;

import java.util.ArrayList;

//2. 리사이클러뷰는 반드시 뷰홀더를 강제 하기때문에 1번의 작업이 끝나고 나서 Adapter를 상속 받는다.
public class ChatExamAdapter extends RecyclerView.Adapter<ChatExamAdapter.ViewHolder>{
    // 모양확인 (3. onCreateViewHolder 메소드 , getItemCount 메소드 == 중복된모양으로 디자인 확인 가능)

    //onCreateViewHolder 오류안나게 작성해보기

    LayoutInflater inflater ;//어댑터에서 꼭 필요함
    ArrayList<ChatExamDTO> list;
    private Context context;

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public ChatExamAdapter(LayoutInflater inflater, ArrayList<ChatExamDTO> list) {
        this.inflater = inflater;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // 내가 return을 하고싶으면 해당하는 객체에 담을수있는 값 또는 해당하는 객체를 만들어서 return.
        return new ViewHolder(inflater.inflate(R.layout.item_recv_examchat,parent,false));
    }

    @Override // Binding , bind <=> 어떤 화면에 보이는 요소와 화면에 보이지 않는 데이터가 연결이 되었냐?
              //ViewHolder(데이터 한칸을 저장해놓은 DTO 화면에 보이는 요소) <===> ArrayList의 데이터
    public void onBindViewHolder(@NonNull ViewHolder v, int i) {
        v.tv_chat_name.setText(list.get(i).getChat_name());
        v.tv_chatdate.setText(list.get(i).getChat_date());
        v.tv_chat_msg.setText(list.get(i).getChat_msg());

        //한칸에 있는 리니어 레이아웃 클릭 시 어떤 처리를 하겠다.
        v.ln_chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 화면 전환 ==> 채팅 액티비티
                Context con_temp = v.getContext();

                Intent intent = new Intent(context, ChatExamActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    //1.위젯들을 재활용을 위해서 묶어두기위한(메모리에 올려두기 위한) 위젯용 DTO(ViewHolder)
    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgv_chat_profile ;
        TextView tv_chat_name , tv_chat_msg , tv_chatdate;
        LinearLayout ln_chat;
        public ViewHolder(@NonNull View v) {
            super(v);
            imgv_chat_profile = v.findViewById(R.id.imgv_chat_profile);
            tv_chat_name = v.findViewById(R.id.tv_chat_name);
            tv_chat_msg = v.findViewById(R.id.tv_chat_msg);
            tv_chatdate = v.findViewById(R.id.tv_chatdate);
            ln_chat = v.findViewById(R.id.ln_chat);

        }
    }
}
