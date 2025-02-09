package com.ecogrid.repositories;

import com.ecogrid.models.SecurityLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecurityLogRepository extends JpaRepository<SecurityLog, Integer> {
}
