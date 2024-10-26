package com.poly.websitesellphone.model;

public class CartDetailModel {
    private int idCartDetail;
    private int idCart;
    private int idProduct;
    private int quantityProduct;

    public CartDetailModel() {}

    public CartDetailModel(int idCartDetail, int idCart, int idProduct, int quantityProduct) {
        this.idCartDetail = idCartDetail;
        this.idCart = idCart;
        this.idProduct = idProduct;
        this.quantityProduct = quantityProduct;
    }

    public int getIdCartDetail() {
        return idCartDetail;
    }

    public void setIdCartDetail(int idCartDetail) {
        this.idCartDetail = idCartDetail;
    }

    public int getIdCart() {
        return idCart;
    }

    public void setIdCart(int idCart) {
        this.idCart = idCart;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getQuantityProduct() {
        return quantityProduct;
    }

    public void setQuantityProduct(int quantityProduct) {
        this.quantityProduct = quantityProduct;
    }
}
