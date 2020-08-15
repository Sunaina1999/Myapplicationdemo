package com.example.myapplication;


import java.util.List;

public class Users1 {


    String roll;
    String name;

    public Users1() {
    }

    String course;

    public Users1(String roll, String name, String course, String mail, String cont, String userid, String dob) {
        this.roll = roll;
        this.name = name;
        this.course = course;
        this.mail = mail;
        this.cont = cont;
        this.userid = userid;
        this.dob = dob;
    }

    String mail;
    String cont;
    String userid;
    String dob;


    List<Student> students;

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
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

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

}
