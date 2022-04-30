package com.revature.daos;

import com.revature.models.Reimb_type;
import com.revature.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Reimb_typeDAO {

    public Reimb_type getTypeByID(int id) {
        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "select * from reimbursement_type where reimb_type_id = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new Reimb_type(
                        rs.getInt("reimb_type_id"),
                        rs.getString("reimb_type")
                );
            }
        } catch (SQLException e) {
            System.out.println("something went wrong fetching the type by ID");
            e.printStackTrace();
        }
        return null;
    }


}
