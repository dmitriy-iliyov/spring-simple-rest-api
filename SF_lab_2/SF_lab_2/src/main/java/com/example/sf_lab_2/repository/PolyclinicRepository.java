package com.example.sf_lab_2.repository;

import com.example.sf_lab_2.models.Doctor;
import com.example.sf_lab_2.models.User;
import org.springframework.stereotype.Repository;

//postgres
@Repository
public class PolyclinicRepository {
//    jdbc:postgresql://localhost:5432/policlinic_database

    public void addDoctor(){

    }

    public Doctor getDoctor(String name){
        return new Doctor();
    }

    public void updateDoctor(){

    }

    public void addUser(){

    }

    public User getUser(){
        return new User();
    }

    public void updateUser(){

    }
}
