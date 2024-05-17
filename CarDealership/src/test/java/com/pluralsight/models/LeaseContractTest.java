package com.pluralsight.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeaseContractTest {
    @Test
    public void get_Monthly_Lease_Payment () {
        // assign
        Vehicle vehicle = new Vehicle(1, 2020, "Jeep", "Wrangler", "SUV", "red", 1000, 20000);
        LeaseContract leaseContract = new LeaseContract("John Doe","johndoe123@email.com", vehicle);
        double expectedMonthly = 1057.74;

        // act
        double actualMonthly = leaseContract.getMonthlyPayment();

        // assert
        assertEquals(expectedMonthly, actualMonthly, 0.01, "Error with calculations");
    }

    @Test
    public void get_Total_Lease_Payment () {
        // assign
        Vehicle vehicle = new Vehicle(1, 2020, "Jeep", "Wrangler", "SUV", "red", 1000, 20000);
        LeaseContract leaseContract = new LeaseContract("John Doe","johndoe123@email.com", vehicle);
        double expectedTotal = 38078.55 + 1400; // lease fee (0.07 * 20000) + (0.04 * 20000 * 36)/2

        // act
        double actualTotal = leaseContract.getTotalPrice();

        // assert
        assertEquals(expectedTotal, actualTotal, 0.01, "Error in calculations");
    }
}