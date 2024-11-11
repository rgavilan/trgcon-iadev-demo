package com.izertis.iadev.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.izertis.iadev.model.Vehicle;

@Service
public class VehicleService {

    public Vehicle getVehicle(Long id) {
        return new Vehicle(id, "Toyota", "Corolla", "1234ABC", true);
    }

    public List<Vehicle> getVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Vehicle(1L, "Toyota", "Corolla", "1234ABC", true));
        vehicles.add(new Vehicle(2L, "Ford", "Focus", "5678DEF", true));
        vehicles.add(new Vehicle(3L, "Volkswagen", "Golf", "9012GHI", true));
        return vehicles;
    }

    public Vehicle addVehicle(Vehicle vehicle) {
        return new Vehicle(1L, vehicle.getBrand(), vehicle.getModel(), vehicle.getLicensePlate(), true);
    }

    public Vehicle addVehicle(String brand, String model, String licensePlate) {
        return new Vehicle(1L, brand, model, licensePlate, true);
    }
}
