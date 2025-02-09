package com.ecogrid.repositories;

import com.ecogrid.models.EnergyStorage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnergyStorageRepository extends JpaRepository<EnergyStorage, Integer> {
}
