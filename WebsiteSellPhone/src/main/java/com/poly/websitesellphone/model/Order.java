package com.poly.websitesellphone.model;

public class Order {
    private int id;
    private int userId;
    private String phone;
    private String address;
    private String fullName;
    private String dateCreated;
    private boolean status;
    private int totalAmount;

    public Order() {
        super();
    }

    public Order(int id, int userId, String phone, String address, String fullName, String dateCreated, boolean status, int totalAmount) {
        super();
        this.id = id;
        this.userId = userId;
        this.phone = phone;
        this.address = address;
        this.fullName = fullName;
        this.dateCreated = dateCreated;
        this.status = status;
        this.totalAmount = totalAmount;
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
        this.address = address;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }
}
