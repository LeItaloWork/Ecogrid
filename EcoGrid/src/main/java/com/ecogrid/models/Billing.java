package com.ecogrid.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter

public class Billing {
    private int billingId;
    private Date billingDate;
    private double amount;
    private String status;

    public void markAsPaid() {
        this.status = "Paid";
    }

    public String generateInvoice() {
        return "Invoice generated for amount: " + amount;
    }

}
