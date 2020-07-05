package com.example.myapplication;

public class Users2 {
    public Users2(String name, String contact, String emailid) {
        this.name = name;
        this.contact = contact;
        this.emailid = emailid;
    }

    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    String contact;
    String emailid;

}
