package com.example.myapplication;


public class Users1 {
    public Users1()
    {

    }
    String roll;
    String name;

    public String getName() {
        return name;
    }

    public String getUserid() {
        return userid;
    }

    String course;

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
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

    public String getCont() {
        return cont;
    }

    public void setCont(String cont) {
        this.cont = cont;
    }



    public void setUserid(String userid) {
        this.userid = userid;
    }

    String dob;
    String mail;

    public Users1(String roll, String name, String course, String dob, String mail, String cont, String userid) {
        this.roll = roll;
        this.name = name;
        this.course = course;
        this.dob = dob;
        this.mail = mail;
        this.cont = cont;
        this.userid = userid;
    }

    String cont;
    String userid;
}
