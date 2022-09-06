package com.example.case3.dao;

import com.example.case3.model.Category;
import com.example.case3.model.Student;

import java.sql.SQLException;
import java.util.ArrayList;

public class StudentDAO implements IStudentDAO {

    @Override
    public ArrayList<Student> getAllProduct() {
        return null;
    }

    @Override
    public ArrayList<Category> getAllCategory() {
        return null;
    }

    @Override
    public Student getProduct(int id) {
        return null;
    }

    @Override
    public boolean createProduct(Student product, int id_category) {
        return false;
    }

    @Override
    public boolean deleteProduct(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean updateProduct(Student product, int id_category) throws SQLException {
        return false;
    }
}
