package com.ecogrid.controllers;

import com.ecogrid.models.EnergyStorage;
import com.ecogrid.services.EnergyStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/energy-storage")
public class EnergyStorageController {

    @Autowired
    private EnergyStorageService energyStorageService;

    @GetMapping
    public List<EnergyStorage> getAllEnergyStorages() {
        return energyStorageService.getAllEnergyStorages();
    }

    @GetMapping("/{id}")
    public EnergyStorage getEnergyStorageById(@PathVariable int id) {
        return energyStorageService.getEnergyStorageById(id);
    }

    @PostMapping
    public EnergyStorage createEnergyStorage(@RequestBody EnergyStorage energyStorage) {
        return energyStorageService.createEnergyStorage(energyStorage);
    }

    @PutMapping("/{id}")
    public EnergyStorage updateEnergyStorage(@PathVariable int id, @RequestBody EnergyStorage energyStorage) {
        return energyStorageService.updateEnergyStorage(id, energyStorage);
    }

    @DeleteMapping("/{id}")
    public void deleteEnergyStorage(@PathVariable int id) {
        energyStorageService.deleteEnergyStorage(id);
    }
}
