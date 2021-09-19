package com.finalproject.hospital.service;

import com.finalproject.hospital.domain.CustomDoctorDetails;
import com.finalproject.hospital.domain.Doctor;
import com.finalproject.hospital.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomDoctorDetailsService implements UserDetailsService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Doctor doctor = doctorRepository.findByEmail(username);

        if (doctor == null) {
            throw new UsernameNotFoundException("Doctor not found");
        }
        return new CustomDoctorDetails(doctor);
    }

    public UserDetails findRole(String role) {
        Doctor doctor1 = doctorRepository.findRole(role);
        return new CustomDoctorDetails(doctor1);
    }
}
