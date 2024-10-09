package com.poly.websitesellphone.model;

public class Address {
    private int id;
    private int userId;
    private String phone;
    private String address;
    private String fullName;

    public Address() {
        super();
    }

    public Address(int id, int userId, String phone, String address, String fullName) {
        super();
        this.id = id;
        this.userId = userId;
        this.phone = phone;
        this.address = address;
        this.fullName = fullName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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
       

