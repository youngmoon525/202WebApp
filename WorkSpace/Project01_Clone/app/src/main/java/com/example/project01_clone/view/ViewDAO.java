package com.example.project01_clone.view;

import com.example.project01_clone.R;

import java.util.ArrayList;

public class ViewDAO {

    public ArrayList<ViewDTO> getList(){
        ArrayList<ViewDTO> list = new ArrayList<>();
        list.add(new ViewDTO(R.drawable.view_logo,R.drawable.img_view_main,26,
                "오늘의집" , "12시간 전",
                "'30 년' 된 아파트, 다 부셔 버렸더니..",
                "어마어마한 스트레스 끝에 탄생한 집, 완전 대박!",
                "'공사 비용' 줄이려고 했다가 .. 집을 다 부쉈다고요..?"
                )
        );
        list.add(new ViewDTO(R.drawable.profile_img1,R.drawable.banner_view,10,
                        "멜론" , "1일 전",
                        "방탄소년단 RM의 솔직한 생각과 청춘이 담긴",
                        "솔로앨범에 음악부터 미술까지 담는 남자 어떤데",
                        "[Spotlight] RM 발매 이벤트]"
                )
        );

        return list ;
    }
}
