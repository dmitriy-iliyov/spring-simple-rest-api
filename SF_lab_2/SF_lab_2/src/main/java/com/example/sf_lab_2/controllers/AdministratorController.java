package com.example.sf_lab_2.controllers;

import com.example.sf_lab_2.service.AdministratorService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class AdministratorController {

    private AdministratorService administratorService;

    public AdministratorController(AdministratorService administratorService) {
        this.administratorService = administratorService;
    }

    @PostMapping("/admin-interfase")
    public String viewAppointments() {
        return "doctors_time_table";
    }
}
