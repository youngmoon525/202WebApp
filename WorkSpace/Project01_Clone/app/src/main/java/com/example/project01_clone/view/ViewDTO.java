package com.example.project01_clone.view;

public class ViewDTO {
    private int img_logo_title  , img_content , like_count;
    private String logo_title , write_date , content_title , content_sub , content_sub2;

    public ViewDTO(int img_logo_title, int img_content, int like_count, String logo_title, String write_date, String content_title, String content_sub, String content_sub2) {
        this.img_logo_title = img_logo_title;
        this.img_content = img_content;
        this.like_count = like_count;
        this.logo_title = logo_title;
        this.write_date = write_date;
        this.content_title = content_title;
        this.content_sub = content_sub;
        this.content_sub2 = content_sub2;
    }

    public int getImg_logo_title() {
        return img_logo_title;
    }

    public void setImg_logo_title(int img_logo_title) {
        this.img_logo_title = img_logo_title;
    }

    public int getImg_content() {
        return img_content;
    }

    public void setImg_content(int img_content) {
        this.img_content = img_content;
    }

    public String getLogo_title() {
        return logo_title;
    }

    public void setLogo_title(String logo_title) {
        this.logo_title = logo_title;
    }

    public String getWrite_date() {
        return write_date;
    }

    public void setWrite_date(String write_date) {
        this.write_date = write_date;
    }

    public String getContent_title() {
        return content_title;
    }

    public void setContent_title(String content_title) {
        this.content_title = content_title;
    }

    public String getContent_sub() {
        return content_sub;
    }

    public void setContent_sub(String content_sub) {
        this.content_sub = content_sub;
    }

    public String getContent_sub2() {
        return content_sub2;
    }

    public void setContent_sub2(String content_sub2) {
        this.content_sub2 = content_sub2;
    }
}
