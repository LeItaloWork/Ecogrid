package com.ecogrid.controllers;

import com.ecogrid.models.SecurityLog;
import com.ecogrid.services.SecurityLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/securityLogs")
public class SecurityLogController {

    private final SecurityLogService securityLogService;

    @Autowired
    public SecurityLogController(SecurityLogService securityLogService) {
        this.securityLogService = securityLogService;
    }

    @PutMapping("/{id}")
    public ResponseEntity<SecurityLog> updateSecurityLog(@PathVariable int id, @RequestBody SecurityLog securityLog) {
        try {
            SecurityLog updatedLog = securityLogService.updateSecurityLog(id, securityLog);
            return ResponseEntity.ok(updatedLog);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Outros métodos para listar, criar, etc.
}
