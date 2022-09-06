package com.example.case3.service;

import com.example.case3.dao.StudentDAO;
import com.example.case3.model.Category;
import com.example.case3.model.Student;

import java.sql.SQLException;
import java.util.ArrayList;

public class StudentService {
    private final StudentDAO productDAO = new StudentDAO();

    public ArrayList<Student> getProducts() {
        return productDAO.getAllProduct();
    }
    public Student getProduct(int id) {
        return productDAO.getProduct(id);
    }

    public boolean createProduct(Student product, int id_category) {
        return productDAO.createProduct(product, id_category);
    }

    public boolean deleteProduct(int id) throws SQLException {
        return productDAO.deleteProduct(id);
    }

    public boolean editProduct(Student product, int id_category) throws SQLException {
        return productDAO.updateProduct(product, id_category);
    }

    public ArrayList<Category> getCategories() {
        return productDAO.getAllCategory();
    }
}
