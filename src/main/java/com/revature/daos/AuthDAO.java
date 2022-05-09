package com.revature.daos;


import com.revature.models.*;
import com.revature.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AuthDAO {
    public User isValidUser (String username, String password) {
        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "select * from users where username= '" + username + "' and password= '" + password + "'";
            Statement s = conn.createStatement();
            System.out.println(sql);
            ResultSet rs = s.executeQuery(sql);

            if(rs.next()) {
                User curUser = new User(
                        rs.getInt("user_id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("email"),
                        null
                );
                int nrol = rs.getInt("role_id_fk");
                RoleDAO rDao = new RoleDAO();
                Role rol = rDao.getRoleById(nrol);
                curUser.setRole(rol);
                return curUser;
            }


        } catch (SQLException e) {
            System.out.println("check valid user is failed");
            e.printStackTrace();
        }
        return null;
    }



}
