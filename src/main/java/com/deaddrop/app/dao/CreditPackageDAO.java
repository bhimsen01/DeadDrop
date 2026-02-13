package com.deaddrop.app.dao;

import com.deaddrop.app.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CreditPackageDAO {
    public int getCreditByPackageID(int packageId){
        String query="select credits from creditStore where package_id = ?;";

        int credit=0;
        try(Connection con= DBConnection.dbConnection();
            PreparedStatement ps=con.prepareStatement(query);){
            ps.setInt(1,packageId);

            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                credit=rs.getInt("credits");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return credit;
    }

    public boolean buyCredit(String userName, int packageId){
        String addCreditQuery="update users set credit=credit+? where userName=?;";

        try(Connection con=DBConnection.dbConnection();
        PreparedStatement ps=con.prepareStatement(addCreditQuery);){
            ps.setInt(1,getCreditByPackageID(packageId));
            ps.setString(2,userName);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
