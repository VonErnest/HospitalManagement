package com.finalproject.hospital.repository;

import com.finalproject.hospital.domain.Pharmacy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PharmacyRepository extends JpaRepository <Pharmacy, Long> {
}
