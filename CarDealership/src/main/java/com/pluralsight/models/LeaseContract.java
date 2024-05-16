package com.pluralsight.models;

public class LeaseContract extends Contract{

    double expectedEndingPrice = getTotalPrice() / 2;
    final double LEASE_FEE = getTotalPrice() * .07;



    public LeaseContract(String date, String customerName, String customerEmail, Vehicle vehicleSold, double totalPrice, double monthlyPayment, double expectedEndingPrice) {
        super(date, customerName, customerEmail, vehicleSold, totalPrice, monthlyPayment);
        this.expectedEndingPrice = expectedEndingPrice;

    }

    @Override
    double getTotalPrice() {
        return expectedEndingPrice + LEASE_FEE;
    }

    @Override
    double getMonthlyPayment() {
        return (getTotalPrice()  * .04) / 36 ;
    }
}
