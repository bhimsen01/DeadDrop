package com.deaddrop.app.controller;

import com.deaddrop.app.dao.TaskDAO;
import com.deaddrop.app.dao.UserDAO;
import com.deaddrop.app.model.Task;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import javax.management.remote.rmi.RMIConnection;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.sql.Date;
import java.sql.Timestamp;

@WebServlet("/addTask")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024,  // 1MB
        maxFileSize = 5 * 1024 * 1024,    // 5MB
        maxRequestSize = 20 * 1024 * 1024 // 20MB
)
public class TaskServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String title=req.getParameter("title");
//        String description=req.getParameter("description");
//        int credits= Integer.parseInt(req.getParameter("credits"));
//        String deadlineStr=req.getParameter("deadline");
//        Date deadline=null;
//        if(deadlineStr!=null && !deadlineStr.isEmpty()){
//            deadline=Date.valueOf(deadlineStr);
//        }
//        Part imagePart=req.getPart("image");
//        String imagePath=null;
//        if(imagePart!=null && imagePart.getSize()>0){
//            String fileName= Paths.get(imagePart.getSubmittedFileName()).getFileName().toString();
//            String uploadDir=getServletContext().getRealPath("/assets/uploads");
//
//            File dir= new File(uploadDir);
//            if (!dir.exists()){
//                dir.mkdirs();
//            }
//            imagePath="assets/uploads/"+fileName;
//            imagePart.write(uploadDir+File.separator+fileName);
//        }

        String title = readFormField(req, "title");
        String description = readFormField(req, "description");
        String creditsStr = readFormField(req, "credits");
        String deadlineStr = readFormField(req, "deadline");

        int credits;

        try {
            if (creditsStr == null || creditsStr.trim().isEmpty()) {
                throw new NumberFormatException();
            }

            credits = Integer.parseInt(creditsStr);

            if (credits <= 0) {
                throw new NumberFormatException();
            }

        } catch (NumberFormatException e) {
            resp.sendRedirect("homepage?error=Invalid credit amount");
            return;
        }

        // --- parse deadline safely ---
        Date deadline = null;
        if (deadlineStr != null && !deadlineStr.isEmpty()) {
            deadline = Date.valueOf(deadlineStr);
        }

        // --- handle file upload ---
        Part imagePart = req.getPart("image");
        String imagePath = null;
        if (imagePart != null && imagePart.getSize() > 0) {
            String fileName = Paths.get(imagePart.getSubmittedFileName()).getFileName().toString();
            String uploadDir = getServletContext().getRealPath("/assets/uploads");

            File dir = new File(uploadDir);
            if (!dir.exists()) dir.mkdirs();

            imagePath = "assets/uploads/" + fileName;
            imagePart.write(uploadDir + File.separator + fileName);
        }

        Timestamp createdAt = new Timestamp(System.currentTimeMillis());

        HttpSession session=req.getSession(false);
        String director= session.getAttribute("userName").toString();

        Task task= new Task(title, description, imagePath, credits, deadline, createdAt, director);

        TaskDAO taskDAO = new TaskDAO();
        if(taskDAO.addTask(task, director)){
            resp.sendRedirect("homepage");
        }
        else{
            resp.sendRedirect("homepage?error=Task creation failed.");
        }
    }

    private String readFormField(HttpServletRequest req, String fieldName) throws IOException, ServletException {
        Part part = req.getPart(fieldName);
        if (part != null) {
            return new String(part.getInputStream().readAllBytes(), StandardCharsets.UTF_8).trim();
        }
        return null;
    }
}
