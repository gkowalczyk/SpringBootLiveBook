package com.example.springjpatesting.vehicle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(produces = {MediaType.APPLICATION_JSON_VALUE}, path = "/api/vehicles")
public class VehicleController {

    private final VehicleService vehicleService;

    @Autowired
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping
    public List<Vehicle> getVehicles() {
        return vehicleService.findAllVehicles();
    }

    @GetMapping(value = "/filter")
    public List<Vehicle> getVehiclesByColor(@RequestParam String color) {
        return vehicleService.findAllVehicleByColor(color);
    }

    @GetMapping(value = "/{id}")
    public Vehicle getVehicleById(@PathVariable Long id) {
        return vehicleService.findVehicleById(id);
    }

    @PostMapping
    public Vehicle saveVehicle(@RequestBody Vehicle vehicle) {
        return vehicleService.saveVehicle(vehicle);
    }

    @PostMapping(value = "/save-all")
    public List<Vehicle> saveVehicles(@RequestBody List<Vehicle> vehiclesList) {
        return vehicleService.saveVehicleList(vehiclesList);
    }





}
