package com.poly.websitesellphone.controller;


import com.poly.websitesellphone.DAO.CategoryDAO;
import com.poly.websitesellphone.DAO.DataDAO;
import com.poly.websitesellphone.DAO.ImageDAO;
import com.poly.websitesellphone.DAO.ProductDAO;
import com.poly.websitesellphone.model.CategoryModel;
import com.poly.websitesellphone.model.ImageModel;
import com.poly.websitesellphone.model.ProductModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@MultipartConfig()
@WebServlet("/product-manage")
public class ProductManageController extends HttpServlet {
    private static final java.lang.String UPLOAD_DIR = "assets/img";

    public static List<ProductModel> getAllProduct() {
        ProductDAO productDAO = new ProductDAO();
        List<ProductModel> list = productDAO.selectAll();
        return list;
    }

    public static List<java.lang.String> saveMultipleImagesProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        java.lang.String applicationPath = req.getServletContext().getRealPath("");
        java.lang.String uploadPath = applicationPath + UPLOAD_DIR;
        File file = new File(uploadPath);
        if (!file.exists()) {
            file.mkdirs();
        }

        List<java.lang.String> fileNames = new ArrayList<>();
        Collection<Part> fileParts = req.getParts();

        for (Part part : fileParts) {
            if (part.getName().equals("image") && part.getSize() > 0) {
                Date date = new Date();
                java.lang.String fileNameDate = date.getTime() + ".jpg";
                java.lang.String fileName = Paths.get(fileNameDate).getFileName().toString();

                part.write(uploadPath + File.separator + fileName);
                fileNames.add(fileName);
                System.out.println(uploadPath + File.separator + fileName);
            }
        }

        return fileNames;
    }

    public static void addProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        java.lang.String productName = req.getParameter("productName");
        java.lang.String shortDesc = req.getParameter("shortDesc");
        java.lang.String detail = req.getParameter("detail");
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        int productPrice = Integer.parseInt(req.getParameter("productPrice"));
        int status = Integer.parseInt(req.getParameter("statusProduct"));
        int categoryId = Integer.parseInt(req.getParameter("productCategory"));
        int idProduct = -1;
        ProductDAO productDAO = new ProductDAO();
        ProductModel productModel = new ProductModel(categoryId, productName, shortDesc, detail, quantity, productPrice, status);
        List<java.lang.String> listNameImage = saveMultipleImagesProduct(req, resp);
        List<CategoryModel> listCategory = getAllCategory();


        boolean productNameCheck = checkProductUnique(productName);
        if (!productNameCheck) {
            productDAO.updateQuantity(quantity, productName);
        } else {
            idProduct = productDAO.insert(productModel);
            if (idProduct == -1) {
                req.setAttribute("message", "Thêm sản phẩm thất bại");
            } else {
                addImageProduct(req, resp, idProduct, listNameImage);
                req.setAttribute("message", "Thêm sản phẩm thành công");
            }
        }


        req.setAttribute("categoryList", listCategory);
        req.setAttribute("productList", productDAO.selectAll());

    }

    public static void addImageProduct(HttpServletRequest req, HttpServletResponse resp, int idProduct, List<java.lang.String> listNameImage) throws ServletException, IOException {
        ImageDAO imageDAO = new ImageDAO();
        ImageModel imageModel = new ImageModel();
        for (java.lang.String nameImgae : listNameImage) {
            imageModel = new ImageModel(idProduct, nameImgae);
            imageDAO.insert(imageModel);
        }
    }

    public static List<CategoryModel> getAllCategory() {
        CategoryDAO categoryDAO = new CategoryDAO();
        List<CategoryModel> list = categoryDAO.selectAll();
        return list;
    }

    public static void editProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idProduct = Integer.parseInt(req.getParameter("productId"));
        java.lang.String productName = req.getParameter("productName");
        java.lang.String shortDesc = req.getParameter("shortDesc");
        java.lang.String detail = req.getParameter("detail");
        int productPrice = Integer.parseInt(req.getParameter("productPrice"));
        int status = Integer.parseInt(req.getParameter("statusProduct"));
        int categoryId = Integer.parseInt(req.getParameter("productCategory"));
        List<java.lang.String> listNameImage = saveMultipleImagesProduct(req, resp);
        ProductDAO productDAO = new ProductDAO();
        ProductModel productModel = new ProductModel(idProduct, categoryId, productName, shortDesc, detail, productPrice, status);
        List<CategoryModel> listCategory = getAllCategory();

        if (listNameImage.size() == 0) {
            productDAO.update(productModel);
            req.setAttribute("categoryList", listCategory);
            req.setAttribute("productList", productDAO.selectAll());
        } else {
            deleteImageProduct(req, resp, idProduct);
            addImageProduct(req, resp, idProduct, listNameImage);
            productDAO.update(productModel);
            req.setAttribute("categoryList", listCategory);
            req.setAttribute("productList", productDAO.selectAll());

        }
    }

    public static void deleteImageProduct(HttpServletRequest req, HttpServletResponse resp, int idProduct) throws ServletException, IOException {
        ImageDAO imageDAO = new ImageDAO();
        imageDAO.deleteByProductId(idProduct);
    }

    public static void deleteProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idProduct = Integer.parseInt(req.getParameter("productId"));
        System.out.println(idProduct);
        ProductDAO productDAO = new ProductDAO();
        deleteImageProduct(req, resp, idProduct);

        productDAO.delete(idProduct);
        req.setAttribute("categoryList", getAllCategory());
        req.setAttribute("productList", productDAO.selectAll());
    }

    public static void searchProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        java.lang.String productName = req.getParameter("search");
        ProductDAO productDAO = new ProductDAO();
        List<ProductModel> list = productDAO.selectByName(productName);

        req.setAttribute("productList", list);
    }

    private static boolean checkProductUnique(java.lang.String nameProduct) {
        boolean isUnique = true;

        java.lang.String query = "SELECT COUNT(*) FROM product WHERE name_product = ?";
        try (Connection connection = DataDAO.getConnectionData();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, nameProduct);
            ResultSet rs = ps.executeQuery();

            if (rs.next() && rs.getInt(1) > 0) {
                isUnique = false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isUnique;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Cookie[] cookies = req.getCookies();
//        int role = -1;
//        int idUser;
//
//        if (cookies != null) {
//            for (Cookie cookie : cookies) {
//                if (cookie.getName().equals("roleUser")) {
//                    role = Integer.parseInt(cookie.getValue());
//
//                }
//                if (cookie.getName().equals("idUser")) {
//                    idUser = Integer.parseInt(cookie.getValue());
//                }
//            }
//            if (role != 1 ) {
//                resp.sendRedirect(req.getContextPath() + "");
//                return;
//            }
//        }
        List<ProductModel> list = getAllProduct();
        List<CategoryModel> categoryList = getAllCategory();
        req.setAttribute("categoryList", categoryList);
        req.setAttribute("productList", list);
        req.getRequestDispatcher("/views/jsp/Admin/ProductManage.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String typeActive = req.getParameter("typeActive");
        switch (typeActive) {
            case "add":
                addProduct(req, resp);
                break;
            case "edit":
                editProduct(req, resp);
                break;
            case "delete":
                deleteProduct(req, resp);
                break;
            case "search":
                break;
        }

        req.getRequestDispatcher("/views/jsp/Admin/ProductManage.jsp").forward(req, resp);
    }
}