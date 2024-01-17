package com.example.sf_lab_2.controllers;

import com.example.sf_lab_2.models.Doctor;
import com.example.sf_lab_2.models.Greeting;
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
    public String homePage(){
        return "home_page";
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
        return "doctor_register_form";
    }
    @GetMapping("/get-doctor")
    public String doctorInfo(){

        return "doctor_register_form";
    }
    @GetMapping("/doctors-time-table")
    public String setAppointments() {
        return "doctors_time_table";
    }

    @GetMapping("/greeting")
    public String greetingForm(Model model) {
        model.addAttribute("greeting", new Greeting());
        return "greeting";
    }
    @PostMapping("/greeting")
    public void greetingSubmit(@ModelAttribute Greeting greeting, Model model) {
        model.addAttribute("greeting", greeting);
        System.out.println(greeting);
    }
}
