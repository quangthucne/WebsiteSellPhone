package com.poly.websitesellphone.Service;

import com.poly.websitesellphone.model.ProductModel;

import java.util.List;

public interface ProductInterface {
    String TABLE_NAME = "product";
    String COLUMN_ID_PRODUCT = "id_product";
    String COLUMN_ID_CATEGORY = "id_category";
    String COLUMN_NAME = "name";
    String COLUMN_SHORT_DESC = "short_desc";
    String COLUMN_DETAIL = "detail";
    String COLUMN_QUANTITY = "quantity";
    String COLUMN_PRICE = "price";
    String COLUMN_DATE_CREATED = "date_created";
    String COLUMN_STATUS = "status";

    String PRODUCT_SELECT_ALL = String.format("SELECT * FROM %s", TABLE_NAME);
    String PRODUCT_SELECT_BY_ID = String.format("SELECT * FROM %s WHERE %s = ?", TABLE_NAME, COLUMN_ID_PRODUCT);
    String PRODUCT_INSERT = String.format("INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s) VALUES (?, ?, ?, ?, ?, ?, ?, ?)", TABLE_NAME, COLUMN_ID_CATEGORY, COLUMN_NAME, COLUMN_SHORT_DESC, COLUMN_DETAIL, COLUMN_QUANTITY, COLUMN_PRICE, COLUMN_DATE_CREATED, COLUMN_STATUS);
    String PRODUCT_UPDATE = String.format("UPDATE %s SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ? WHERE %s = ?", TABLE_NAME, COLUMN_ID_CATEGORY, COLUMN_NAME, COLUMN_SHORT_DESC, COLUMN_DETAIL, COLUMN_QUANTITY, COLUMN_PRICE, COLUMN_DATE_CREATED, COLUMN_STATUS, COLUMN_ID_PRODUCT);
    String PRODUCT_DELETE = String.format("DELETE FROM %s WHERE %s = ?", TABLE_NAME, COLUMN_ID_PRODUCT);

    public List<ProductModel> selectAll();

    public ProductModel selectById(int id);

    public boolean insert(ProductModel productModel);

    public boolean update(ProductModel productModel);

    public boolean delete(int id);
}
