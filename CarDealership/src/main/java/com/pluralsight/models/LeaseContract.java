package com.pluralsight.models;

public class LeaseContract extends Contract{

    double expectedEndingPrice = getTotalPrice() / 2;
    final double LEASE_FEE = getTotalPrice() * .07;

    public LeaseContract( String customerName, String customerEmail, Vehicle vehicleSold) {
        super(customerName, customerEmail, vehicleSold);
        this.expectedEndingPrice = expectedEndingPrice;
    }

    @Override
    public double getTotalPrice() {
        return expectedEndingPrice + LEASE_FEE;
    }

    @Override
    public double getMonthlyPayment() {
        return (getTotalPrice()  * .04) / 36 ;
    }
}
