package com.example.myapplication;

class ProductViewHolder {
    public ProductViewHolder()
    {

    }
    String roll;
     String name;
    String course;

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

    public ProductViewHolder(String roll, String name, String course, String dob, String mail, String cont, String userid) {
        this.roll = roll;
        this.name = name;
        this.course = course;
        this.dob = dob;
        this.mail = mail;
        this.cont = cont;
        this.userid = userid;
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

    String dob;
    String mail;



    String cont;
    String userid;

}
