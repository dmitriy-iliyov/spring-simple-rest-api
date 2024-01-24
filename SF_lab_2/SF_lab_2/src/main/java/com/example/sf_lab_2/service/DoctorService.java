package com.example.sf_lab_2.service;

import com.example.sf_lab_2.models.Doctor;
import com.example.sf_lab_2.models.TimeTable;
import com.example.sf_lab_2.repository.DoctorDAO;
import com.example.sf_lab_2.repository.TimeTableDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DoctorService {
    private DoctorDAO doctorDAO;

    private TimeTableDAO timeTableDAO;

    @Autowired
    public DoctorService(DoctorDAO doctorDAO, TimeTableDAO timeTableDAO) {
        this.doctorDAO = doctorDAO;
        this.timeTableDAO = timeTableDAO;
    }

    public void createDoctor(Doctor doctor){
        this.doctorDAO.createDoctor(doctor);
    }

    public <T> Doctor getDoctor(T value){
        Doctor doctor = null;
        if (isNumber((String) value)) {
            doctor = this.doctorDAO.getDoctorByID(Integer.parseInt(((String) value).trim()));
        }
        else{
            doctor =  this.doctorDAO.getDoctorByName((String) value);
        }
        return doctor;
    }

    public void updateDoctor(int id, Doctor updatedDoctor){
        this.doctorDAO.updateDoctor(id, updatedDoctor);
    }

    public void deleteDoctor(int id){
        this.doctorDAO.delDoctor(id);
        this.timeTableDAO.delTimeTable(id);
    }

    public List<Doctor> allDoctors(){
        return this.doctorDAO.allDoctors();
    }

    public void createTimeTable(TimeTable timeTable){
        this.timeTableDAO.createTimeTable(timeTable);
    }

    public <T> TimeTable getTimeTable(T value){
        TimeTable timeTable = null;
        if (isNumber((String) value)) {
            timeTable = this.timeTableDAO.getTimeTable(Integer.parseInt(((String) value).trim()));
        }
        else{
            timeTable =  this.timeTableDAO.getTimeTableByDate((String) value);
        }
        return timeTable;
    }

    public void updateTimeTable(int doctorID, TimeTable updatedTimeTable){
        this.timeTableDAO.updateTimeTable(doctorID, updatedTimeTable);
    }

    public static boolean isNumber(String str) {
        try {
            Integer.parseInt(str);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
