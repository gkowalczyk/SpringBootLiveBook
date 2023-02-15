package com.example.springjpatesting.vehicle;

import java.util.List;

interface VehicleService {
    List<Vehicle> findAllVehicles();

    Vehicle findVehicleById(Long id);

    List<Vehicle> findAllVehicleByColor(String color);

    Vehicle saveVehicle(Vehicle vehicle);

    List<Vehicle> saveVehicleList(List<Vehicle> vehicleList);
}
