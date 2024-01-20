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

    @GetMapping("/get-doctor/{name}")
    public String getDoctor(@PathVariable("name") String doctor, Model model){
        return "current_doctor";
    }

    @GetMapping("/get-doctors")
    public String getDoctors(){
        return "doctors";
    }

    @PostMapping("/change-doctor")
    public String doctorSubmitChanges(@ModelAttribute Doctor doctor, Model model){
        model.addAttribute("doctor", doctor);
        System.out.println(doctor);
        //
        return "doctor_register_form";
    }

    @GetMapping("/change-doctor")
    public String doctorFormForChange(Model model){
        model.addAttribute("doctor", new Doctor());
        return "doctor_register_form";
    }

//    @DeleteMapping("/del-doctor")
//    public String doctorSubmitChanges(){
//
//    }

    @GetMapping("/doctor-time-table")
    public String appointmentsForm(Model model) {
        model.addAttribute("timeTable", new TimeTable());
        return "doctors_time_table";
    }

    @PostMapping("/doctor-time-table")
    public String appointmentsSubmit(@ModelAttribute TimeTable timeTable, Model model){
        model.addAttribute("timeTable", timeTable);
        System.out.println(timeTable);
        //
        return "doctors_time_table";
    }
}
