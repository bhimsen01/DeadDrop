package com.deaddrop.app.controller;

import com.deaddrop.app.dao.ExecutedTaskDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/taskAction")
public class TaskActionServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session= req.getSession(false);
        int taskId=Integer.parseInt(req.getParameter("taskId"));
        String userName=(String) session.getAttribute("userName");


        ExecutedTaskDAO executedTaskDAO=new ExecutedTaskDAO();
        boolean success = executedTaskDAO.addOngoingTask(taskId, userName);

        if(success){
            resp.sendRedirect("homepage");
        } else {
            resp.sendRedirect("homepage?error=taskExecutionFailed");
        }
    }
}
