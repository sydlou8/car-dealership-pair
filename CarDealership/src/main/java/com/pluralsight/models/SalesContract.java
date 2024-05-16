package com.pluralsight.models;

public class SalesContract extends Contract {
    // change to initializing in constructor
    private final double SALES_TAX;
    private final double RECORDING_FEE;
    private final double PROCESSING_FEE; // 295 for under 10k
    private boolean finance;
    private double monthlyPayment;

    SalesContract(String date, String customerName, String customerEmail, Vehicle  vehicleSold, double totalPrice, double monthlyPayment) {
        super(date, customerName, customerEmail, vehicleSold, totalPrice, monthlyPayment);
        this.SALES_TAX = 0.05;
        this.RECORDING_FEE = 100;
        this.PROCESSING_FEE = totalPrice < 10000? 295 : 495;
        this.monthlyPayment = monthlyPayment;
    }
    public double getSALES_TAX() {
        return SALES_TAX;
    }
    public double getRECORDING_FEE() {
        return RECORDING_FEE;
    }
    public double getPROCESSING_FEE() {
        return PROCESSING_FEE;
    }

    public boolean isFinance() {
        return finance;
    }
    public void setFinance(boolean finance) {
        this.finance = finance;
    }

    @Override
    public double getMonthlyPayment() {
        return monthlyPayment;
    }
    @Override
    public double getTotalPrice() {
        return monthlyPayment;
    }
    @Override
    public String toString() {
        return super.toString();
    }

}
