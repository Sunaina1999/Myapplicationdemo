package com.example.myapplication;


import java.util.List;

public class Users1 {
    int roll;
    String name;
    String course;
    String dob;
    String mail;



    public Users1(int roll, String name, String course, String dob, String mail, Boolean status, String date, String cont, String userid, List<Users1> list) {
        this.roll = roll;
        this.name = name;
        this.course = course;
        this.dob = dob;
        this.mail = mail;
        this.status = status;
        this.date = date;
        this.cont = cont;
        this.userid = userid;
        this.list = list;
    }

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCont() {
        return cont;
    }

    public void setCont(String cont) {
        this.cont = cont;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public List<Users1> getList() {
        return list;
    }

    public void setList(List<Users1> list) {
        this.list = list;
    }

    Boolean status;
    String date;
    String cont;
    String userid;
    List<Users1> list;
}
