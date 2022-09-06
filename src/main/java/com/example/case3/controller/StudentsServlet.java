package com.example.case3.controller;

import com.example.case3.model.Category;
import com.example.case3.model.Student;
import com.example.case3.service.StudentService;
import com.example.case3.validate.Validate;
import com.example.case3.validate.model.Product;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "ProductServlet", urlPatterns = "/product")
public class StudentsServlet extends HttpServlet {
    StudentService studentService = new StudentService();
    Validate validate = new Validate();
            ;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        action(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        action(request, response);
    }

    private void action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "createGet":
                    createGet(request, response);
                    break;
                case "createPost":
                    createPost(request,response);
                    break;
                case "editGet":
                    editGet(request, response);
                    break;
                case "editPost":
                    editPost(request, response);
                    break;
                case "delete":
                    delete(request, response);
                    break;
                case "searchByName":
                    searchByName(request, response);
                    break;
                default:
                    displayAllProduct(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void searchByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String search = request.getParameter("search");
        ArrayList<Student> students = studentService.getStudents();
        ArrayList<Student> productsOfSearch = new ArrayList<>();
        for (Student student : students) {
            if (validate.validateNameStudent(search, student.getName())) {
                studentsOfSearch.add(student);
            }
        }
        request.setAttribute("students", studentsOfSearch);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view.jsp");
        requestDispatcher.forward(request, response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String name = Integer.parseInt(request.getParameter("name"));
        studentService.deleteProduct(name);
        displayAllProduct(request, response);
    }

    private void editPost(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone =request.getParameter("phone");
        String address = request.getParameter("address");
        String Class =request.getParameter("class");
        Student student = new Student(name,email,phone,address,Class);
        boolean check = studentService.editProduct(student,id_category);
        request.setAttribute("check", check);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("edit_student.jsp");
        requestDispatcher.forward(request, response);
    }

    private void editGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int name = Integer.parseInt(request.getParameter("name"));
        Student studentEdit = studentService.getCategories();
        ArrayList<Category> categories = studentService.getCategories();
        int id_category = -1;
        for (Category category : categories) {
            if (category.getName_category().equals(studentEdit.getCategory())) {
                id_category = category.getId_category();
            }
        }
        request.setAttribute("id_category", id_category);
        request.setAttribute("studentEdit", studentEdit);
        request.setAttribute("categories", categories);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("edit_student.jsp");
        requestDispatcher.forward(request, response);
    }

    private void createPost(HttpServletRequest request, HttpServletResponse response, Student product) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone =request.getParameter("phone");
        String address = request.getParameter("address");
        String Class =request.getParameter("class");
        Student student = new Student(name,email,phone,address,Class);
        boolean check = studentService.editProduct(student,id_category);
        request.setAttribute("check", check);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("create_student.jsp");
        requestDispatcher.forward(request, response);
    }

    private void createGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Category> categories = productService.getCategories();
        request.setAttribute("categories", categories);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("create_student.jsp");
        requestDispatcher.forward(request, response);
    }

    private void displayAllProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Student> students = studentService.getStudents();
        request.setAttribute("students", students);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view.jsp");
        requestDispatcher.forward(request, response);
    }
}
