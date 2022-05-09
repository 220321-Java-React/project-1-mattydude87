package com.revature.daos;

import com.revature.models.Reimb_status;
import com.revature.models.Reimb_type;
import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ReimbursementDAO {

    Reimb_statusDAO ersDAO = new Reimb_statusDAO();
    Reimb_typeDAO ertDAO = new Reimb_typeDAO();
    UserDAO uDAO = new UserDAO();


    public ArrayList<Reimbursement> getReimbursements () {
        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "select * from reimbursement;";
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(sql);
            ArrayList<Reimbursement> allReimb = new ArrayList<>();
            while(rs.next()) {
                Reimbursement reimb = new Reimbursement (
                        rs.getInt("reimb_id"),
                        rs.getInt("amount"),
                        rs.getTimestamp("date_submitted"),
                        rs.getTimestamp("date_resolved"),
                        rs.getString("description"),
                        null,
                        null,
                        null,
                        null
                );
                int AuthorFK = rs.getInt("author_fk");
                User ur = uDAO.getUserByID(AuthorFK);
                reimb.setAuthor_fk(ur);
              //  allReimb.add(reimb);

                int Resolver = rs.getInt("resolver_fk");
                User ur2 = uDAO.getUserByID(Resolver);
                reimb.setResolver_fk(ur2);
                //allReimb.add(reimb);

                int Status = rs.getInt("status_id_fk");
                Reimb_status rS = ersDAO.getStatusByID(Status);
                reimb.setStatus_id_fk(rS);
               // allReimb.add(reimb);

                int Type = rs.getInt("reimb_type_id_fk");
                Reimb_type rT = ertDAO.getTypeByID(Type);
                reimb.setType_id_fk(rT);
                allReimb.add(reimb);
            }
            return allReimb;
        } catch (SQLException e) {
            System.out.println("Get all reimbursements has failed");
        }
        return null;
    }
    public ArrayList<Reimbursement> getReimbursementRequests () {
        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "select * from reimbursement where status_id_fk = 1;";
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(sql);
            ArrayList<Reimbursement> reimbRequests = new ArrayList<>();
            while(rs.next()) {
                Reimbursement reimbReq = new Reimbursement (
                        rs.getInt("reimb_id"),
                        rs.getInt("amount"),
                        rs.getTimestamp("date_submitted"),
                        rs.getTimestamp("date_resolved"),
                        rs.getString("description"),
                        null,
                        null,
                        null,
                        null
                );
                int AuthorFK = rs.getInt("author_fk");
                User ur = uDAO.getUserByID(AuthorFK);
                reimbReq.setAuthor_fk(ur);
                //reimbRequests.add(reimbReq);

                int Resolver = rs.getInt("resolver_fk");
                User ur2 = uDAO.getUserByID(Resolver);
                reimbReq.setResolver_fk(ur2);
                //reimbRequests.add(reimbReq);

                int Status = rs.getInt("status_id_fk");
                Reimb_status rS = ersDAO.getStatusByID(Status);
                reimbReq.setStatus_id_fk(rS);
                //reimbRequests.add(reimbReq);

                int Type = rs.getInt("reimb_type_id_fk");
                Reimb_type rT = ertDAO.getTypeByID(Type);
                reimbReq.setType_id_fk(rT);

                reimbRequests.add(reimbReq);
            }
            return reimbRequests;
        } catch (SQLException e) {
            System.out.println("Get all reimbursement requests has failed");
        }
        return null;
    }
}
