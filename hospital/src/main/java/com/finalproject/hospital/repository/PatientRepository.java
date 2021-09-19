package com.finalproject.hospital.repository;

import com.finalproject.hospital.domain.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    @Modifying
    @Query("select p from Patient p where p.firstName = ?1")
    List<Patient> findPatientByFirstName(String patient);

    @Modifying
    @Query("select p from Patient p where p.firstName like '%mas'")
    List<Patient> findPatient(String patient);

    @Modifying
    @Query("select p from Patient p where p.personalIdentificationCode = ?1")
    List<Patient> findPatientByIdentificationCode(String personalIdentificationCode);

    @Modifying
    @Query("update Patient p set p.diagnose = :diagnose where p.id = :id")
    void updatePatientDiagnose(@Param(value = "id") int id, @Param(value = "diagnose") String diagnose);

    @Query("select p from Patient p where p.personalIdentificationCode = ?1")
    public Patient findByIdentificationCode(String personalIdentificationCode);

    @Query("select p from Patient p where p.email = ?1")
    public Patient findByEmail(String email);
}


