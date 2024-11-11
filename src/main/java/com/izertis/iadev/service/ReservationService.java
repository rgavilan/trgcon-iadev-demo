package com.izertis.iadev.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.izertis.iadev.model.Customer;
import com.izertis.iadev.model.Reservation;
import com.izertis.iadev.model.Vehicle;

@Service
public class ReservationService {
    private List<Reservation> reservations;
    private CustomerService customerService;
    private VehicleService vehicleService;

    public ReservationService(CustomerService customerService, VehicleService vehicleService) {
        this.customerService = customerService;
        this.vehicleService = vehicleService;
        reservations = new ArrayList<>();
        reservations.add(new Reservation(1L, customerService.getCustomer(1L), vehicleService.getVehicle(1L), LocalDate.now(), LocalDate.now().plusDays(7)));
        reservations.add(new Reservation(2L, customerService.getCustomer(2L), vehicleService.getVehicle(2L), LocalDate.now(), LocalDate.now().plusDays(3)));
    }

    public Reservation getReservation(Long id) {
        return reservations.stream()
                .filter(reservation -> reservation.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public Reservation addReservation(Long customerId, Long vehicleId, LocalDate startDate, LocalDate endDate) {
        Customer customer = customerService.getCustomer(customerId);
        Vehicle vehicle = vehicleService.getVehicle(vehicleId);
        Reservation reservation = new Reservation((long) (reservations.size() + 1), customer, vehicle, startDate, endDate);
        reservations.add(reservation);
        return reservation;
    }

    public Reservation addReservation(Reservation reservation) {
        reservation.setId((long) (reservations.size() + 1));
        reservations.add(reservation);
        return reservation;
    }
}