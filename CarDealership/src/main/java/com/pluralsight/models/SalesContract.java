package com.pluralsight.models;

public class SalesContract extends Contract {
    private final double SALES_TAX;
    private final double RECORDING_FEE;
    private final double PROCESSING_FEE; // 295 for under 10k
    private boolean finance;

    public SalesContract(String date, String customerName, String customerEmail, Vehicle vehicleSold, double totalPrice, double monthlyPayment, double SALES_TAX, double RECORDING_FEE, double PROCESSING_FEE, boolean finance) {
        super(date, customerName, customerEmail, vehicleSold, totalPrice, monthlyPayment);
        this.SALES_TAX = SALES_TAX;
        this.RECORDING_FEE = RECORDING_FEE;
        this.PROCESSING_FEE = PROCESSING_FEE;
        this.finance = finance;
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
        if(finance) {
            final double BELOW_10K_RATE = 0.0525;
            final double ABOVE_10K_RATE = 0.0425;
            final double PRICE = super.totalPrice;

            return PRICE > 10000 ? (PRICE * ABOVE_10K_RATE) : (PRICE * BELOW_10K_RATE);
        } else return 0;
    }
    @Override
    public double getTotalPrice() {
        final double BELOW_10K = 24;
        final double ABOVE_10K = 48;
        final double PRICE = super.totalPrice;

        return PRICE > 10000 ? this.getMonthlyPayment() * ABOVE_10K : this.getMonthlyPayment() * BELOW_10K;
    }
}
