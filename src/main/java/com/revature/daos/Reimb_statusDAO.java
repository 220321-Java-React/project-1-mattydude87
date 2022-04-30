package com.revature.daos;

import com.revature.models.Reimb_status;
import com.revature.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Reimb_statusDAO {


    public Reimb_status getStatusByID(int id) {
        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "select * from reimbursement_status where reimb_status_id = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new Reimb_status(
                        rs.getInt("reimb_status_id"),
                        rs.getString("reimb_status")
                );
            }
        } catch (SQLException e) {
            System.out.println("something went wrong fetching the reimbursement status by ID");
            e.printStackTrace();
        }
        return null;
    }

}
