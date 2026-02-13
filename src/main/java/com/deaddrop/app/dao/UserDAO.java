package com.deaddrop.app.dao;

import com.deaddrop.app.model.User;
import com.deaddrop.app.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    public boolean registerUser(User user) throws SQLException{
        String query="insert into users (firstName, lastName, userName, password) " +
                "values (?,?,?,?);";

        try(Connection con = DBConnection.dbConnection();
            PreparedStatement ps=con.prepareStatement(query);){
            ps.setString(1,user.getFirstName());
            ps.setString(2,user.getLastName());
            ps.setString(3, user.getUserName());
            ps.setString(4, user.getPassword());

            return ps.executeUpdate()>0;
        }
    }

    public User getUserByUsername(String userName){
        String query="select firstName, lastName, userName, password from users where userName=?;";

        try (Connection con= DBConnection.dbConnection();
             PreparedStatement ps= con.prepareStatement(query);){
            ps.setString(1,userName);
            ResultSet rs=ps.executeQuery();

            if (rs.next()){
                String fName=rs.getString("firstName");
                String lName=rs.getString("lastName");
                String usernameDB=rs.getString("username");
                String passwordDB=rs.getString("password");

                return new User(fName, lName, usernameDB, passwordDB);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return  null;
    }

    public int getCreditByUsername(String userName){
        String query="select credit from users where userName=?;";

        int credit=0;
        try(Connection con=DBConnection.dbConnection();
        PreparedStatement ps=con.prepareStatement(query);){
            ps.setString(1,userName);
            ResultSet rs=ps.executeQuery();
            if (rs.next()){
                credit= rs.getInt("credit");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return credit;
    }

    public boolean setCreditByUsername(int credit, String userName){
        String query="update users set credit=? where userName=?;";

        try(Connection con=DBConnection.dbConnection();
        PreparedStatement ps=con.prepareStatement(query);){
            ps.setInt(1,credit);
            ps.setString(2, userName);

            return ps.executeUpdate() >0;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
