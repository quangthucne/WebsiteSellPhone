package com.poly.websitesellphone.DAO;

import com.poly.websitesellphone.Service.ProductInterface;
import com.poly.websitesellphone.model.ImageModel;
import com.poly.websitesellphone.model.ProductModel;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO extends DataDAO implements ProductInterface {
    // query all
    @Override
    public List<ProductModel> selectAll() {
        List<ProductModel> list = new ArrayList<>();
        List<ImageModel> images = new ArrayList<>();
        try {
            Connection con = getConnection();
            ResultSet rs = query(PRODUCT_SELECT_ALL);
            while (rs.next()){
                //info SQl
                int idProduct = rs.getInt(COLUMN_ID_PRODUCT);
                int idCategory = rs.getInt(COLUMN_ID_CATEGORY);
                int idImage = rs.getInt(COLUMN_ID_IMAGE);
                String nameCategory = rs.getString(COLUMN_NAME_CATEGORY);
                String nameImage = rs.getString(COLUMN_NAME_IMAGE);
                String name = rs.getString(COLUMN_NAME);
                String shortDesc = rs.getString(COLUMN_SHORT_DESC);
                String detail = rs.getString(COLUMN_DETAIL);
                int quantity = rs.getInt(COLUMN_QUANTITY);
                double price = rs.getDouble(COLUMN_PRICE);
                Date dateCreated = rs.getDate(COLUMN_DATE_CREATED);
                int status = rs.getInt(COLUMN_STATUS);
                //img
                ImageModel imageModel = new ImageModel(idImage, idProduct, nameImage);
                images.add(imageModel);
                list.add(new ProductModel(idProduct, idCategory, name, shortDesc, detail, quantity, price, dateCreated, status, images));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public ProductModel selectById(int id) {
        ProductModel productModel = null;
        try {
            Connection con = getConnection();
            ResultSet rs = query(PRODUCT_SELECT_BY_ID, id);
            while (rs.next()){
                int idCategory = rs.getInt(COLUMN_ID_CATEGORY);
                String name = rs.getString(COLUMN_NAME);
                String shortDesc = rs.getString(COLUMN_SHORT_DESC);
                String detail = rs.getString(COLUMN_DETAIL);
                int quantity = rs.getInt(COLUMN_QUANTITY);
                double price = rs.getDouble(COLUMN_PRICE);
                Date dateCreated = rs.getDate(COLUMN_DATE_CREATED);
                int status = rs.getInt(COLUMN_STATUS);
                ImageDAO imageDAO = new ImageDAO();
                List<ImageModel> images = imageDAO.selectByProductId(id);
                productModel = new ProductModel(id, idCategory, name, shortDesc, detail, quantity, price, dateCreated, status, images);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return productModel;
    }

    @Override
    public boolean insert(ProductModel productModel) {
        boolean rs = false;
        try {
            Connection con = getConnection();
            update(PRODUCT_INSERT,
                    productModel.getIdCategory(),
                    productModel.getName(),
                    productModel.getShortDesc(),
                    productModel.getDetail(),
                    productModel.getQuantity(),
                    productModel.getPrice(),
                    productModel.getDateCreate(),
                    productModel.getStatus()
            );
            rs = true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return rs;
    }

    @Override
    public boolean update(ProductModel productModel) {
        boolean rs = false;
        try {
            Connection con = getConnection();
            update(PRODUCT_UPDATE,
                    productModel.getIdCategory(),
                    productModel.getName(),
                    productModel.getShortDesc(),
                    productModel.getDetail(),
                    productModel.getQuantity(),
                    productModel.getPrice(),
                    productModel.getDateCreate(),
                    productModel.getStatus(),
                    productModel.getIdProduct()
            );
            rs = true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return rs;
    }

    @Override
    public boolean delete(int id) {
        boolean rs = false;
        try {
            Connection con = getConnection();
            update(PRODUCT_DELETE, id);
            rs = true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return rs;
    }
}
