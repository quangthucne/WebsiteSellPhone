package com.poly.websitesellphone.Service;

import com.poly.websitesellphone.model.UserModel;

import java.util.List;

public interface UserInterface {
    String TABLE_NAME = "user";
    String COLUMN_ID_USER = "id_user";
    String COLUMN_FULL_NAME = "full_name";
    String COLUNM_USER_NAME = "user_name";
    String COLUMN_PASSWORD = "password";
    String COLUMN_GENDER = "gender";
    String COLUMN_ID_ROLE = "id_role";
    String COLUMN_EMAIL = "email";
    String COLUMN_PHONE = "phone";
    String COLUMN_DATE_CREATED = "date_created";
    String COLUMN_STATUS = "status";

    String USER_SELECT_ALL = String.format("SELECT * FROM %s", TABLE_NAME);
    String USER_SELECT_BY_ID = String.format("SELECT * FROM %s WHERE %s=?", TABLE_NAME, COLUMN_ID_USER);
    String USER_INSERT = String.format("INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
    String USER_UPDATE = String.format("UPDATE %s SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ? WHERE %s=?", TABLE_NAME, COLUMN_FULL_NAME, COLUNM_USER_NAME, COLUMN_PASSWORD, COLUMN_GENDER, COLUMN_ID_ROLE, COLUMN_EMAIL, COLUMN_PHONE, COLUMN_DATE_CREATED, COLUMN_STATUS, COLUMN_ID_USER);
    String USER_DELETE = String.format("DELETE FROM %s WHERE %s = ?", TABLE_NAME, COLUMN_ID_USER);

    public List<UserModel> selectAll();

    public UserModel selectById(int id);

    public boolean insert(UserModel userModel);

    public boolean update(UserModel userModel);

    public boolean delete(UserModel userModel);
}
