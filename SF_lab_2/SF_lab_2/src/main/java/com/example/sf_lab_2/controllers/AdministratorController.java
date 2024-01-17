package com.example.sf_lab_2.controllers;

import com.example.sf_lab_2.models.Doctor;
import com.example.sf_lab_2.service.AdministratorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class AdministratorController {

    private AdministratorService administratorService;

    public AdministratorController(AdministratorService administratorService) {
        this.administratorService = administratorService;
    }

    @GetMapping("/")
    public String homPage(){
        return "home_page";
    }
    @GetMapping("/add-doctor")
    public String addDoctor(Model model){
        model.addAttribute("doctor", new Doctor());
        return "doctor_register_form";
    }
    @PostMapping("/add-doctor")
    public String submitDoctor(@ModelAttribute Doctor doctor, Model model){
        model.addAttribute("doctor", doctor);
        return "doctor_register_form";
    }
    @GetMapping("/admin-interface")
    public String setAppointments() {
        return "doctors_time_table";
    }
}
