package com.ecogrid.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnergyStorage {
    private int storageId;
    private double capacity;
    private String status;

    public String checkStatus() {
        return "Status: " + status;
    }

    // Polimorfismo estático com sobrecarga de métodos
    public void updateCapacity(double newCapacity) {
        this.capacity = newCapacity;
    }

    public void updateCapacity(double newCapacity, String status) {
        this.capacity = newCapacity;
        this.status = status;
    }

    // Getters e Setters gerados automaticamente pelo Lombok
}
