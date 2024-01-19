package com.example.sf_lab_2.controllers;

import com.example.sf_lab_2.models.TimeTable;
import com.example.sf_lab_2.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user-interface")
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

    @GetMapping("/get-doctor/{name}")
    public String getDoctor(@PathVariable("name") String doctor, Model model){
        return "current_doctor";
    }

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
