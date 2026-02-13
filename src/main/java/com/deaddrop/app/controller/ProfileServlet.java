package com.deaddrop.app.controller;

import com.deaddrop.app.dao.UserDAO;
import com.deaddrop.app.model.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession(false);
        UserDAO userDAO=new UserDAO();
        User user=userDAO.getUserByUsername((String) session.getAttribute("userName"));
        String firstName=user.getFirstName();
        req.setAttribute("firstName", firstName);

        RequestDispatcher rd=req.getRequestDispatcher("/WEB-INF/views/profile.jsp");
        rd.forward(req,resp);
    }
}
