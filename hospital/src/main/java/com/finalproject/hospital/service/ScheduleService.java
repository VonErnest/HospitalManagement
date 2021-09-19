package com.finalproject.hospital.service;

import com.finalproject.hospital.domain.Schedules;
import com.finalproject.hospital.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("doctorService")
public class ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    public void update(Schedules schedules) {
        scheduleRepository.save(schedules);
    }

    public void addNewSchedule(long doctorId, String date, String startTime, String endTime, String patientCode) {

        Schedules schedules1 = new Schedules();
        schedules1.setDoctorId(doctorId);
        schedules1.setDate(date);
        schedules1.setStartTime(startTime);
        schedules1.setEndTime(endTime);
        schedules1.setPatientCode(patientCode);
        scheduleRepository.save(schedules1);

    }

    public Schedules get(long id) {
        return scheduleRepository.findById(id).get();
    }

    public void save(Schedules schedules) {
        scheduleRepository.save(schedules);
    }

    public void delete(long id) {
        scheduleRepository.deleteById(id);
    }

}