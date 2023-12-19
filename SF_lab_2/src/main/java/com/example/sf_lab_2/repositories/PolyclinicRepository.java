package com.example.sf_lab_2.repositories;

import com.example.sf_lab_2.models.Doctor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;

@Repository
public class PolyclinicRepository {

    private ArrayList<Doctor> timeTable;

    private String value;

    public ArrayList<Doctor> getTimeTable() {
        return timeTable;
    }

    public Doctor getDoctor(String name) {
        return new Doctor("NAME", new HashMap<>());
    }

    public static Boolean checkDoctorExistence (String name) {
        return true;
    }


}
