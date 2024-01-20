package com.example.sf_lab_2.controllers;

import com.example.sf_lab_2.models.Doctor;
import com.example.sf_lab_2.models.TimeTable;
import com.example.sf_lab_2.models.User;
import com.example.sf_lab_2.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public String userHomePage(){
        return "user_home_page";
    }

//    @GetMapping("/user-all-doctors")
//    public String allDoctors(){
//
//    }
    @GetMapping("/add")
    public String userForm(Model model){
        model.addAttribute("user", new User());
        return "user_register_form";
    }

    @PostMapping("/add")
    public String userSubmit(@ModelAttribute Doctor doctor, Model model){
        model.addAttribute("doctor", doctor);
        System.out.println(doctor);
        //
        return "user_register_form";
    }

    @GetMapping("/get/{name}")
    public String getUser(@PathVariable("name") String doctor, Model model){
        return "current_user";
    }

    @GetMapping("/get")
    public String getUser(){
        return "doctors";
    }

    @PostMapping("/change")
    public String userSubmitChanges(@ModelAttribute Doctor doctor, Model model){
        model.addAttribute("doctor", doctor);
        System.out.println(doctor);
        //
        return "user_register_form";
    }

    @GetMapping("/change")
    public String userFormForChange(Model model){
        model.addAttribute("doctor", new Doctor());
        return "user_register_form";
    }

    @GetMapping("/get-doctor/{name}")
    public String getDoctor(@PathVariable("name") String doctor, Model model){
        return "current_doctor";
    }

    @GetMapping("/get-doctor/time-table")
    public String appointmentsForm(Model model) {
        model.addAttribute("timeTable", new TimeTable());
        return "doctors_time_table";
    }

    @PostMapping("/get-doctor/time-table")
    public String appointmentsSubmit(@ModelAttribute TimeTable timeTable, Model model){
        model.addAttribute("timeTable", timeTable);
        System.out.println(timeTable);
        //
        return "doctors_time_table";
    }
}
