package com.example.springjpatesting.vehicle;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;

    public VehicleServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public List<Vehicle> findAllVehicles() {
        Iterable<Vehicle> vehicles = vehicleRepository.findAll();
        return StreamSupport.stream(vehicles.spliterator(), true)
                .collect(Collectors.toList());
    }

    @Override
    public Vehicle findVehicleById(Long id) {
        Optional<Vehicle> vehicleOptional = vehicleRepository.findById(id);
        return vehicleOptional.orElseThrow(() -> new EntityNotFoundException("No vehicle with such ID" + id));
    }

    @Override
    public List<Vehicle> findAllVehicleByColor(String color) {
        Iterable<Vehicle> vehicles = vehicleRepository.findAllByColor(color);
        return StreamSupport.stream(vehicles.spliterator(), true)
                .collect(Collectors.toList());
    }

    @Override
    public Vehicle saveVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    @Override
    public List<Vehicle> saveVehicleList(List<Vehicle> vehicleList) {
        Iterable<Vehicle> vehicleIterable = vehicleRepository.saveAll(vehicleList);
        return StreamSupport.stream(vehicleIterable.spliterator(), true).collect(Collectors.toList());
 }
}
