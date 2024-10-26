package com.poly.websitesellphone.Service;


import com.poly.websitesellphone.model.CartDetailModel;

import java.util.List;

public interface CartDetailInterface {
    String TABLE_NAME = "cart_detail";
    String TABLE_NAME_CART = "cart";
    String COLUMN_ID_CART_DETAIL = "id_cart_detail";
    String COLUMN_ID_CART = "id_cart";
    String COLUMN_ID_PRODUCT = "id_product";
    String COLUMN_ID_QUANTITY_PRODUCT = "quantity_product";
    String COLUMN_ID_USER_ID = "id_user";

    String CART_DETAIL_SELECT_ALL = String.format("SELECT * FROM %s", TABLE_NAME);
    String CART_DETAIL_SELECT_BY_ID = String.format("SELECT * FROM %s WHERE %s = ?", TABLE_NAME, COLUMN_ID_CART_DETAIL);
    String CART_DETAIL_SELECT_BY_ID_CART = String.format("SELECT * FROM %s WHERE %s = ?", TABLE_NAME, COLUMN_ID_CART);
    String CART_DEATAIL_SELECT_BY_ID_PRODUCT = String.format("SELECT * FROM %s INNER JOIN %s ON %s.%s = %s.%s WHERE %s = ? AND %s = ?", TABLE_NAME, TABLE_NAME_CART, TABLE_NAME, COLUMN_ID_CART, TABLE_NAME_CART, COLUMN_ID_CART,  COLUMN_ID_PRODUCT, COLUMN_ID_USER_ID);
    String CART_DEATIL_INSERT = String.format("INSERT INTO %s (%s, %s, %s) VALUES (?, ?, ?)", TABLE_NAME, COLUMN_ID_CART, COLUMN_ID_PRODUCT, COLUMN_ID_QUANTITY_PRODUCT);
    String CART_DETAIL_UPDATE = String.format("UPDATE %s SET %s = ?, SET %s = ?, SET %s = ? WHERE %s = ?", TABLE_NAME, COLUMN_ID_CART, COLUMN_ID_PRODUCT, COLUMN_ID_QUANTITY_PRODUCT, COLUMN_ID_CART_DETAIL);
    String CART_DETAIL_UPDATE_QUANTITY = String.format("UPDATE %s SET %s = ? WHERE %s = ?", TABLE_NAME, COLUMN_ID_QUANTITY_PRODUCT, COLUMN_ID_PRODUCT);
    String CART_DETAIL_DELETE = String.format("DELETE FROM %s WHERE %s = ?", TABLE_NAME, COLUMN_ID_CART_DETAIL);


    public List<CartDetailModel> selectAll();

    public CartDetailModel selectById(int idCartDetail);

    public List<CartDetailModel> selectByIdCart(int idCart);

    public CartDetailModel selectByIdProduct(int idProduct, int idUser);

    public boolean updateQuantityProduct(int idProduct, int quantityProduct);

    public boolean insert(CartDetailModel cartDetailModel);

    public boolean update(CartDetailModel cartDetailModel);

    public boolean delete(int idCartDetail);
}
