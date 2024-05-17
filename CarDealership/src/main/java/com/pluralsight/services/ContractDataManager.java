package com.pluralsight.services;

import com.pluralsight.models.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ContractDataManager {
    final String CONTRACT_FILE = "contracts.csv";
    final String DIRECTORY = "file";

    public void saveContract(Contract contract) {
        File file = new File(DIRECTORY + "/" + CONTRACT_FILE);
        try (PrintWriter writer = new PrintWriter(new FileWriter(file,true), true)) {
            // for each write
            /*
                Type = Sale or Lease
                contract date: year month day
                name: name of buyer
                email: email of buyer
                car id: car vin
                year: year of car
                make: make of car
                model: model of car
                vehicle type: type of car
                color: color of car
                odometer: odometer reading of car
                price: price of car
                sales tax: sales tax (5% of vehicle price)
                recording fee: always $100
                processing fee: $295 for vehicles under 10,000 $495 for all others
                total cost: price + sales tax + recording fee + processing fee
                finance: yes/no
                monthly payment: total cost is what is financed - 4.25% for 48 months (if over $10,000) or 5.25% for 24 months (if under)
             */
            String type;
            String finance;
            double salesTax;
            double processingFee;
            if(contract instanceof SalesContract) {
                type = "SALE";
                finance = ((SalesContract) contract).isFinance() ? "yes" : "no";
                salesTax = ((SalesContract) contract).getSALES_TAX();
                processingFee = ((SalesContract) contract).getPROCESSING_FEE();
            } else {
                type = "LEASE";
                finance = "no";
                salesTax = 0;
                processingFee = ((LeaseContract) contract).getLEASE_FEE();
            }
            Vehicle vehicleSold = contract.getVehicleSold();
            writer.printf("%s|%s|%s|%s|%d|%d|%s|%s|%s|%s|%d|%.2f|%.2f|100|%.0f|%.2f|%s|%.2f\n",
                    type,
                    contract.getDate(),
                    contract.getCustomerName(),
                    contract.getCustomerEmail(),
                    vehicleSold.getVin(),
                    vehicleSold.getYear(),
                    vehicleSold.getMake(),
                    vehicleSold.getModel(),
                    vehicleSold.getVehicleType(),
                    vehicleSold.getColor(),
                    vehicleSold.getOdometer(),
                    vehicleSold.getPrice(),
                    salesTax,
                    processingFee,
                    contract.getTotalPrice(),
                    finance,
                    contract.getMonthlyPayment()
            );
        } catch (IOException e) {
            System.out.println("ERROR: " + e);
        }
    }
}
