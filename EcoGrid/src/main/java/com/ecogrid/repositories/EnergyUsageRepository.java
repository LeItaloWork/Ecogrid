package com.ecogrid.repositories;

import com.ecogrid.models.EnergyUsage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnergyUsageRepository extends JpaRepository<EnergyUsage, Integer> {
}
