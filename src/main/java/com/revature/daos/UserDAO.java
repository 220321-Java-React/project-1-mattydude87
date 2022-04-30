package com.revature.daos;

import com.revature.models.Role;
import com.revature.models.User;
import com.revature.utils.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;

public class UserDAO implements UserDAOInterface {

    RoleDAO rDAO = new RoleDAO();

    public boolean login(String username, String password) {
        if (username.equals("user") && password.equals("password")) {
            return true;
        }
        return false;
    }

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

    public User getUserByID(int id) {
        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "select * from users where user_id = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                return new User(
                        rs.getInt("user_id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("email"),
                        null
                );

            }

        } catch (SQLException e) {
            System.out.println("something went wrong fetching this user by the ID!");
            e.printStackTrace();
        }

        return null;
    }
}
//swag