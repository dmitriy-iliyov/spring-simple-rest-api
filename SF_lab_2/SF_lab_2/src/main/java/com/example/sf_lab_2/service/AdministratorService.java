package com.example.sf_lab_2.service;

import com.example.sf_lab_2.repository.PolyclinicRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AdministratorService {
    private PolyclinicRepository repository;

    public AdministratorService() {

    }

    private void addAppointment(String doctorName, Date time, Long userID) {
    }

    private void deleteAppointment(String doctorName, Date time, Long userID) {

    }

    private void updateAppointment(String doctorName, Date time, Long userID) {
    }
}
