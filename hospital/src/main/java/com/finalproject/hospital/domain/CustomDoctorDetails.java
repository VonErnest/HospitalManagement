package com.finalproject.hospital.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class CustomDoctorDetails implements UserDetails {

    private Doctor doctor;

    public CustomDoctorDetails(Doctor doctor) {
        this.doctor = doctor;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return doctor.getPassword();
    }

    @Override
    public String getUsername() {
        return doctor.getEmail();
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
        return doctor.getFirstName() + " " + doctor.getLastName();
    }

    public String getEmail() {
        return doctor.getEmail();
    }

    public String getLastName() {
        return doctor.getLastName();
    }

    public String getFirstName() {
        return doctor.getFirstName();
    }

    public String getRole() {
        return doctor.getRole();
    }
}
