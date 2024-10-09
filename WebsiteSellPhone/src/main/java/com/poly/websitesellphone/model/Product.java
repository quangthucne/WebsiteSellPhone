package com.poly.websitesellphone.model;

public class Product {
    private int id;
    private int categoryId;
    private String name;
    private String shortDesc;
    private String detail;
    private int quantity;
    private int price;
    private String dateCreated;
    private boolean status;

    public Product() {
        super();
    }

    public Product(int id, int categoryId, String name, String shortDesc, String detail, int quantity, int price, String dateCreated, boolean status) {
        super();
        this.id = id;
        this.categoryId = categoryId;
        this.name = name;
        this.shortDesc = shortDesc;
        this.detail = detail;
        this.quantity = quantity;
        this.price = price;
        this.dateCreated = dateCreated;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
