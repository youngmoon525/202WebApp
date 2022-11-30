package com.example.and11_allview.listfrag;

// SubActivity에서 ListDTO 30개를 가진 ArrayList 만들기


public class ListFDTO {
    public ListFDTO(String name, String cnt) {
        this.name = name;
        this.cnt = cnt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCnt() {
        return cnt;
    }

    public void setCnt(String cnt) {
        this.cnt = cnt;
    }

    private String name , cnt ;
}
