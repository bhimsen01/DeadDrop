package com.deaddrop.app.controller;

import com.deaddrop.app.dao.ExecutedTaskDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/executedTaskAction")
public class ExecutedTaskAction extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        int executedTaskId=Integer.parseInt(req.getParameter("executedTaskId"));
        String username=(String) session.getAttribute("userName");

        ExecutedTaskDAO executedTaskDAO= new ExecutedTaskDAO();
        boolean success = executedTaskDAO.deleteExecutedtask(executedTaskId, username);

        if (success){
            resp.sendRedirect("inProgress");
        } else{
            resp.sendRedirect("inProgress?error=unableToDelete");
        }
    }
}
