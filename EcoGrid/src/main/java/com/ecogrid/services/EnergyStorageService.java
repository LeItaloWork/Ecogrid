package com.ecogrid.services;

import com.ecogrid.models.EnergyStorage;
import com.ecogrid.repositories.EnergyStorageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnergyStorageService {

    @Autowired
    private EnergyStorageRepository energyStorageRepository;

    public List<EnergyStorage> getAllEnergyStorages() {
        return energyStorageRepository.findAll();
    }

    public EnergyStorage getEnergyStorageById(int id) {
        return energyStorageRepository.findById(id).orElse(null);
    }

    public EnergyStorage createEnergyStorage(EnergyStorage energyStorage) {
        return energyStorageRepository.save(energyStorage);
    }

    public EnergyStorage updateEnergyStorage(int id, EnergyStorage storageDetails) {
        Optional<EnergyStorage> storage = energyStorageRepository.findById(id);
        if (storage.isPresent()) {
            EnergyStorage updatedStorage = storage.get();
            updatedStorage.setCapacity(storageDetails.getCapacity());
            updatedStorage.setStatus(storageDetails.getStatus());
            return energyStorageRepository.save(updatedStorage);
        }
        return null;
    }

    public void deleteEnergyStorage(int id) {
        energyStorageRepository.deleteById(id);
    }
}
