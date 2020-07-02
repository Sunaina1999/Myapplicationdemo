package com.example.myapplication;


public class Users {
public Users()
    {

    }
    public String getName() {
        return name;
    }

    public String getPass() {
        return pass;
    }



    public void setName(String name) {
        this.name = name;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }



    public String getCpass() {
        return cpass;
    }

    public void setCpass(String cpass) {
        this.cpass = cpass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    String name;
    String pass;

    public Users(String name, String pass, String cpass, String email, String contact, String gender) {
        this.name = name;
        this.pass = pass;
        this.cpass = cpass;
        this.email = email;
        this.contact = contact;
        this.gender = gender;
    }

    String cpass;
    String email;
    String contact;
    String gender;
//    String name1;
//
//    public Users(String name1, String pass1) {
//        this.name1 = name1;
//        this.pass1 = pass1;
//    }
//
//    String pass1;
//    public String getName1() {
//        return name1;
//    }
//
//    public void setName1(String name1) {
//        this.name1 = name1;
//    }
//
//    public String getPass1() {
//        return pass1;
//    }
//
//    public void setPass1(String pass1) {
//        this.pass1 = pass1;
//    }


}
