package com.pluralsight.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SalesContractTest {
    @Test
    public void get_Monthly_Payment_Of_New_Vehicle_Financed() {
        // assign
        Vehicle vehicle = new Vehicle(1, 2020, "Jeep", "Wrangler", "SUV", "red", 1000, 20000);
        SalesContract salesContract = new SalesContract("John Doe", "johndoe123@email.com", vehicle,true);
        double expectedMonthly = 983.37; // 20000 * 0.0425

        // act
        double actualMonthly = salesContract.getMonthlyPayment();

        // assert
        assertEquals(expectedMonthly, actualMonthly, 0.01, "Something wrong with calculation");
    }
    @Test
    public void get_Monthly_Payment_Of_New_Vehicle_NoFinanced() {
        // assign
        Vehicle vehicle = new Vehicle(1, 2020, "Jeep", "Wrangler", "SUV", "red", 1000, 20000);
        SalesContract salesContract = new SalesContract("John Doe", "johndoe123@email.com", vehicle,false);
        double expectedMonthly = 0; // Not financed

        // act
        double actualMonthly = salesContract.getMonthlyPayment();

        // assert
        assertEquals(expectedMonthly, actualMonthly, 0.1, "Something wrong with calculation");
    }
    @Test
    public void get_TotalPrice_Of_New_Vehicle_Financed() {
        // assign
        Vehicle vehicle = new Vehicle(1, 2020, "Jeep", "Wrangler", "SUV", "red", 1000, 20000);
        SalesContract salesContract = new SalesContract("John Doe", "johndoe123@email.com", vehicle,true);
        double expectedTotal = 47201.89 + 1595;

        // act
        double actualTotal = salesContract.getTotalPrice();

        // assert
        assertEquals(expectedTotal, actualTotal, 0.01, "Something wrong with calculation");
    }
    @Test
    public void get_TotalPrice_Of_New_Vehicle_NoFinanced() {
        // assign
        Vehicle vehicle = new Vehicle(1, 2020, "Jeep", "Wrangler", "SUV", "red", 1000, 20000);
        SalesContract salesContract = new SalesContract("John Doe", "johndoe123@email.com", vehicle,false);
        double expectedTotal = 21595;

        // act
        double actualTotal = salesContract.getTotalPrice();

        // assert
        assertEquals(expectedTotal, actualTotal, 0.1, "Something wrong with calculation");
    }
}