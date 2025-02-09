package com.ecogrid.repositories;

import com.ecogrid.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    // Aqui você pode adicionar métodos de consulta personalizados, se necessário
}
