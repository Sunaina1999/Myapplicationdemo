package com.example.myapplication;

public class noticehelper {
    public noticehelper() {
    }

    public noticehelper(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    String name;
    String url;
}
