package com.deaddrop.app.dao;

import com.deaddrop.app.model.ExecutedTask;
import com.deaddrop.app.model.Task;
import com.deaddrop.app.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ExecutedTaskDAO {
    public boolean addOngoingTask(int taskID, String userName){
        String query="insert into executedtasks (task_id, userName) values (?,?);";

        try(Connection con= DBConnection.dbConnection();
            PreparedStatement ps=con.prepareStatement(query);){
            ps.setInt(1,taskID);
            ps.setString(2,userName);

            return ps.executeUpdate()>0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<ExecutedTask> getExecutedTaskByUserName(String userName){
        List<ExecutedTask> executedTasks= new ArrayList<>();

        String query="select et.id AS executed_id, et.started_at, et.userName, t.task_id, t.title, t.credits, t.deadline, t.image_path, t.description, t.director, t.created_at, t.status" +
                " from executedtasks et" +
                " join tasks t ON et.task_id=t.task_id where et.userName=? ORDER BY started_at DESC;";

        try(Connection con=DBConnection.dbConnection();
            PreparedStatement ps=con.prepareStatement(query);){
            ps.setString(1,userName);

            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                ExecutedTask executedTask=new ExecutedTask(
                        rs.getInt("executed_id"),
                        rs.getInt("task_id"),
                        rs.getString("userName"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getInt("credits"),
                        rs.getDate("deadline"),
                        rs.getString("image_path"),
                        rs.getString("director"),
                        rs.getTimestamp("created_at"),
                        rs.getTimestamp("started_at")
                );
                executedTasks.add(executedTask);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return executedTasks;
    }

    public boolean deleteExecutedtask(int id, String userName){
        String query="delete from executedtasks where id=? and userName=?;";

        try(Connection con=DBConnection.dbConnection();
            PreparedStatement ps=con.prepareStatement(query);){
            ps.setInt(1,id);
            ps.setString(2,userName);

            return ps.executeUpdate() >0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
