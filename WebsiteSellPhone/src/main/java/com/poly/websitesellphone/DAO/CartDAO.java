package com.poly.websitesellphone.DAO;


import com.poly.websitesellphone.Service.CartInterface;
import com.poly.websitesellphone.model.CartDetailModel;
import com.poly.websitesellphone.model.CartModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartDAO extends DataDAO implements CartInterface {
    @Override
    public List<CartModel> selectAll() {
        List<CartModel> list = new ArrayList<>();
        try {
            Connection conn = getConnection();
            ResultSet rs = query(CART_SELECT_ALL);
            while (rs.next()) {
                int idCart = rs.getInt(COLUMN_ID_CART);
                int idUser = rs.getInt(COLUMN_ID_USER);
                list.add(new CartModel(idCart, idUser));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public CartModel selectById(int idCart) {
        CartModel cartModel = null;
        try {
            Connection conn = getConnection();
            ResultSet rs = query(CART_SELECT_BY_ID, idCart);
            while (rs.next()) {
                int id = rs.getInt(COLUMN_ID_CART);
                int idUser = rs.getInt(COLUMN_ID_USER);
                CartDetailDAO cartDetailDAO = new CartDetailDAO();
                List<CartDetailModel> cartDetailModelList = cartDetailDAO.selectByIdCart(idCart);
                cartModel = new CartModel(id, idUser, cartDetailModelList);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cartModel;
    }

    @Override
    public CartModel selectByIdUser(int idUser) {
        CartModel cartModel = null;
        try {
            Connection conn = getConnection();
            ResultSet rs = query(CART_SELECT_BY_ID_USER, idUser);
            while (rs.next()) {
                int idCart = rs.getInt(COLUMN_ID_CART);
                int id = rs.getInt(COLUMN_ID_USER);
                CartDetailDAO cartDetailDAO = new CartDetailDAO();
                List<CartDetailModel> list = cartDetailDAO.selectByIdCart(idCart);
                cartModel = new CartModel(idCart, id, list);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cartModel;
    }

    @Override
    public boolean insert(int idUser) {
        boolean result = false;
        try {
            Connection conn = getConnection();
            update(CART_INSERT, idUser);
            result = true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
