package com.finalproject.hospital.service;
import com.finalproject.hospital.domain.Patient;
import com.finalproject.hospital.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public Patient get(long id) {
        return patientRepository.findById(id).get();
    }

    public void save(Patient patient) {
        patientRepository.save(patient);
    }

    public void delete(long id) {
        patientRepository.deleteById(id);
    }

    public void addPatient(String firstName, String lastName, String personalIdentificationCode, int age, String phoneNumber, String email) {
        Patient patient1 = new Patient();
        patient1.setFirstName(firstName);
        patient1.setLastName(lastName);
        patient1.setPersonalIdentificationCode(personalIdentificationCode);
        patient1.setAge(age);
        patient1.setPhoneNumber(phoneNumber);
        patient1.setEmail(email);
        patientRepository.save(patient1);
    }


    public Optional<Patient> findById(long id) {
        System.out.println(patientRepository.findById(id));
        return patientRepository.findById(id);
    }

    public void updatePatientById(long id, String diagnose, String drug) {
        Patient patient1 = patientRepository.getById(id);
        patient1.setDiagnose(diagnose);
        patient1.setDrug(drug);
        patientRepository.save(patient1);
        System.out.println(patient1);
    }

    public List<Patient> listAllPatients() {
        System.out.println(patientRepository.findAll());
        return patientRepository.findAll();
    }

    public List<Patient> findPatient(String firstName) {
        System.out.println(patientRepository.findPatientByFirstName(firstName));
        return patientRepository.findPatientByFirstName(firstName);
    }

    public List<Patient> findByCode(String identificationCode) {
        System.out.println(patientRepository.findPatientByIdentificationCode(identificationCode));
        return patientRepository.findPatientByIdentificationCode(identificationCode);
    }
}



