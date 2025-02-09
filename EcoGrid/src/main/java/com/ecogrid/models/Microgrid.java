package com.ecogrid.models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class Microgrid {
    private int microgridId;
    private double capacity;
    private String status;
    private List<EnergyStorage> storages = new ArrayList<>();

    public double calculateConsumption() {
        // Lógica para calcular o consumo total
        return 0.0;
    }

    public void addStorage(EnergyStorage storage) {
        storages.add(storage);
    }

    // Getters e Setters gerados automaticamente pelo Lombok
}
