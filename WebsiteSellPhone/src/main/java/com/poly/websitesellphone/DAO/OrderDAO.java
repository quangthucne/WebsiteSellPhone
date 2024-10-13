package com.poly.websitesellphone.DAO;

import com.poly.websitesellphone.Service.OrderInterface;
import com.poly.websitesellphone.model.OrderModel;
import com.poly.websitesellphone.model.UserModel;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO extends DataDAO implements OrderInterface {
    @Override
    public List<OrderModel> selectAll() {
        List<OrderModel> list = new ArrayList<>();
        try {
            Connection connection = getConnection();
            ResultSet rs = query(ORDER_SELECT_ALL);
            while (rs.next()) {
                int idOrder = rs.getInt(COLUMN_ID_ORDER);
                int idUser = rs.getInt(COLUMN_ID_USER);
                String phone = rs.getNString(COLUMN_PHONE);
                String address = rs.getString(COLUMN_ADDRESS);
                String fullName = rs.getString(COLUMN_FULL_NAME);
                Date dateCreated = rs.getDate(COLUMN_DATE_CREATED);
                int status = rs.getInt(COLUMN_STATUS);
                double totalAmount = rs.getDouble(COLUMN_TOTAL_AMOUNT);
                list.add(new OrderModel(idOrder, idUser, phone, address, fullName, dateCreated, status, totalAmount));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public OrderModel selectById(int idOrder) {
        OrderModel orderModel = null;
        try {
            Connection connection = getConnection();
            ResultSet rs = query(ORDER_SELECT_BY_ID, idOrder);
            while (rs.next()) {
                int idUser = rs.getInt(COLUMN_ID_USER);
                String phone = rs.getNString(COLUMN_PHONE);
                String address = rs.getString(COLUMN_ADDRESS);
                String fullName = rs.getString(COLUMN_FULL_NAME);
                Date dateCreated = rs.getDate(COLUMN_DATE_CREATED);
                int status = rs.getInt(COLUMN_STATUS);
                double totalAmount = rs.getDouble(COLUMN_TOTAL_AMOUNT);
                orderModel = new OrderModel(idOrder, phone, address, fullName, dateCreated, status, totalAmount,);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return orderModel;
    }

    @Override
    public OrderModel selectByIdUser(int idUser) {
        OrderModel orderModel = null;
        try {
            Connection connection = getConnection();
            ResultSet rs = query(ORDER_SELECT_BY_ID_USER, idUser);
            while (rs.next()) {
                int idOrder = rs.getInt(COLUMN_ID_ORDER);
                String phone = rs.getNString(COLUMN_PHONE);
                String address = rs.getString(COLUMN_ADDRESS);
                String fullName = rs.getString(COLUMN_FULL_NAME);
                Date dateCreated = rs.getDate(COLUMN_DATE_CREATED);
                int status = rs.getInt(COLUMN_STATUS);
                double totalAmount = rs.getDouble(COLUMN_TOTAL_AMOUNT);
                UserDAO userDAO = new UserDAO();
                UserModel userModel = userDAO.selectById(idUser);
                orderModel = new OrderModel(idOrder, phone, address, fullName, dateCreated, status, totalAmount, userModel);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return orderModel;
    }

    @Override
    public boolean insert(OrderModel orderModel) {
        boolean rs = false;
        try {
            Connection connection = getConnection();
            update(ORDER_INSERT,
                    orderModel.getUserModel().getIdUser(),
                    orderModel.getPhone(),
                    orderModel.getAddress(),
                    orderModel.getFullName(),
                    orderModel.getDateCreated(),
                    orderModel.getStatus(),
                    orderModel.getTotalAmount()
            );
            rs = true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return rs;
    }

    @Override
    public boolean update(OrderModel orderModel) {
        boolean rs = false;
        try {
            Connection connection = getConnection();
            update(ORDER_UPDATE,
                    orderModel.getIdUser(),
                    orderModel.getPhone(),
                    orderModel.getAddress(),
                    orderModel.getFullName(),
                    orderModel.getDateCreated(),
                    orderModel.getStatus(),
                    orderModel.getTotalAmount(),
                    orderModel.getIdOrder()
            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return rs;
    }

    @Override
    public boolean delete(OrderModel orderModel) {
        boolean rs = false;
        try {
            Connection connection = getConnection();
            update(ORDER_DELETE, orderModel.getIdOrder());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return rs;
    }
}
