package com.ecogrid.services;

import com.ecogrid.models.SecurityLog;
import com.ecogrid.repositories.SecurityLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SecurityLogService {

    private final SecurityLogRepository securityLogRepository;

    @Autowired
    public SecurityLogService(SecurityLogRepository securityLogRepository) {
        this.securityLogRepository = securityLogRepository;
    }

    // Método para atualizar um SecurityLog existente
    public SecurityLog updateSecurityLog(int id, SecurityLog updatedLog) {
        Optional<SecurityLog> existingLogOpt = securityLogRepository.findById(id);

        if (existingLogOpt.isPresent()) {
            SecurityLog existingLog = existingLogOpt.get();
            // Atualiza os campos necessários
            existingLog.setEventType(updatedLog.getEventType());
            existingLog.setDescription(updatedLog.getDescription());
            existingLog.setTimestamp(updatedLog.getTimestamp());

            // Salva o log atualizado no repositório
            return securityLogRepository.save(existingLog);
        } else {
            throw new RuntimeException("Log de segurança com ID " + id + " não encontrado");
        }
    }

    // Outros métodos no SecurityLogService, como salvar, excluir, etc.
}
