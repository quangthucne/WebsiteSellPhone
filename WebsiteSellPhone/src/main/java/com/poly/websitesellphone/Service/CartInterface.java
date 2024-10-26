package com.poly.websitesellphone.Service;

import com.poly.websitesellphone.model.CartModel;

import java.util.List;

public interface CartInterface {
    String TABLE_NAME = "cart";
    String COLUMN_ID_CART = "id_cart";
    String COLUMN_ID_USER = "id_user";

    String CART_SELECT_ALL = String.format("SELECT * FROM %s", TABLE_NAME);
    String CART_SELECT_BY_ID = String.format("SELECT * FROM %s WHERE %s = ?", TABLE_NAME, COLUMN_ID_CART);
    String CART_SELECT_BY_ID_USER = String.format("SELECT * FROM %s WHERE %s = ?", TABLE_NAME, COLUMN_ID_USER);

    public List<CartModel> selectAll();

    public CartModel selectById(String idCart);

    public CartModel selectByIdUser(String idUser);
}
