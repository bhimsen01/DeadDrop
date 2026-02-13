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
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/login.jsp");
        rd.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName=req.getParameter("username");
        String password=req.getParameter("password");

        UserDAO userDAO= new UserDAO();
        User user = userDAO.getUserByUsername(userName);

        if (user!=null && PasswordUtil.verifyPassword(user.getPassword(),password)){
            HttpSession session=req.getSession(true);
            session.setAttribute("userName",user.getUserName());
            session.setAttribute("firstName",user.getFirstName());

            resp.sendRedirect("homepage");
        }
        else{
            req.setAttribute("error","Invalid username or password.");
            req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req,resp);
        }
    }
}
