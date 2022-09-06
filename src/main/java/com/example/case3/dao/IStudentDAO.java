package com.example.case3.dao;

import com.example.case3.model.Category;
import com.example.case3.model.Student;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IStudentDAO {
    ArrayList<Student> getAllProduct();

    ArrayList<Category> getAllCategory();

    Student getProduct(int id);

    boolean createProduct(Student product, int id_category);

    boolean deleteProduct(int id) throws SQLException;

    boolean updateProduct(Student product, int id_category) throws SQLException;
}
