package com.poly.websitesellphone.model;

public class Cart {
    private int id;
    private int userId;

    public Cart() {
        super();
    }

    public Cart(int id, int userId) {
        super();
        this.id = id;
        this.userId = userId;
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
}
