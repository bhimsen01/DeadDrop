package com.deaddrop.app.controller;

import com.deaddrop.app.dao.ExecutedTaskDAO;
import com.deaddrop.app.model.ExecutedTask;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/inProgress")
public class ExecutedTaskServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session= req.getSession(false);
        ExecutedTaskDAO executedTaskDAO = new ExecutedTaskDAO();
        List<ExecutedTask> executedTasks = executedTaskDAO.getExecutedTaskByUserName((String) session.getAttribute("userName"));
        req.setAttribute("executedTasks", executedTasks);

        RequestDispatcher rd= req.getRequestDispatcher("/WEB-INF/views/inProgress.jsp");
        rd.forward(req,resp);
    }
}
