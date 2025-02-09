package com.ecogrid.controllers;

import com.ecogrid.models.EnergyUsage;
import com.ecogrid.services.EnergyUsageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/energy-usage")
public class EnergyUsageController {

    @Autowired
    private EnergyUsageService energyUsageService;

    @GetMapping
    public List<EnergyUsage> getAllEnergyUsages() {
        return energyUsageService.getAllEnergyUsages();
    }

    @GetMapping("/{id}")
    public EnergyUsage getEnergyUsageById(@PathVariable int id) {
        return energyUsageService.getEnergyUsageById(id);
    }

    @PostMapping
    public EnergyUsage createEnergyUsage(@RequestBody EnergyUsage energyUsage) {
        return energyUsageService.createEnergyUsage(energyUsage);
    }

    @PutMapping("/{id}")
    public EnergyUsage updateEnergyUsage(@PathVariable int id, @RequestBody EnergyUsage energyUsage) {
        return energyUsageService.updateEnergyUsage(id, energyUsage);
    }

    @DeleteMapping("/{id}")
    public void deleteEnergyUsage(@PathVariable int id) {
        energyUsageService.deleteEnergyUsage(id);
    }
}
