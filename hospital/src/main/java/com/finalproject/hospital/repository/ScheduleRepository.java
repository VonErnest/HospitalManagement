package com.finalproject.hospital.repository;

import com.finalproject.hospital.domain.Doctor;
import com.finalproject.hospital.domain.Schedules;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedules, Long> {

    @Query("select d from Doctor d where d.email = ?1")
    public Doctor findByEmail(String email);

}


