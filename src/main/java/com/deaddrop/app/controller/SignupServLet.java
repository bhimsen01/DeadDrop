package com.deaddrop.app.controller;

import com.deaddrop.app.dao.UserDAO;
import com.deaddrop.app.model.User;
import com.deaddrop.app.util.PasswordUtil;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

@WebServlet("/signup")
public class SignupServLet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/signup.jsp");
        rd.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fName = req.getParameter("fname");
        String lName = req.getParameter("lname");
        String userName=req.getParameter("username");
        String password=req.getParameter("password");

        String hashedPassword= PasswordUtil.hashPassword(password);

        User user = new User(fName, lName, userName, hashedPassword);

        UserDAO userDAO = new UserDAO();

        try {
            if (userDAO.registerUser(user)) {
                resp.sendRedirect("login");
            }
        } catch (SQLException e) {
            if (e instanceof SQLIntegrityConstraintViolationException) {
                req.setAttribute("error", "Username already exists.");
                req.getRequestDispatcher("/WEB-INF/views/signup.jsp")
                        .forward(req, resp);
            } else {
                throw new ServletException(e);
            }
        }
    }
}
