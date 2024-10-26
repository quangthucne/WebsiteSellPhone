package com.poly.websitesellphone.model;


import java.util.Date;
import java.util.List;

public class OrderModel {
    private int idOrder;
    private int idUser;
    private String phone;
    private String address;
    private String fullName;
    private Date dateCreated;
    private int status;
    private int totalAmount;

    private List<OrderDetailModel> orderDetail;
    private UserModel userModel;

    public OrderModel(int idOrder, String phone, String address, String fullName, Date dateCreated, int status, OrderDetailModel orderDetail) {
        this.idOrder = idOrder;
        this.phone = phone;
        this.address = address;
        this.fullName = fullName;
        this.dateCreated = dateCreated;
        this.status = status;
    }

    public OrderModel(int idOrder, int idUser, String phone, String address, String fullName, Date dateCreated, int status, UserModel userModel) {
        this.idOrder = idOrder;
        this.idUser = idUser;
        this.phone = phone;
        this.address = address;
        this.fullName = fullName;
        this.dateCreated = dateCreated;
        this.status = status;
        this.userModel = userModel;
    }

    public OrderModel(int idUser, String phone, String address, String fullName, Date dateCreated, int status, List<OrderDetailModel> orderDetail) {
        this.idUser = idUser;
        this.phone = phone;
        this.address = address;
        this.fullName = fullName;
        this.dateCreated = dateCreated;
        this.status = status;
        this.orderDetail = orderDetail;
    }

    public OrderModel(int idOrder, int idUser, String phone, String address, String fullName, Date dateCreated, int status, List<OrderDetailModel> orderDetail, UserModel userModel) {
        this.idOrder = idOrder;
        this.idUser = idUser;
        this.phone = phone;
        this.address = address;
        this.fullName = fullName;
        this.dateCreated = dateCreated;
        this.status = status;
        this.orderDetail = orderDetail;
        this.userModel = userModel;
    }


    public OrderModel(int idOrder, String phone, String address, String fullName, Date dateCreated, int status, int totalAmount) {
        this.idOrder = idOrder;
        this.phone = phone;
        this.address = address;
        this.fullName = fullName;
        this.dateCreated = dateCreated;
        this.status = status;
        this.totalAmount = totalAmount;
    }

    public List<OrderDetailModel> getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(List<OrderDetailModel> orderDetail) {
        this.orderDetail = orderDetail;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public OrderModel(int idOrder, String phone, String address, String fullName, Date dateCreated, int status, UserModel userModel) {
        this.idOrder = idOrder;
        this.phone = phone;
        this.address = address;
        this.fullName = fullName;
        this.dateCreated = dateCreated;
        this.status = status;
        this.userModel = userModel;
    }

    public OrderModel(int idOrder, int idUser, String phone, String address, String fullName, Date dateCreated, int status) {
        this.idOrder = idOrder;
        this.idUser = idUser;
        this.phone = phone;
        this.address = address;
        this.fullName = fullName;
        this.dateCreated = dateCreated;
        this.status = status;
    }

    public OrderModel(int idUser, String phone, String address, String fullName, int status) {
        this.idUser = idUser;
        this.phone = phone;
        this.address = address;
        this.fullName = fullName;
        this.status = status;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
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

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public UserModel getUserModel() {
        return userModel;
    }

    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }

}
