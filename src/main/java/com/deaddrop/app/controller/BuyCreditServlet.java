package com.deaddrop.app.controller;

import com.deaddrop.app.dao.CreditPackageDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/buyCredit")
public class BuyCreditServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int packageId=Integer.parseInt(req.getParameter("packageID"));

        HttpSession session=req.getSession(false);
        String userName=(String) session.getAttribute("userName");

        CreditPackageDAO creditPackageDAO=new CreditPackageDAO();
        if (creditPackageDAO.buyCredit(userName,packageId)){
            resp.sendRedirect("credits");
        } else{
            req.setAttribute("error","Credit purchase failed.");
            req.getRequestDispatcher("credits").forward(req,resp);
        }
    }
}
