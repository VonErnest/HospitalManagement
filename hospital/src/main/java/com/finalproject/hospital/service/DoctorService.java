package com.finalproject.hospital.service;

import com.finalproject.hospital.domain.Doctor;
import com.finalproject.hospital.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("doctor2Service")
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public void save(Doctor doctor) {
        doctorRepository.save(doctor);
    }
}
