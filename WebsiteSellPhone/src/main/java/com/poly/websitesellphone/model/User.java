package com.poly.websitesellphone.model;

public class User {
    private int id;
    private String fullName;
    private String userName;
    private String password; 
    private boolean gender;
    private int role; 
    private String email;
    private String phone;
    private String dateCreated;
    private boolean status;

    public User() {
        super();
    }

    public User(int id, String fullName, String userName, String password, boolean gender, int role, String email, String phone, String dateCreated, boolean status) {
        super();
        this.id = id;
        this.fullName = fullName;
        this.userName = userName;
        this.password = password;
        this.gender = gender;
        this.role = role;
        this.email = email;
        this.phone = phone;
        this.dateCreated = dateCreated;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
