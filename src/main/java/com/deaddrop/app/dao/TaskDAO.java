package com.deaddrop.app.dao;

import com.deaddrop.app.model.Task;
import com.deaddrop.app.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskDAO {
    public boolean addTask(Task task, String userName){
        String query="insert into tasks (title, description, image_path, credits, deadline, created_at, director) " +
                "values (?,?,?,?,?,?,?);";

        String creditCheck="select credit from users where userName=?;";

        String creditDeduct="update users set credit=credit-? where userName=?;";

        try(Connection con= DBConnection.dbConnection();){
            con.setAutoCommit(false);
            try(PreparedStatement ps= con.prepareStatement(creditCheck);){
                ps.setString(1,userName);
                ResultSet rs=ps.executeQuery();

                if(!rs.next() || rs.getInt("credit") < task.getCredits()){
                    con.rollback();
                    return false;
                }
            }
            try(PreparedStatement ps=con.prepareStatement(creditDeduct);){
                ps.setInt(1,task.getCredits());
                ps.setString(2,userName);
                ps.executeUpdate();
            }
            try(PreparedStatement ps=con.prepareStatement(query);){
                ps.setString(1,task.getTitle());
                ps.setString(2,task.getDescription());
                ps.setString(3,task.getImagePath());
                ps.setInt(4,task.getCredits());
                if (task.getDeadline() != null) {
                    ps.setDate(5, new java.sql.Date(task.getDeadline().getTime()));
                } else {
                    ps.setNull(5, java.sql.Types.DATE);
                }
                ps.setTimestamp(6,task.getCreatedAt());
                ps.setString(7, task.getDirector());
                ps.executeUpdate();
            }
            con.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

//    public boolean addTask(Task task){
//        String query="insert into tasks (title, description, image_path, credits, deadline, created_at, director) " +
//                "values (?,?,?,?,?,?,?);";
//
//        try(Connection con= DBConnection.dbConnection();
//            PreparedStatement ps = con.prepareStatement(query);){
//            ps.setString(1,task.getTitle());
//            ps.setString(2,task.getDescription());
//            ps.setString(3,task.getImagePath());
//            ps.setInt(4,task.getCredits());
//            if (task.getDeadline() != null) {
//                ps.setDate(5, new java.sql.Date(task.getDeadline().getTime()));
//            } else {
//                ps.setNull(5, java.sql.Types.DATE);
//            }
//            ps.setTimestamp(6,task.getCreatedAt());
//            ps.setString(7, task.getDirector());
//
//            return ps.executeUpdate() >0;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//    }

    public List<Task> getTaskByStatus(String status){
        List<Task> tasks = new ArrayList<>();

        String query="select task_id, title, description, image_path, credits, deadline, created_at, director from tasks where status=? ORDER BY created_at DESC;";

        try(Connection con=DBConnection.dbConnection();
            PreparedStatement ps=con.prepareStatement(query);){
            ps.setString(1,"open");
            ResultSet rs=ps.executeQuery();

            while (rs.next()){
                Task task = new Task(
                    rs.getInt("task_id"),
                    rs.getString("title"),
                    rs.getString("description"),
                    rs.getString("image_path"),
                    rs.getInt("credits"),
                    rs.getDate("deadline"),
                    rs.getTimestamp("created_at"),
                    rs.getString("director")
                );
                tasks.add(task);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return tasks;
    }
}
