package com.example.sf_lab_6.controllers;


import com.example.sf_lab_6.entitys.AdminEntity;
import com.example.sf_lab_6.entitys.DoctorEntity;
import com.example.sf_lab_6.services.AdminService;
import com.example.sf_lab_6.services.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdministratorController {

    private final AdminService administratorService;

    private final DoctorService doctorService;

    @GetMapping("")
    public String adminHomePage(){
        return "admin_home_page";
    }

    @GetMapping("/add")
    public String adminForm(Model model){
        model.addAttribute("admin", new AdminEntity());
        return "admin_register_form";
    }

    @PostMapping("/add")
    public String adminSubmit(@ModelAttribute AdminEntity admin){
        this.administratorService.save(admin);
        return "admin_register_form";
    }

    @DeleteMapping("/del/{id}")
    public String delAdmin(@PathVariable("id") Long id){
        this.administratorService.deleteById(id);
        return "redirect:/admin";
    }

    @GetMapping("/add-doctor")
    public String doctorForm(Model model){
        model.addAttribute("doctor", new DoctorEntity());
        return "doctor_register_form";
    }

    @PostMapping("/add-doctor")
    public String doctorSubmit(@ModelAttribute DoctorEntity doctor){
        this.doctorService.save(doctor);
        return "current_doctor_for_admin";
    }

    @GetMapping("/get-doctor/{id}")
    public String getDoctor(@PathVariable("id") Long id, Model model){
        model.addAttribute("doctor", this.doctorService.findById(id));
        return "current_doctor_for_admin";
    }

    @GetMapping("/doctors")
    public String getDoctors(Model model){
        model.addAttribute("doctors", this.doctorService.findAll());
        return "doctors_for_admins";
    }

    @GetMapping("/users")
    public String getUsers(Model model){
        return "users";
    }

    @GetMapping("/get-doctor/{id}/change")
    public String doctorFormForChange(@PathVariable("id") Long id, Model model){
        model.addAttribute("doctor", this.doctorService.findById(id));
        return "doctor_changing_form";
    }

    @PostMapping("/get-doctor/{id}/changed")
    public String doctorSubmitChanges(@ModelAttribute DoctorEntity doctor, Model model){
        this.doctorService.save(doctor);
        model.addAttribute("doctor", doctor);
        return "current_doctor_for_admin";
    }

    @PostMapping("/del-doctor/{id}")
    public String doctorSubmitChanges(@PathVariable("id") Long id){
        this.doctorService.deleteById(id);
        return "redirect:/admin/doctors";
    }

//    @GetMapping("/get-doctor/{id}/create-time-table")
//    public String appointmentsForm(Model model, @PathVariable("id") int id) {
//        model.addAttribute("timeTable", new TimeTable(id));
//        return "doctor_time_table";
//    }
//
//    @PostMapping("/get-doctor/{id}/create-time-table")
//    public String appointmentsSubmit(@ModelAttribute TimeTable timeTable, Model model){
//        this.doctorService.createTimeTable(timeTable);
//        model.addAttribute("timeTable", timeTable);
//        return "doctor_timetable_for_users";
//    }

//    @GetMapping("/admin/get-doctor/{id}/timetable")
//    public String getDoctorAppointment(@PathVariable("id") int id, Model model){
//        this.doctorService.getTimeTable(id);
//        return "dr_timetable_for_users";
//    }
}