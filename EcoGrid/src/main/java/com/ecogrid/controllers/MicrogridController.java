package com.ecogrid.controllers;

import com.ecogrid.models.Microgrid;
import com.ecogrid.services.MicrogridService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/microgrids")
public class MicrogridController {

    @Autowired
    private MicrogridService microgridService;

    @GetMapping
    public List<Microgrid> getAllMicrogrids() {
        return microgridService.getAllMicrogrids();
    }

    @GetMapping("/{id}")
    public Microgrid getMicrogridById(@PathVariable int id) {
        return microgridService.getMicrogridById(id);
    }

    @PostMapping
    public Microgrid createMicrogrid(@RequestBody Microgrid microgrid) {
        return microgridService.createMicrogrid(microgrid);
    }

    @PutMapping("/{id}")
    public Microgrid updateMicrogrid(@PathVariable int id, @RequestBody Microgrid microgrid) {
        return microgridService.updateMicrogrid(id, microgrid);
    }

    @DeleteMapping("/{id}")
    public void deleteMicrogrid(@PathVariable int id) {
        microgridService.deleteMicrogrid(id);
    }
}
