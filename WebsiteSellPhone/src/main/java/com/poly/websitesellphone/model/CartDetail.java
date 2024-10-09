package com.poly.websitesellphone.model;

public class CartDetail {
    private int id;
    private int cartId;
    private int productId;
    private int quantityProduct;

    public CartDetail() {
        super();
    }

    public CartDetail(int id, int cartId, int productId, int quantityProduct) {
        super();
        this.id = id;
        this.cartId = cartId;
        this.productId = productId;
        this.quantityProduct = quantityProduct;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantityProduct() {
        return quantityProduct;
    }

    public void setQuantityProduct(int quantityProduct) {
        this.quantityProduct = quantityProduct;
    }
}
