package com.example.sf_lab_2.controllers;

import com.example.sf_lab_2.models.Admin;
import com.example.sf_lab_2.models.Doctor;
import com.example.sf_lab_2.models.TimeTable;
import com.example.sf_lab_2.service.AdministratorService;
import com.example.sf_lab_2.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/admin")
public class AdministratorController {

    private AdministratorService administratorService;
    private DoctorService doctorService;

    @Autowired
    public AdministratorController(AdministratorService administratorService, DoctorService doctorService) {
        this.administratorService = administratorService;
        this.doctorService = doctorService;
    }

    @GetMapping("")
    public String adminHomePage(){
        return "admin_home_page";
    }

    @GetMapping("/add")
    public String adminForm(Model model){
        model.addAttribute("admin", new Admin());
        return "admin_register_form";
    }

    @PostMapping("/add")
    public String adminSubmit(@ModelAttribute Admin admin){
        this.administratorService.create(admin);
        return "admin_register_form";
    }

    @DeleteMapping("/del/{id}")
    public String delAdmin(@PathVariable("id") int id){
        this.administratorService.delete(id);
        return "redirect:/admin";
    }

    @GetMapping("/add-doctor")
    public String doctorForm(Model model){
        model.addAttribute("doctor", new Doctor());
        return "doctor_register_form";
    }

    @PostMapping("/add-doctor")
    public String doctorSubmit(@ModelAttribute Doctor doctor){
        this.doctorService.createDoctor(doctor);
        return "current_doctor_for_admin";
    }

    @GetMapping("/get-doctor/{value}")
    public <T> String getDoctor(@PathVariable("value") T value, Model model){
        model.addAttribute("doctor", this.doctorService.getDoctor(value));
        return "current_doctor_for_admin";
    }

    @GetMapping("/doctors")
    public String getDoctors(Model model){
        model.addAttribute("doctors", this.doctorService.allDoctors());
        return "doctors_for_admins";
    }

    @GetMapping("/users")
    public String getUsers(Model model){
        return "users";
    }

    @GetMapping("/get-doctor/{id}/change")
    public <T> String doctorFormForChange(@PathVariable("id") T id, Model model){
        model.addAttribute("doctor", this.doctorService.getDoctor(id));
        return "doctor_changing_form";
    }

    @PostMapping("/get-doctor/{id}/changed")
    public String doctorSubmitChanges(@ModelAttribute Doctor doctor, Model model){
        this.doctorService.updateDoctor(doctor.getId(), doctor);
        model.addAttribute("doctor", doctor);
        return "current_doctor_for_admin";
    }

    @PostMapping("/del-doctor/{id}")
    public String doctorSubmitChanges(@PathVariable("id") int id){
        this.doctorService.deleteDoctor(id);
        return "redirect:/admin/doctors";
    }

    @GetMapping("/get-doctor/{id}/create-time-table")
    public String appointmentsForm(Model model, @PathVariable("id") int id) {
        model.addAttribute("timeTable", new TimeTable(id));
        return "doctor_time_table";
    }

    @PostMapping("/get-doctor/{id}/create-time-table")
    public String appointmentsSubmit(@ModelAttribute TimeTable timeTable, Model model){
        this.doctorService.createTimeTable(timeTable);
        model.addAttribute("timeTable", timeTable);
        return "doctor_timetable_for_users";
    }

//    @GetMapping("/admin/get-doctor/{id}/timetable")
//    public String getDoctorAppointment(@PathVariable("id") int id, Model model){
//        this.doctorService.getTimeTable(id);
//        return "dr_timetable_for_users";
//    }
}