package com.ecogrid.models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class Community {
    private int communityId;
    private String name;
    private String location;
    private int population;
    private List<Microgrid> microgrids = new ArrayList<>();

    public void addMicrogrid(Microgrid microgrid) {
        microgrids.add(microgrid);
    }

    public double calculateTotalConsumption() {
        return microgrids.stream().mapToDouble(Microgrid::calculateConsumption).sum();
    }

    // Getters e Setters gerados automaticamente pelo Lombok
}
