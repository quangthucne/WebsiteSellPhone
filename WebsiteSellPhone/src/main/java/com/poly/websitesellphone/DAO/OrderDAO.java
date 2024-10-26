package com.poly.websitesellphone.DAO;


import com.poly.websitesellphone.Service.OrderInterface;
import com.poly.websitesellphone.model.OrderModel;
import com.poly.websitesellphone.model.UserModel;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderDAO extends DataDAO implements OrderInterface {
    @Override
    public List<OrderModel> selectAll() {
        List<OrderModel> list = new ArrayList<>();
        try {
            Connection connection = getConnection();
            ResultSet rs = query(ORDER_SELECT_ALL_ADMIN);
            while (rs.next()) {
                int idOrder = rs.getInt(COLUMN_ID_ORDER);
                String phone = rs.getString(COLUMN_PHONE);
                String address = rs.getString(COLUMN_ADDRESS);
                String fullName = rs.getString(COLUMN_FULL_NAME);
                Date dateCreated = rs.getDate(COLUMN_DATE_CREATED);
                int status = rs.getInt(COLUMN_STATUS);
                int totalAmount = rs.getInt(COLUMN_TOTAL_PRICE);
                System.out.println(totalAmount);
                list.add(new OrderModel(idOrder, phone, address, fullName, (java.sql.Date) dateCreated, status, totalAmount));
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
                String phone = rs.getString(COLUMN_PHONE);
                String address = rs.getString(COLUMN_ADDRESS);
                String fullName = rs.getString(COLUMN_FULL_NAME);
                Date dateCreated = rs.getDate(COLUMN_DATE_CREATED);
                int status = rs.getInt(COLUMN_STATUS);
                UserDAO userDAO = new UserDAO();
                UserModel userModel = userDAO.selectById(idOrder);
                orderModel = new OrderModel(idOrder, phone, address, fullName, (java.sql.Date) dateCreated, status, userModel);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return orderModel;
    }

    @Override
    public List<OrderModel> selectByIdUser(int idUser) {
        List<OrderModel> list = new ArrayList<>();
        try {
            Connection connection = getConnection();
            ResultSet rs = query(ORDER_SELECT_BY_ID_USER, idUser);
            while (rs.next()) {
                int idOrder = rs.getInt(COLUMN_ID_ORDER);
                String phone = rs.getString(COLUMN_PHONE);
                String address = rs.getString(COLUMN_ADDRESS);
                String fullName = rs.getString(COLUMN_FULL_NAME);
                Date dateCreated = rs.getDate(COLUMN_DATE_CREATED);
                int status = rs.getInt(COLUMN_STATUS);
                UserDAO userDAO = new UserDAO();
                UserModel userModel = userDAO.selectById(idUser);
                list.add(new OrderModel(idOrder, phone, address, fullName, dateCreated, status, userModel));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public boolean insert(OrderModel orderModel) {
        boolean rs = false;
        try {
            Connection connection = getConnection();
            update(ORDER_INSERT,
                    orderModel.getIdUser(),
                    orderModel.getPhone(),
                    orderModel.getAddress(),
                    orderModel.getFullName(),
                    orderModel.getStatus()
            );
            rs = true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return rs;
    }

    public int insertGetID(OrderModel orderModel) {
        int generatedID = -1;
        try {
            Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(ORDER_INSERT, PreparedStatement.RETURN_GENERATED_KEYS);

            statement.setInt(1, orderModel.getIdUser());
            statement.setString(2, orderModel.getPhone());
            statement.setString(3, orderModel.getAddress());
            statement.setString(4, orderModel.getFullName());
            statement.setInt(5, orderModel.getStatus());

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet rs = statement.getGeneratedKeys();
                if (rs.next()) {
                    generatedID = rs.getInt(1);
                }
                rs.close();
            }

            statement.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return generatedID;
    }


    @Override
    public boolean update(OrderModel orderModel) {
        boolean rs = false;
        try {
            Connection connection = getConnection();
            update(ORDER_UPDATE,
                    orderModel.getPhone(),
                    orderModel.getAddress(),
                    orderModel.getFullName(),
                    orderModel.getStatus(),
                    orderModel.getIdOrder()
            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return rs;
    }

    @Override
    public boolean updateStatus(int idOrder, int statusOrder) {
        boolean rs = false;
        try {
            Connection connection = getConnection();
            update(ORDER_UPDATE_STATUS,
                    statusOrder,
                    idOrder
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
