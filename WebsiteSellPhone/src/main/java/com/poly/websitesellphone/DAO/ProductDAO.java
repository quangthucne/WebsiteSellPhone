package com.poly.websitesellphone.DAO;


import com.poly.websitesellphone.Service.ProductInterface;
import com.poly.websitesellphone.model.ImageModel;
import com.poly.websitesellphone.model.ProductModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO extends DataDAO implements ProductInterface {
    // query all
    @Override
    public List<ProductModel> selectAll() {
        List<ProductModel> list = new ArrayList<>();
        try {
            Connection con = getConnection();

            ResultSet rs = query(PRODUCT_SELECT_ALL);
            while (rs.next()) {
                //info SQl
                int idProduct = rs.getInt(COLUMN_ID_PRODUCT);
                int idCategory = rs.getInt(COLUMN_ID_CATEGORY);
                String nameCategory = rs.getString(COLUMN_NAME_CATEGORY);
                String nameImage = rs.getString(COLUMN_NAME_IMAGE);
                String name = rs.getString(COLUMN_NAME);
                String shortDesc = rs.getString(COLUMN_SHORT_DESC);
                String detail = rs.getString(COLUMN_DETAIL);
                int quantity = rs.getInt(COLUMN_QUANTITY);
                int price = rs.getInt(COLUMN_PRICE);
                java.sql.Date dateCreated = rs.getDate(COLUMN_DATE_CREATED);
                int status = rs.getInt(COLUMN_STATUS);
                //img
                ImageModel imageModel = new ImageModel(idProduct, nameImage);
                list.add(new ProductModel(idProduct, idCategory, name, shortDesc, detail, quantity, price, dateCreated, status, imageModel));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public List<ProductModel> selectAllByStatus() {
        List<ProductModel> list = new ArrayList<>();
        try {
            Connection con = getConnection();

            ResultSet rs = query(PRODUCT_SELECT_ALL_BY_STATUS);
            while (rs.next()) {
                //info SQl
                int idProduct = rs.getInt(COLUMN_ID_PRODUCT);
                int idCategory = rs.getInt(COLUMN_ID_CATEGORY);
                String nameCategory = rs.getString(COLUMN_NAME_CATEGORY);
                String nameImage = rs.getString(COLUMN_NAME_IMAGE);
                String name = rs.getString(COLUMN_NAME);
                String shortDesc = rs.getString(COLUMN_SHORT_DESC);
                String detail = rs.getString(COLUMN_DETAIL);
                int quantity = rs.getInt(COLUMN_QUANTITY);
                int price = rs.getInt(COLUMN_PRICE);
                java.sql.Date dateCreated = rs.getDate(COLUMN_DATE_CREATED);
                int status = rs.getInt(COLUMN_STATUS);
                //img
                ImageModel imageModel = new ImageModel(idProduct, nameImage);
                list.add(new ProductModel(idProduct, idCategory, name, shortDesc, detail, quantity, price, dateCreated, status, imageModel));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public List<ProductModel> selectAllSearch(String name) {
        List<ProductModel> list = new ArrayList<>();
        try {
            Connection con = getConnection();

            ResultSet rs = query(PRODUCT_SELECT_ALL_BY_STATUS_SEARCH, name);
            while (rs.next()) {
                //info SQl
                int idProduct = rs.getInt(COLUMN_ID_PRODUCT);
                int idCategory = rs.getInt(COLUMN_ID_CATEGORY);
                String nameCategory = rs.getString(COLUMN_NAME_CATEGORY);
                String nameImage = rs.getString(COLUMN_NAME_IMAGE);
                String nameProduct = rs.getString(COLUMN_NAME);
                String shortDesc = rs.getString(COLUMN_SHORT_DESC);
                String detail = rs.getString(COLUMN_DETAIL);
                int quantity = rs.getInt(COLUMN_QUANTITY);
                int price = rs.getInt(COLUMN_PRICE);
                java.sql.Date dateCreated = rs.getDate(COLUMN_DATE_CREATED);
                int status = rs.getInt(COLUMN_STATUS);
                //img
                ImageModel imageModel = new ImageModel(idProduct, nameImage);
                list.add(new ProductModel(idProduct, idCategory, nameProduct, shortDesc, detail, quantity, price, dateCreated, status, imageModel));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public List<ProductModel> selectAllCategory(int idCategory) {
        List<ProductModel> list = new ArrayList<>();
        try {
            Connection con = getConnection();

            ResultSet rs = query(PRODUCT_SELECT_ALL_BY_ID_CATEGORY, idCategory);
            while (rs.next()) {
                //info SQl
                int idProduct = rs.getInt(COLUMN_ID_PRODUCT);
                String nameCategory = rs.getString(COLUMN_NAME_CATEGORY);
                String nameImage = rs.getString(COLUMN_NAME_IMAGE);
                String nameProduct = rs.getString(COLUMN_NAME);
                String shortDesc = rs.getString(COLUMN_SHORT_DESC);
                String detail = rs.getString(COLUMN_DETAIL);
                int quantity = rs.getInt(COLUMN_QUANTITY);
                int price = rs.getInt(COLUMN_PRICE);
                java.sql.Date dateCreated = rs.getDate(COLUMN_DATE_CREATED);
                int status = rs.getInt(COLUMN_STATUS);
                //img
                ImageModel imageModel = new ImageModel(idProduct, nameImage);
                list.add(new ProductModel(idProduct, idCategory, nameProduct, shortDesc, detail, quantity, price, dateCreated, status, imageModel));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public ProductModel selectAllByIdCartDetail(int idCartDetail) {
        ProductModel productModel = null;
        try {
            Connection con = getConnection();

            ResultSet rs = query(PRODUCT_SELECT_ALL_BY_ID_CART_DETAIL, idCartDetail);
            while (rs.next()) {
                //info SQl
                int idProduct = rs.getInt(COLUMN_ID_PRODUCT);
                int idCategory = rs.getInt(COLUMN_ID_CATEGORY);
                String nameCategory = rs.getString(COLUMN_NAME_CATEGORY);
                String nameImage = rs.getString(COLUMN_NAME_IMAGE);
                String name = rs.getString(COLUMN_NAME);
                String shortDesc = rs.getString(COLUMN_SHORT_DESC);
                String detail = rs.getString(COLUMN_DETAIL);
                int quantity = rs.getInt(COLUMN_QUANTITY);
                int price = rs.getInt(COLUMN_PRICE);
                java.sql.Date dateCreated = rs.getDate(COLUMN_DATE_CREATED);
                int status = rs.getInt(COLUMN_STATUS);
                //img
                ImageModel imageModel = new ImageModel(idProduct, nameImage);
                productModel = new ProductModel(idProduct, idCategory, name, shortDesc, detail, quantity, price, dateCreated, status, imageModel);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return productModel;
    }

    @Override
    public List<ProductModel> selectAllByIdCart(int idCart) {
        List<ProductModel> list = new ArrayList<>();
        try {
            Connection con = getConnection();
            System.out.println(PRODUCT_SELECT_ALL_BY_ID_CART);
            ResultSet rs = query(PRODUCT_SELECT_ALL_BY_ID_CART, idCart);
            while (rs.next()) {
                //info SQl
                int idProduct = rs.getInt(COLUMN_ID_PRODUCT);
                int idCategory = rs.getInt(COLUMN_ID_CATEGORY);
                String nameCategory = rs.getString(COLUMN_NAME_CATEGORY);
                String nameImage = rs.getString(COLUMN_NAME_IMAGE);
                String name = rs.getString(COLUMN_NAME);
                String shortDesc = rs.getString(COLUMN_SHORT_DESC);
                String detail = rs.getString(COLUMN_DETAIL);
                int quantity = rs.getInt(COLUMN_QUANTITY);
                int price = rs.getInt(COLUMN_PRICE);
                java.sql.Date dateCreated = rs.getDate(COLUMN_DATE_CREATED);
                int status = rs.getInt(COLUMN_STATUS);
                //img
                ImageModel imageModel = new ImageModel(idProduct, nameImage);
                list.add(new ProductModel(idProduct, idCategory, name, shortDesc, detail, quantity, price, dateCreated, status, imageModel));

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
            while (rs.next()) {
                int idCategory = rs.getInt(COLUMN_ID_CATEGORY);
                String name = rs.getString(COLUMN_NAME);
                String shortDesc = rs.getString(COLUMN_SHORT_DESC);
                String detail = rs.getString(COLUMN_DETAIL);
                int quantity = rs.getInt(COLUMN_QUANTITY);
                int price = rs.getInt(COLUMN_PRICE);
                java.sql.Date dateCreated = rs.getDate(COLUMN_DATE_CREATED);
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

    public ProductModel selectId(int id) {
        ProductModel productModel = null;
        try {
            Connection con = getConnection();
            ResultSet rs = query(PRODUCT_SELECT_BY_ID_2, id);
            while (rs.next()) {
                int idCategory = rs.getInt(COLUMN_ID_CATEGORY);
                String name = rs.getString(COLUMN_NAME);
                String shortDesc = rs.getString(COLUMN_SHORT_DESC);
                String detail = rs.getString(COLUMN_DETAIL);
                int quantity = rs.getInt(COLUMN_QUANTITY);
                int price = rs.getInt(COLUMN_PRICE);
                java.sql.Date dateCreated = rs.getDate(COLUMN_DATE_CREATED);
                int status = rs.getInt(COLUMN_STATUS);
                String nameImage = rs.getString("name_image");
                productModel = new ProductModel(id, idCategory, name, shortDesc, detail, quantity, price, dateCreated, status, nameImage);

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return productModel;
    }

    @Override
    public int insert(ProductModel productModel) {
        int generatedID = -1;
        try {
            Connection con = getConnection();
            PreparedStatement statement = getConnection().prepareStatement(PRODUCT_INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setInt(1, productModel.getIdCategory());
            statement.setString(2, productModel.getName());
            statement.setString(3, productModel.getShortDesc());
            statement.setString(4, productModel.getDetail());
            statement.setInt(5, productModel.getQuantity());
            statement.setInt(6, productModel.getPrice());
            statement.setInt(7, productModel.getStatus());

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                ResultSet rs = statement.getGeneratedKeys();
                if (rs.next()) {
                    generatedID = rs.getInt(1);
                }
                rs.close();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return generatedID;
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
                    productModel.getPrice(),
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
    public boolean updateQuantity(int quantity, String nameProduct) {
        boolean rs = false;
        try {
            Connection con = getConnection();
            update(PRODUCT_UPDATE_QUANTITY, quantity, nameProduct);
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

    @Override
    public List<ProductModel> selectByName(String name) {
        List<ProductModel> list = new ArrayList<>();
        try {
            Connection con = getConnection();
            System.out.println(query(PRODUCT_SELECT_BY_NAME, "%" + name + "%"));
            ResultSet rs = query(PRODUCT_SELECT_BY_NAME, "%" + name + "%");
            while (rs.next()) {
                int idProduct = rs.getInt(COLUMN_ID_PRODUCT);
                int idCategory = rs.getInt(COLUMN_ID_CATEGORY);
                String shortDesc = rs.getString(COLUMN_SHORT_DESC);
                String detail = rs.getString(COLUMN_DETAIL);
                int quantity = rs.getInt(COLUMN_QUANTITY);
                int price = rs.getInt(COLUMN_PRICE);
                Date dateCreated = rs.getDate(COLUMN_DATE_CREATED);
                int status = rs.getInt(COLUMN_STATUS);
                ImageDAO imageDAO = new ImageDAO();
                List<ImageModel> images = imageDAO.selectByProductId(idProduct);
                list.add(new ProductModel(idProduct, idCategory, name, shortDesc, detail, quantity, price, dateCreated, status, images));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}