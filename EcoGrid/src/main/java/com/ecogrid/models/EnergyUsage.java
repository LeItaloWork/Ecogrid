package com.ecogrid.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class EnergyUsage {
    private int usageId;
    private Date timestamp;
    private double consumption;
    private double cost;

    public double calculateCost() {
        // Cálculo do custo com base no consumo
        return consumption * 0.12; // Exemplo de cálculo
    }

    // Getters e Setters gerados automaticamente pelo Lombok
}
