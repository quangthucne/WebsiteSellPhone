package com.poly.websitesellphone.model;

public class Image {
    private int id;
    private int productId;
    private String nameImage;

    public Image() {
        super();
    }

    public Image(int id, int productId, String nameImage) {
        super();
        this.id = id;
        this.productId = productId;
        this.nameImage = nameImage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getNameImage() {
        return nameImage;
    }

    public void setNameImage(String nameImage) {
        this.nameImage = nameImage;
    }
}
