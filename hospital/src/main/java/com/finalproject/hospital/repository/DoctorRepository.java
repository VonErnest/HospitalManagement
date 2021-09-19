package com.finalproject.hospital.repository;

import com.finalproject.hospital.domain.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    @Query("select d from Doctor d where d.email = ?1")
    public Doctor findByEmail(String email);

    @Query("select d from Doctor d where d.role = ?1")
    public Doctor findRole(String role);
}
