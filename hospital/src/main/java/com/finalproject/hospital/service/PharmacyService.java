package com.finalproject.hospital.service;

import com.finalproject.hospital.domain.Pharmacy;
import com.finalproject.hospital.repository.PharmacyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PharmacyService {

    @Autowired
    private PharmacyRepository pharmacyRepository;

    public void addNewDrug(String productName, String productDescription) {

        Pharmacy pharmacy1 = new Pharmacy();
        pharmacy1.setProductName(productName);
        pharmacy1.setProductDescription(productDescription);
        pharmacyRepository.save(pharmacy1);
    }
}
