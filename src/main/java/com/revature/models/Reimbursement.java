package com.revature.models;

import java.sql.Timestamp;

public class Reimbursement {
    private int reimb_id;
    private int amount;
    Timestamp date_submitted;
    Timestamp date_resolved;
    private String description;
    User author_fk;
    User resolver_fk;
    Reimb_status status_id_fk;
    Reimb_type type_id_fk;

    //no args
    public Reimbursement() {
    }
    //all args
    public Reimbursement(int reimb_id, int amount, Timestamp date_submitted, Timestamp date_resolved,
                         String description,
                         User author_fk,
                         User resolver_fk,
                         Reimb_status status_id_fk,
                         Reimb_type type_id_fk) {
        this.reimb_id = reimb_id;
        this.amount = amount;
        this.date_submitted = date_submitted;
        this.date_resolved = date_resolved;
        this.description = description;
        this.author_fk = author_fk;
        this.resolver_fk = resolver_fk;
        this.status_id_fk = status_id_fk;
        this.type_id_fk = type_id_fk;
    }
       //all args minus id
    public Reimbursement(int amount, Timestamp date_submitted,
                         Timestamp date_resolved, String description, User author_fk,
                         User resolver_fk,
                         Reimb_status status_id_fk, Reimb_type type_id_fk) {
        this.amount = amount;
        this.date_submitted = date_submitted;
        this.date_resolved = date_resolved;
        this.description = description;
        this.author_fk = author_fk;
        this.resolver_fk = resolver_fk;
        this.status_id_fk = status_id_fk;
        this.type_id_fk = type_id_fk;
    }

    @Override
    public String toString() {
        return "Reimbursement{" +
                "reimb_id=" + reimb_id +
                ", amount=" + amount +
                ", date_submitted=" + date_submitted +
                ", date_resolved=" + date_resolved +
                ", description='" + description + '\'' +
                ", author_fk=" + author_fk +
                ", resolver_fk=" + resolver_fk +
                ", status_id_fk=" + status_id_fk +
                ", type_id_fk=" + type_id_fk +
                '}';
    }

    public int getReimb_id() {
        return reimb_id;
    }

    public void setReimb_id(int reimb_id) {
        this.reimb_id = reimb_id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Timestamp getDate_submitted() {
        return date_submitted;
    }

    public void setDate_submitted(Timestamp date_submitted) {
        this.date_submitted = date_submitted;
    }

    public Timestamp getDate_resolved() {
        return date_resolved;
    }

    public void setDate_resolved(Timestamp date_resolved) {
        this.date_resolved = date_resolved;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getAuthor_fk() {
        return author_fk;
    }

    public void setAuthor_fk(User author_fk) {
        this.author_fk = author_fk;
    }

    public User getResolver_fk() {
        return resolver_fk;
    }

    public void setResolver_fk(User resolver_fk) {
        this.resolver_fk = resolver_fk;
    }

    public Reimb_status getStatus_id_fk() {
        return status_id_fk;
    }

    public void setStatus_id_fk(Reimb_status status_id_fk) {
        this.status_id_fk = status_id_fk;
    }

    public Reimb_type getType_id_fk() {
        return type_id_fk;
    }

    public void setType_id_fk(Reimb_type type_id_fk) {
        this.type_id_fk = type_id_fk;
    }
}
