package com.example.springjpatesting.vehicle;

import org.springframework.data.jpa.repository.JpaRepository;

interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    Iterable<Vehicle> findAllByColor(String color);
}
