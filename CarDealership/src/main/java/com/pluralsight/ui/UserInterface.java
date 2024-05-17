package com.pluralsight.ui;

import com.pluralsight.models.Dealership;
import com.pluralsight.models.Vehicle;
import com.pluralsight.services.DealershipFileManager;

import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;
    private Scanner userInput = new Scanner(System.in);
    public UserInterface() {}
    private void init() {
        DealershipFileManager dfm = new DealershipFileManager();
        dealership = dfm.getDealership();
    }
    private void publish() {
        DealershipFileManager dfm = new DealershipFileManager();
        dfm.saveDealership(dealership);
    }
    public void display() {
        init();
        while (true) {
        System.out.println("=".repeat(100));
        final String TITLE = String.format("Welcome to %s at %s\n", dealership.getName(), dealership.getAddress());
        System.out.printf(" ".repeat(17) + "%s", TITLE);
        System.out.println("=".repeat(100));
        System.out.println(
                "\t[1] - Find Vehicles within a Price Range\n" +
                "\t[2] - Find Vehicles by Make/Model\n" +
                "\t[3] - Find Vehicles by Year Range\n" +
                "\t[4] - Find Vehicles by Color\n" +
                "\t[5] - Find Vehicles by Mileage Range\n" +
                "\t[6] - Find Vehicles by Vehicle Type\n" +
                "\t[7] - List All Vehicles\n" +
                "\t[8] - Add a Vehicle\n" +
                "\t[9] - Remove a Vehicle\n" +
                "\t[0] - Add a new contract\n " + 
                "\t[99] - Quit"
        );

        System.out.print("Please make a selection: ");
        try {
            switch(Integer.parseInt(userInput.nextLine().strip())) {
                case 1:
                    processGetByPriceRequest();
                    break;
                case 2:
                    processGetByMakeModelRequest();
                    break;
                case 3:
                    processGetByYearRequest();
                    break;
                case 4:
                    processGetByColorRequest();
                    break;
                case 5:
                    processGetByMileageRequest();
                    break;
                case 6:
                    processGetByVehicleTypeRequest();
                    break;
                case 7:
                    processGetAllVehicleRequest();
                    break;
                case 8:
                    processAddVehicleRequest();
                    publish();
                    break;
                case 9:
                    processRemoveVehicleRequest();
                    publish();
                    break;
                case 0:
                    processContract();
                case 99:
                    System.out.println("All changes to dealership.csv has been saved.");
                    System.exit(0);
                default:
                    System.out.println("Please Enter a proper response: ");
                    break;
                }
            } catch (Exception _) {
                System.out.println("Please Enter a proper response: ");
            }
        }
    }

    private void processContract() {
        System.out.println("""
        Would you like to: 
         1.lease 
         2. buy a vehicle today? 
         """
        );
        try {
            int choice = Integer.parseInt(userInput.nextLine().strip());
            if(choice == 1){

            }
        } catch(Exception e){
            System.out.println("That key is invalid.");
        }

    }

    private void processLeaseContract(){
        
    }

    // <editor-fold desc="Processes">
    private void processGetByPriceRequest() {
        try{
            System.out.print("Please Enter Min Price Range: ");
            double min = Double.parseDouble(userInput.nextLine().strip());
            System.out.print("Please Enter Max Price Range: ");
            double max = Double.parseDouble(userInput.nextLine().strip());
            System.out.println("Results: ");
            dealership.display(dealership.getVehiclesByPrice(min, max));
        } catch (Exception _) {
            System.out.println("Incorrect Response -- Returning to Main Menu" );
        }
    }
    private void processGetByMakeModelRequest() {
        try{
            System.out.print("Please Enter Make: ");
            String make = userInput.nextLine().strip();
            System.out.print("Please Enter Model: ");
            String model = userInput.nextLine().strip();
            System.out.println("Results: ");
            dealership.display(dealership.getVehiclesByMakeModel(make, model));
        } catch (Exception _) {
            System.out.println("Incorrect Response -- Returning to Main Menu" );
        }
    }
    private void processGetByYearRequest() {
        try{
            System.out.print("Please Enter Min Price Range: ");
            int min = Integer.parseInt(userInput.nextLine().strip());
            System.out.print("Please Enter Max Price Range: ");
            int max = Integer.parseInt(userInput.nextLine().strip());
            System.out.println("Results: ");
            dealership.display(dealership.getVehiclesByYear(min, max));
        } catch (Exception _) {
            System.out.println("Incorrect Response -- Returning to Main Menu" );
        }

    }
    private void processGetByColorRequest() {
        try{
            System.out.print("Please Enter Color: ");
            String color = userInput.nextLine().strip();
            System.out.println("Results: ");
            dealership.display(dealership.getVehiclesByColor(color));
        } catch (Exception _) {
            System.out.println("Incorrect Response -- Returning to Main Menu" );
        }
    }
    private void processGetByMileageRequest() {
        try{
            System.out.print("Please Enter Min Price Range: ");
            int min = Integer.parseInt(userInput.nextLine().strip());
            System.out.print("Please Enter Max Price Range: ");
            int max = Integer.parseInt(userInput.nextLine().strip());
            System.out.println("Results: ");
            dealership.display(dealership.getVehiclesByMileage(min, max));
        } catch (Exception _) {
            System.out.println("Incorrect Response -- Returning to Main Menu" );
        }
    }
    private void processGetByVehicleTypeRequest() {
        try{
            System.out.print("Please Enter Vehicle Type: ");
            String vehicleType = userInput.nextLine().strip();
            System.out.println("Results: ");
            dealership.display(dealership.getVehiclesByType(vehicleType));
        } catch (Exception _) {
            System.out.println("Incorrect Response -- Returning to Main Menu" );
        }
    }
    private void processGetAllVehicleRequest() {
        dealership.display(dealership.getAllVehicles());
    }
    private void processAddVehicleRequest() {
        try {
            System.out.println("Add a Vehicle: ");
            System.out.print("\tVehicle ID Number: ");
            final int VIN = Integer.parseInt(userInput.nextLine().strip());
            System.out.print("\tYear: ");
            final int YEAR = Integer.parseInt(userInput.nextLine().strip());
            System.out.print("\tMake: ");
            final String MAKE = userInput.nextLine().strip();
            System.out.print("\tModel: ");
            final String MODEL = userInput.nextLine().strip();
            System.out.print("\tVehicle Type: ");
            final String VEHICLE_TYPE = userInput.nextLine().strip();
            System.out.print("\tColor: ");
            final String COLOR = userInput.nextLine().strip();
            System.out.print("\tMileage: ");
            final int MILEAGE = Integer.parseInt(userInput.nextLine().strip());
            System.out.print("\tPrice: $");
            final double PRICE = Double.parseDouble(userInput.nextLine().strip());
            dealership.addVehicle(new Vehicle(VIN, YEAR, MAKE, MODEL, VEHICLE_TYPE, COLOR, MILEAGE, PRICE));
        } catch (Exception _) {
            System.out.println("Incorrect Response -- Returning to Main Menu" );
        }
    }
    private void processRemoveVehicleRequest() {
        System.out.print("Please enter Vin number of Car: ");
        int vin = Integer.parseInt(userInput.nextLine().strip());
        dealership.getAllVehicles().stream()
                .filter(vehicle -> vehicle.getVin() == vin)
                .forEach(vehicle -> dealership.removeVehicle(vehicle));
        System.out.println("Vehicle has been removed from list. Exit program to save changes.");
    }
    // </editor-fold>
}
