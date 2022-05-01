package com.revature.controllers;

import com.google.gson.Gson;
import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.services.ReimbursementService;
import io.javalin.http.Handler;

import java.util.ArrayList;

public class ReimbursementController {

    ReimbursementService rService = new ReimbursementService();

    public Handler getReimbursementsHandler = (ctx) -> {
        ArrayList<Reimbursement> reimbursements = rService.getReimbursements();

        // create a gson object to convert our java object into JSON (since we can only transfer JSON, not java)
        Gson gson = new Gson();

        // using the gson.tojson () method to turn our java into JSON
        String JSONReimbursements = gson.toJson(reimbursements);

        ctx.result(JSONReimbursements);
        ctx.status(200);
    };
}