package com.poly.websitesellphone.model;

import java.util.List;

public class OrderDetailModel {
    private int idOrderDetail;
    private int price;
    private int quantity;
    private OrderModel order;
    private List<ProductModel> listProduct;


    public OrderDetailModel() {}

    public OrderDetailModel(int idOrderDetail, int price, int quantity, OrderModel order, List<ProductModel> listProduct) {
        this.idOrderDetail = idOrderDetail;
        this.price = price;
        this.quantity = quantity;
        this.order = order;
        this.listProduct = listProduct;
    }

    public int getIdOrderDetail() {
        return idOrderDetail;
    }

    public void setIdOrderDetail(int idOrderDetail) {
        this.idOrderDetail = idOrderDetail;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public OrderModel getOrder() {
        return order;
    }

    public void setOrder(OrderModel order) {
        this.order = order;
    }

    public List<ProductModel> getListProduct() {
        return listProduct;
    }

    public void setListProduct(List<ProductModel> listProduct) {
        this.listProduct = listProduct;
    }
}
