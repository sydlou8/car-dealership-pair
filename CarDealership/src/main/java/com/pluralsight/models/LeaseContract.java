package com.pluralsight.models;

public class LeaseContract extends Contract{

    double expectedEndingPrice;
    final double LEASE_FEE;

    //final double LEASE_RATE = 0.07;

    public LeaseContract( String customerName, String customerEmail, Vehicle vehicleSold) {
        super(customerName, customerEmail, vehicleSold);
        this.expectedEndingPrice = super.totalPrice / 2;
        this.LEASE_FEE = super.totalPrice * 0.07;
    }

    public double getExpectedEndingPrice() {
        return expectedEndingPrice;
    }
    public void setExpectedEndingPrice(double expectedEndingPrice) {
        this.expectedEndingPrice = expectedEndingPrice;
    }

    public double getLEASE_FEE() {
        return LEASE_FEE;
    }

    @Override
    public double getTotalPrice() {
        double LEASE_TERM_TOTAL = this.getMonthlyPayment() * 36;
        return LEASE_TERM_TOTAL + LEASE_FEE;
    }

    @Override
    public double getMonthlyPayment() {
        final double RATE = 0.04;
        final double MONTHS = 36;
        final double PRICE = super.totalPrice;
        return emi_calculator(PRICE, RATE, MONTHS);
    }
}
