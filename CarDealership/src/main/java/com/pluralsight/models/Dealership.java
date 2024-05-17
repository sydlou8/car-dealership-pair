package com.pluralsight.models;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private String name;
    private String address;
    private String phone;

    private ArrayList<Vehicle> inventory = new ArrayList<>();

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.phone = phone;
        this.address = address;
    }
    // <editor-fold desc="Getters">

    public String getName() {
        return name;
    }
    public String getAddress() {
        return address;
    }
    public String getPhone() {
        return phone;
    }

    // </editor-fold>
    // <editor-fold desc="Get Vehicles Methods">
    public List<Vehicle> getVehiclesByPrice(double min, double max) {
        return inventory.stream()
                .filter(vehicle -> vehicle.getPrice() >= min)
                .filter(vehicle -> vehicle.getPrice() <= max)
                .toList();
    }
    public List<Vehicle> getVehiclesByMakeModel(String make, String model) {
        return inventory.stream()
                .filter(vehicle -> vehicle.getMake().equalsIgnoreCase(make))
                .filter(vehicle -> vehicle.getModel().equalsIgnoreCase(model))
                .toList();
    }
    public List<Vehicle> getVehiclesByYear(int min, int max) {
        return inventory.stream()
                .filter(vehicle -> vehicle.getYear() >= min)
                .filter(vehicle -> vehicle.getYear() <= max)
                .toList();
    }
    public List<Vehicle> getVehiclesByColor(String color) {
        return inventory.stream()
                .filter(vehicle -> vehicle.getColor().equalsIgnoreCase(color))
                .toList();
    }
    public List<Vehicle> getVehiclesByMileage(int min, int max) {
        return inventory.stream()
                .filter(vehicle -> vehicle.getOdometer() >= min)
                .filter(vehicle -> vehicle.getOdometer() <= max)
                .toList();
    }
    public List<Vehicle> getVehiclesByType(String vehicleType) {
        return inventory.stream()
                .filter(vehicle -> vehicle.getVehicleType().equalsIgnoreCase(vehicleType))
                .toList();
    }
    public List<Vehicle> getAllVehicles() {
        return inventory.stream().toList();
    }
    // </editor-fold>
    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);
    }
    public void removeVehicle(Vehicle vehicle) {
        inventory.remove(vehicle);
    }

    public void display(List<Vehicle> filteredInventory) {
        filteredInventory.forEach(vehicle ->
                System.out.printf( "VEHICLE: \n" +
                        "\tPrice: \t\t$%-10.2f\n" +
                        "\tMake: \t\t%-10s\n" +
                        "\tModel: \t\t%-10s\n" +
                        "\tColor: \t\t%-10s\n" +
                        "\tMileage: \t%-7dmi\n" +
                        "\tType: \t\t%-10s\n",
                        vehicle.getPrice(),
                        vehicle.getMake(),
                        vehicle.getModel(),
                        vehicle.getColor(),
                        vehicle.getOdometer(),
                        vehicle.getVehicleType()
                ));
    }
    public Vehicle getVehicleByVin(int vin){
        for(Vehicle vehicle: inventory){
            if(vin == vehicle.getVin()){
                return vehicle;
            }

        }
        System.out.println("Vehicle is not found. ");
        return null;

    }
}
