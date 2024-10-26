package com.poly.websitesellphone.Service;


import com.poly.websitesellphone.model.OrderDetailModel;

import java.util.List;

public interface OrderDetailInterface {
    // thông tin của table databse
    String TABLE_NAME = "order_detail";
    String COLUMN_ID_ORDER_DETAIL = "id_order_detail";
    String COLUMN_ID_ORDER = "id_order";
    String COLUMN_ID_PRODUCT = "id_product";
    String COLUMN_QUANTITY = "quantity";
    String COLUMN_PRICE = "price";
    String COLUMN_PHONE = "phone";
    String COLUMN_ADDRESS = "address";
    String COLUMN_FULL_NAME = "full_name";
    String COLUMN_TOTAL_PRICE = "total_price";

    // query String
    String ORDER_DETAIL_SELECT_ALL = String.format("SELECT * FORM %s ", TABLE_NAME);
    String ORDER_DETAIL_SELECT_BY_ID = String.format("SELECT * FROM %s WHERE %s = ?", TABLE_NAME, COLUMN_ID_ORDER);
    String ORDER_DETAIL_SELECT_BY_ID_PRODUCT = String.format("SELECT * FROM %s WHERE %s", TABLE_NAME, COLUMN_ID_PRODUCT);
    String ORDER_DETAIL_INSERT = String.format("INSERT INTO %s (%s, %s, %s, %s) VALUES (?, ?, ?, ? )", TABLE_NAME, COLUMN_ID_ORDER, COLUMN_ID_PRODUCT, COLUMN_PRICE, COLUMN_QUANTITY);
    String ORDER_DETAIL_UPDATE = String.format("UPDATE %s SET %s = ?, %s = ?, %s = ?, %s = ? WHERE %s = ?", TABLE_NAME, COLUMN_ID_ORDER, COLUMN_ID_PRODUCT, COLUMN_PRICE, COLUMN_QUANTITY, COLUMN_ID_ORDER_DETAIL);
    String ORDER_DETAIL_DELETE = String.format("DELETE FROM %s WHERE %s = ?", TABLE_NAME, COLUMN_ID_ORDER);




    // method

    public List<OrderDetailModel> selectAll();

    public List<OrderDetailModel> selectById(int idOrder);

    public OrderDetailModel selectByIdProduct(int idProduct);

    public boolean insert(OrderDetailModel orderDetailModel);

    public boolean update(OrderDetailModel orderDetailModel);

    public boolean delete(OrderDetailModel orderDetailModel);

}
