package com.deaddrop.app.controller;

import com.deaddrop.app.dao.UserDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/credits")
public class CreditsPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession(false);
        UserDAO userDAO=new UserDAO();
        int credit=userDAO.getCreditByUsername((String) session.getAttribute("userName"));
        req.setAttribute("credit",credit);

        RequestDispatcher rd= req.getRequestDispatcher("/WEB-INF/views/creditsPage.jsp");
        rd.forward(req,resp);
    }
}
