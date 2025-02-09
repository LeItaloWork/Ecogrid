package com.ecogrid.controllers;

import com.ecogrid.models.Billing;
import com.ecogrid.services.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/billing")
public class BillingController {

    @Autowired
    private BillingService billingService;

    @GetMapping
    public List<Billing> getAllBillings() {
        return billingService.getAllBillings();
    }

    @GetMapping("/{id}")
    public Billing getBillingById(@PathVariable int id) {
        return billingService.getBillingById(id);
    }

    @PostMapping
    public Billing createBilling(@RequestBody Billing billing) {
        return billingService.createBilling(billing);
    }

    @PutMapping("/{id}")
    public Billing updateBilling(@PathVariable int id, @RequestBody Billing billing) {
        return billingService.updateBilling(id, billing);
    }

    @DeleteMapping("/{id}")
    public void deleteBilling(@PathVariable int id) {
        billingService.deleteBilling(id);
    }
}
