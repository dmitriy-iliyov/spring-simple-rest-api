package com.example.sf_lab_2.controllers;

import com.example.sf_lab_2.models.Doctor;
import com.example.sf_lab_2.models.TimeTable;
import com.example.sf_lab_2.service.AdministratorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/admin-interface")
public class AdministratorController {

    private AdministratorService administratorService;

    public AdministratorController(AdministratorService administratorService) {
        this.administratorService = administratorService;
    }

    @GetMapping("")
    public String adminHomePage(){
        return "admin_home_page";
    }
    @GetMapping("/add-doctor")
    public String doctorForm(Model model){
        model.addAttribute("doctor", new Doctor());
        return "doctor_register_form";
    }
    @PostMapping("/add-doctor")
    public String doctorSubmit(@ModelAttribute Doctor doctor, Model model){
        model.addAttribute("doctor", doctor);
        System.out.println(doctor);
        //
        return "doctor_register_form";
    }
    @GetMapping("/get-doctor")
    public String chooseDoctor(){
        return "current_doctor";
    }
    @PostMapping("/get-doctor")
    public String doctorInfo(){
        //
        return "current_doctor";
    }
    @GetMapping("/doctors-time-table")
    public String appointmentsForm(Model model) {
        model.addAttribute("timeTable", new TimeTable());
        return "doctors_time_table";
    }
    @PostMapping("/doctors-time-table")
    public String appointmentsSubmit(@ModelAttribute TimeTable timeTable, Model model){
        model.addAttribute("timeTable", timeTable);
        System.out.println(timeTable);
        //
        return "doctors_time_table";
    }
}
