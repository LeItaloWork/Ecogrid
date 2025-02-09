package com.ecogrid.services;

import com.ecogrid.models.EnergyUsage;
import com.ecogrid.repositories.EnergyUsageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnergyUsageService {

    @Autowired
    private EnergyUsageRepository energyUsageRepository;

    public List<EnergyUsage> getAllEnergyUsages() {
        return energyUsageRepository.findAll();
    }

    public EnergyUsage getEnergyUsageById(int id) {
        return energyUsageRepository.findById(id).orElse(null);
    }

    public EnergyUsage createEnergyUsage(EnergyUsage energyUsage) {
        return energyUsageRepository.save(energyUsage);
    }

    public EnergyUsage updateEnergyUsage(int id, EnergyUsage usageDetails) {
        Optional<EnergyUsage> usage = energyUsageRepository.findById(id);
        if (usage.isPresent()) {
            EnergyUsage updatedUsage = usage.get();
            updatedUsage.setConsumption(usageDetails.getConsumption());
            updatedUsage.setCost(usageDetails.getCost());
            return energyUsageRepository.save(updatedUsage);
        }
        return null;
    }

    public void deleteEnergyUsage(int id) {
        energyUsageRepository.deleteById(id);
    }
}
