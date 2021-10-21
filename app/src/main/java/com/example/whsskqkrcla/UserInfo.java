package com.example.whsskqkrcla;

import java.util.HashMap;

public class UserInfo {

    private String email;
    private String pwd;
    private String profile;     //이미지 경로는 String이기 때문이다.

    private String place;       //위치기반 지도 api 활용
    private Boolean group;
    private HashMap<String, Integer> category;

    private String bookmark;
    private String inroom;

    public UserInfo() { }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Boolean getGroup() {
        return group;
    }

    public void setGroup(Boolean group) {
        this.group = group;
    }

    public HashMap<String, Integer> getCategory() {
        return category;
    }

    public void setCategory(HashMap<String, Integer> category) {
        this.category = category;
    }

    public String getBookmark() {
        return bookmark;
    }

    public void setBookmark(String bookmark) {
        this.bookmark = bookmark;
    }

    public String getInroom() {
        return inroom;
    }

    public void setInroom(String inroom) {
        this.inroom = inroom;
    }
}
