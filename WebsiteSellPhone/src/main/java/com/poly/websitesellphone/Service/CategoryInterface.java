package com.poly.websitesellphone.Service;

import com.poly.websitesellphone.model.CategoryModel;

import java.util.List;

public interface CategoryInterface {
    String TABLE_NAME = "category";
    String COLUMN_ID = "id_category";
    String COLUMN_NAME = "name";
    String COLUMN_STATUS = "status";

    String CATEGORY_SELECT_ALL = String.format("SELECT * FROM %s ", TABLE_NAME);
    String CATEGORY_SELECT_BY_ID = String.format("SELECT * FROM %s WHERE %s = ?", TABLE_NAME, COLUMN_ID);
    String CATEGORY_INSERT = String.format("INSERT INTO %s (%s, %s) VALUES (?, ?) ", TABLE_NAME, COLUMN_NAME, COLUMN_STATUS);
    String CATEGORY_UPDATE = String.format("UPDATE %s SET %s = ?, %s = ? WHERE %s = ?", TABLE_NAME, COLUMN_NAME, COLUMN_STATUS, COLUMN_ID);
    String CATEGORY_DELETE = String.format("DELETE FROM %s WHERE %s = ?", TABLE_NAME, COLUMN_ID);

    public List<CategoryModel> selectAll();

    public CategoryModel selectById(int id);

    public boolean insert(CategoryModel categoryModel);

    public boolean update(CategoryModel categoryModel);

    public boolean delete(int id);

}
