package com.example.myapplication;

public class lidata {
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    private int imgid;
    public int getImgid() {
        return imgid;
    }

    public void setImgid(int imgid) {
        this.imgid = imgid;
    }


    public lidata(String name, int imgid) {
        this.name = name;
        this.imgid = imgid;
    }


}
