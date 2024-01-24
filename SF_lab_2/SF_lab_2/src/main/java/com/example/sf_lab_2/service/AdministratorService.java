package com.example.sf_lab_2.service;

import com.example.sf_lab_2.models.Admin;
import com.example.sf_lab_2.repository.AdminDAO;
import com.example.sf_lab_2.repository.DoctorDAO;
import com.example.sf_lab_2.repository.TimeTableDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdministratorService {
    private AdminDAO adminDAO;


    @Autowired
    public AdministratorService(AdminDAO adminDAO, DoctorDAO doctorDAO, TimeTableDAO timeTableDAO) {
        this.adminDAO = adminDAO;
    }

    public void create(Admin admin){
        this.adminDAO.createAdmin(admin);
    }

    public void delete(int id){
        this.adminDAO.delAdmin(id);
    }

}
