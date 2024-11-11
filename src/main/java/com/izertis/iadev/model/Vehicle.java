package com.izertis.iadev.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {
    private Long id;
    private String brand;
    private String model;
    private String licensePlate;
    private boolean available;
}