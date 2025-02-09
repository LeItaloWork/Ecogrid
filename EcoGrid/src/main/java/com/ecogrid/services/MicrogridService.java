package com.ecogrid.services;

import com.ecogrid.models.Microgrid;
import com.ecogrid.repositories.MicrogridRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MicrogridService {

    @Autowired
    private MicrogridRepository microgridRepository;

    public List<Microgrid> getAllMicrogrids() {
        return microgridRepository.findAll();
    }

    public Microgrid getMicrogridById(int id) {
        return microgridRepository.findById(id).orElse(null);
    }

    public Microgrid createMicrogrid(Microgrid microgrid) {
        return microgridRepository.save(microgrid);
    }

    public Microgrid updateMicrogrid(int id, Microgrid microgridDetails) {
        Optional<Microgrid> microgrid = microgridRepository.findById(id);
        if (microgrid.isPresent()) {
            Microgrid updatedMicrogrid = microgrid.get();
            updatedMicrogrid.setCapacity(microgridDetails.getCapacity());
            updatedMicrogrid.setStatus(microgridDetails.getStatus());
            return microgridRepository.save(updatedMicrogrid);
        }
        return null;
    }

    public void deleteMicrogrid(int id) {
        microgridRepository.deleteById(id);
    }
}
