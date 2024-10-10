package com.poly.websitesellphone.model;

import java.sql.Date;
import java.util.List;

public class ProductModel {
    private int idProduct;
    private int idCategory;
    private String name;
    private String shortDesc;
    private String detail;
    private int quantity;
    private double price;
    private Date dateCreate;
    private int status;

    private List<ImageModel> listImage;

    public ProductModel() {
    }

    public ProductModel(int idProduct, int idCategory, String name, String shortDesc, String detail, int quantity, double price, Date dateCreate, int status, List<ImageModel> listImage) {
        this.idProduct = idProduct;
        this.idCategory = idCategory;
        this.name = name;
        this.shortDesc = shortDesc;
        this.detail = detail;
        this.quantity = quantity;
        this.price = price;
        this.dateCreate = dateCreate;
        this.status = status;
        this.listImage = listImage;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<ImageModel> getListImage() {
        return listImage;
    }

    public void setListImage(List<ImageModel> listImage) {
        this.listImage = listImage;
    }
}
