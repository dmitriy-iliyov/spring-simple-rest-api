package com.example.sf_lab_2.models;

import java.util.Date;
import java.util.HashMap;


public class Doctor {
    private String name;
    private HashMap<Date, Long> doctorTimeTable;

    public Doctor(String name, HashMap<Date, Long> doctorTimeTable) {
        this.name = name;
        this.doctorTimeTable = doctorTimeTable;
    }

    public String getName() {
        return name;
    }

    public HashMap<Date, Long> getDoctorTimeTable() {
        return doctorTimeTable;
    }

}
