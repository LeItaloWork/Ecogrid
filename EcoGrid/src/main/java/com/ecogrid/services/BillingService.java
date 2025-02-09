package com.ecogrid.services;

import com.ecogrid.models.Billing;
import com.ecogrid.repositories.BillingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BillingService {

    @Autowired
    private BillingRepository billingRepository;

    public List<Billing> getAllBillings() {
        return billingRepository.findAll();
    }

    public Billing getBillingById(int id) {
        return billingRepository.findById(id).orElse(null);
    }

    public Billing createBilling(Billing billing) {
        return billingRepository.save(billing);
    }

    public Billing updateBilling(int id, Billing billingDetails) {
        Optional<Billing> billing = billingRepository.findById(id);
        if (billing.isPresent()) {
            Billing updatedBilling = billing.get();
            updatedBilling.setAmount(billingDetails.getAmount());
            updatedBilling.setStatus(billingDetails.getStatus());
            return billingRepository.save(updatedBilling);
        }
        return null;
    }

    public void deleteBilling(int id) {
        billingRepository.deleteById(id);
    }
}
