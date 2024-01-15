package com.example.sf_lab_2.service;

import com.example.sf_lab_2.repository.PolyclinicRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AdministratorService {
    private PolyclinicRepository timeTable;

    public AdministratorService() {

    }

    private void addAppointment(String doctorName, Date time, Long userID) {
        if(PolyclinicRepository.checkDoctorExistence(doctorName)){

        }
        this.timeTable.getDoctor(doctorName);
    }

    private void deleteAppointment(String doctorName, Date time, Long userID) {
        this.timeTable.getDoctor(doctorName);
    }

    private void updateAppointment(String doctorName, Date time, Long userID) {
        this.timeTable.getDoctor(doctorName);
    }
}
