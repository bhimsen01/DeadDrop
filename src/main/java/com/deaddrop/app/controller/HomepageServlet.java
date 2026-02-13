package com.deaddrop.app.controller;

import com.deaddrop.app.dao.TaskDAO;
import com.deaddrop.app.model.Task;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/homepage")
public class HomepageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TaskDAO taskDAO=new TaskDAO();
        List<Task> tasks=taskDAO.getTaskByStatus("open");

        req.setAttribute("tasks",tasks);

        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/homepage.jsp");
        rd.forward(req,resp);
    }
}
