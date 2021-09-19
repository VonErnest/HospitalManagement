package com.finalproject.hospital.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class CustomPatientDetails implements UserDetails {

    private Patient patient;

    public CustomPatientDetails(Patient patient) {
        this.patient = patient;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return patient.getPassword();
    }

    @Override
    public String getUsername() {
        return patient.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getFullName() {
        return patient.getFirstName() + " " + patient.getLastName();
    }

    public Long getId() {
        return patient.getId();
    }

    public String getFirstName() {
        return patient.getFirstName();
    }

    public String getLastName() {
        return patient.getLastName();
    }

    public String getEmail() {
        return patient.getEmail();
    }

    public String getPersonalIdentificationCode() {
        return patient.getPersonalIdentificationCode();
    }

    public int getAge() {
        return patient.getAge();
    }

    public String getDiagnose() {
        return patient.getDiagnose();
    }

    public String getPrescription() {
        return patient.getDrug();
    }

    public String getPhoneNumber() {
        return patient.getPhoneNumber();
    }
}
