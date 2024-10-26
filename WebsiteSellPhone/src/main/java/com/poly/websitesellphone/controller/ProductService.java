package com.poly.websitesellphone.controller;


import com.poly.websitesellphone.DAO.CategoryDAO;
import com.poly.websitesellphone.DAO.ProductDAO;
import com.poly.websitesellphone.model.CategoryModel;
import com.poly.websitesellphone.model.ProductModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/product/service")
public class ProductService extends HttpServlet {
    public static ProductModel getProductById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductModel productModel = new ProductModel();
        if (req.getParameter("id") == null) {
            productModel = null;
        } else {
            int id = Integer.parseInt(req.getParameter("id"));
            ProductDAO productDAO = new ProductDAO();
            productModel = productDAO.selectById(id);
        }
        return productModel;
    }

    public static List<CategoryModel> getAllCategory() {
        CategoryDAO categoryDAO = new CategoryDAO();
        List<CategoryModel> list = categoryDAO.selectAll();
        return list;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("product", getProductById(req, resp));
        req.setAttribute("categoryList", getAllCategory());
        req.getRequestDispatcher("/views/jsp/Admin/FormService/ProductService.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/jsp/Admin/FormService/ProductService.jsp").forward(req, resp);

    }
}
