package com.example.case3.model;

public class Student {
    private String name;
    private String email;
    private String phone;
    private String address;
    private String Class;

    public Student() {
    }

    public Student(String name, String email, String phone, String address, String aClass) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        Class = aClass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String getClass() {
        return Class;
    }

    public void setClass(String aClass) {
        Class = aClass;
    }
}