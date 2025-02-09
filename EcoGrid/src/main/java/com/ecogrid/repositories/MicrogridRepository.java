package com.ecogrid.repositories;

import com.ecogrid.models.Microgrid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MicrogridRepository extends JpaRepository<Microgrid, Integer> {
}
