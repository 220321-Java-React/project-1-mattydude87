package com.revature.daos;

import com.revature.models.Role;
import com.revature.models.User;
import com.revature.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UserDAO implements UserDAOInterface {

    RoleDAO rDAO = new RoleDAO();

    @Override
    public ArrayList<User> getUsers() {
        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "select * from users;";
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(sql);
            ArrayList<User> userList = new ArrayList<>();
            while (rs.next()) {
                User u = new User(
                        rs.getInt("user_id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("email"),
                        null);
                int roleFK = rs.getInt("role_id_fk");
                Role r = rDAO.getRoleById(roleFK);
                u.setRole(r);
                userList.add(u);
            }
            return userList;
        } catch (SQLException e) {
            System.out.println("Something went wrong selecting all users!");
            e.printStackTrace();
        }
        return null;
    }
}
//swag