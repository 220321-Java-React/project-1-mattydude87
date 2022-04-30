package com.revature.services;

import com.revature.daos.ReimbursementDAO;
import com.revature.models.Reimbursement;

import java.util.ArrayList;

public class ReimbursementService {
    ReimbursementDAO rDAO = new ReimbursementDAO();

    public ArrayList<Reimbursement> getReimbursements(){
        ArrayList<Reimbursement> reimbursements = rDAO.getReimbursements();
        return reimbursements;
    }
}
