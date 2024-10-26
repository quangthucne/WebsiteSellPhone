package com.poly.websitesellphone.Service;


import com.poly.websitesellphone.model.OrderModel;

import java.util.List;

public interface OrderInterface {
    String TABLE_NAME = "[order]";
    String TABLE_NAME_DETAIL = "[order_detail]";
    String COLUMN_ID_ORDER = "id_order";
    String COLUMN_ID_USER = "id_user";
    String COLUMN_PHONE = "phone";
    String COLUMN_ADDRESS = "address";
    String COLUMN_FULL_NAME = "full_name";
    String COLUMN_DATE_CREATED = "date_created";
    String COLUMN_STATUS = "status_order";
    String COLUMN_TOTAL_AMOUNT = "total_amount";
    String DATE_CREATED = "GETDATE()";
    String COLUMN_ID_PRODUCT = "id_product";
    String COLUMN_QUANTITY = "quantity";
    String COLUMN_PRICE = "price";
    String COLUMN_TOTAL_PRICE = "total_price";


    String ORDER_SELECT_ALL = String.format("SELECT * FROM %s", TABLE_NAME);
    String ORDER_SELECT_BY_ID = String.format("SELECT * FROM %s WHERE %s=?", TABLE_NAME, COLUMN_ID_ORDER);
    String ORDER_SELECT_BY_ID_USER = String.format("SELECT * FROM %s WHERE %s=?", TABLE_NAME, COLUMN_ID_USER);
    String ORDER_INSERT = String.format("INSERT INTO %s (%s, %s, %s, %s, %s, %s) VALUES (?, ?, ?, ?, %s, ?)", TABLE_NAME, COLUMN_ID_USER, COLUMN_PHONE, COLUMN_ADDRESS, COLUMN_FULL_NAME, COLUMN_DATE_CREATED, COLUMN_STATUS, DATE_CREATED);
    String ORDER_UPDATE = String.format("UPDATE %s SET  %s = ?, %s = ?, %s = ?, %s = ?, %s = ? WHERE %s=?", TABLE_NAME, COLUMN_PHONE, COLUMN_ADDRESS, COLUMN_FULL_NAME, COLUMN_STATUS, COLUMN_TOTAL_AMOUNT, COLUMN_ID_ORDER);
    String ORDER_UPDATE_STATUS = String.format("UPDATE %s SET %s = ? WHERE %s=?", TABLE_NAME, COLUMN_STATUS, COLUMN_ID_ORDER);
    String ORDER_DELETE = String.format("DELETE FROM %s WHERE %s=?", TABLE_NAME, COLUMN_ID_ORDER);
    String ORDER_STATUS = String.format("UPDATE %s SET %s = ? WHERE %s = ?", TABLE_NAME, COLUMN_STATUS, COLUMN_ID_ORDER);

    String ORDER_SELECT_ALL_ADMIN = String.format(
            "SELECT o.%s, o.%s, o.%s, o.%s, o.%s, o.%s, SUM(od.%s * od.%s) AS %s FROM [order] o JOIN order_detail od ON o.%s = od.%s GROUP BY o.%s, o.%s, o.%s, o.%s, o.%s, o.%s",
            COLUMN_ID_ORDER,
            COLUMN_PHONE,
            COLUMN_ADDRESS,
            COLUMN_FULL_NAME,
            COLUMN_DATE_CREATED,
            COLUMN_STATUS,
            COLUMN_QUANTITY,
            COLUMN_PRICE,
            COLUMN_TOTAL_PRICE,
            COLUMN_ID_ORDER,
            COLUMN_ID_ORDER,
            COLUMN_ID_ORDER,
            COLUMN_PHONE,
            COLUMN_ADDRESS,
            COLUMN_FULL_NAME,
            COLUMN_DATE_CREATED,
            COLUMN_STATUS
    );


    public List<OrderModel> selectAll();

    public OrderModel selectById(int idOrder);

    public List<OrderModel> selectByIdUser(int idUser);

    public boolean insert(OrderModel orderModel);

    public boolean update(OrderModel orderModel);

    public boolean updateStatus(int idOrder, int statusOrder);

    public boolean delete(OrderModel orderModel);
}
