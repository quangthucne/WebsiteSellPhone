package com.poly.websitesellphone.Service;

import com.poly.websitesellphone.model.ProductModel;

import java.util.List;

public interface ProductInterface {
    String TABLE_NAME_PRODUCT = "product";
    String TABLE_NAME_IMAGE = "image";
    String TABLE_NAME_CATEGORY = "category";
    String COLUMN_ID_PRODUCT = "id_product";
    String COLUMN_ID_CATEGORY = "id_category";
    String COLUMN_NAME = "name";
    String COLUMN_SHORT_DESC = "short_desc";
    String COLUMN_DETAIL = "detail";
    String COLUMN_QUANTITY = "quantity";
    String COLUMN_PRICE = "price";
    String COLUMN_DATE_CREATED = "date_created";
    String COLUMN_STATUS = "status";
    String COLUMN_ID_IMAGE = "id_image";
    String COLUMN_NAME_IMAGE = "name_image";
    String COLUMN_NAME_CATEGORY = "name_category";

//    String PRODUCT_SELECT_ALL = String.format("SELECT * FROM %s", TABLE_NAME);
    String PRODUCT_SELECT_BY_ID = String.format("SELECT * FROM %s WHERE %s = ?", TABLE_NAME_PRODUCT, COLUMN_ID_PRODUCT);
    String PRODUCT_INSERT = String.format("INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s) VALUES (?, ?, ?, ?, ?, ?, ?, ?)", TABLE_NAME_PRODUCT, COLUMN_ID_CATEGORY, COLUMN_NAME, COLUMN_SHORT_DESC, COLUMN_DETAIL, COLUMN_QUANTITY, COLUMN_PRICE, COLUMN_DATE_CREATED, COLUMN_STATUS);
    String PRODUCT_UPDATE = String.format("UPDATE %s SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ? WHERE %s = ?", TABLE_NAME_PRODUCT, COLUMN_ID_CATEGORY, COLUMN_NAME, COLUMN_SHORT_DESC, COLUMN_DETAIL, COLUMN_QUANTITY, COLUMN_PRICE, COLUMN_DATE_CREATED, COLUMN_STATUS, COLUMN_ID_PRODUCT);
    String PRODUCT_DELETE = String.format("DELETE FROM %s WHERE %s = ?", TABLE_NAME_PRODUCT, COLUMN_ID_PRODUCT);

// check query before excute()
    String PRODUCT_SELECT_ALL = String.format("SELECT p.%s , c.%s, p.%s, p.%s, p.%s, p.%s, p.%s, p.%s, p.%s, c.%s, %s.%s" +
        "FROM %s p \n" +
        "JOIN %s c on p.%s = c.%s \n" +
        "JOIN (SELECT %s, %s, MIN(%s) \n" +
        "    FROM %s \n" +
        "    GROUP BY %s, %s) %s  on p.%s = %s.%s",
            COLUMN_ID_PRODUCT, COLUMN_ID_CATEGORY, COLUMN_NAME, COLUMN_SHORT_DESC, COLUMN_DETAIL, COLUMN_QUANTITY, COLUMN_PRICE, COLUMN_DATE_CREATED, COLUMN_STATUS, COLUMN_NAME_CATEGORY, TABLE_NAME_IMAGE, COLUMN_NAME_IMAGE,
            TABLE_NAME_PRODUCT,
            TABLE_NAME_CATEGORY, COLUMN_ID_PRODUCT, COLUMN_ID_PRODUCT,
            COLUMN_ID_PRODUCT, COLUMN_ID_IMAGE, COLUMN_NAME_IMAGE,
            TABLE_NAME_IMAGE,
            COLUMN_ID_PRODUCT, COLUMN_ID_IMAGE, TABLE_NAME_IMAGE, COLUMN_ID_PRODUCT, TABLE_NAME_IMAGE, COLUMN_ID_PRODUCT
        );

    public List<ProductModel> selectAll();

    public ProductModel selectById(int id);

    public boolean insert(ProductModel productModel);

    public boolean update(ProductModel productModel);

    public boolean delete(int id);
}
