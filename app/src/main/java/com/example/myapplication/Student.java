package com.example.myapplication;

import java.util.List;

public class Student {
    int roll;
    String name;

    public Student() {
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


    Boolean status;
    String date;

    public Student(int roll, String name, Boolean status, String date) {
        this.roll = roll;
        this.name = name;
        this.status = status;
        this.date = date;

    }
}
