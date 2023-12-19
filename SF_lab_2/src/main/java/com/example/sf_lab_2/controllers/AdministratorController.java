package com.example.sf_lab_2.controllers;

import com.example.sf_lab_2.service.AdministratorService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class AdministratorController {

    private AdministratorService administratorService;

    public AdministratorController(AdministratorService administratorService) {
        this.administratorService = administratorService;
    }

    @GetMapping("/admin-interfase")
        public String viewAppointments() {
        return "doctors_time_table";
    }
}
