package com.pluralsight.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class Contract {
    String date;
    String customerName;
    String customerEmail;
    Vehicle vehicleSold;
    double totalPrice;
    double monthlyPayment;
    // <editor-fold desc=" Getters and Setters ">

    public Contract(String customerName, String customerEmail, Vehicle vehicleSold, double totalPrice,
                    double monthlyPayment){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.date = now.format(formatter);
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.vehicleSold = vehicleSold;
        this.totalPrice = totalPrice;
        this.monthlyPayment = monthlyPayment;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public Vehicle getVehicleSold() {
        return vehicleSold;
    }

    public void setVehicleSold(Vehicle vehicleSold) {
        this.vehicleSold = vehicleSold;
    }
    //</editor-fold>

    public abstract double getTotalPrice();

    public abstract double getMonthlyPayment();

}

