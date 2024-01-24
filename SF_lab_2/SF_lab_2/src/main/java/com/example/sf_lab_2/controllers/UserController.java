package com.example.sf_lab_2.controllers;

import com.example.sf_lab_2.models.User;
import com.example.sf_lab_2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String userHomePage(){
        return "user_home_page";
    }

    @GetMapping("/add")
    public String userForm(Model model){
        model.addAttribute("user", new User());
        return "user_register_form";
    }

    @PostMapping("/add")
    public String userSubmit(@ModelAttribute User user){
        this.userService.createUser(user);
        return "user_current";
    }

    @GetMapping("/get/{value}")
    public <T> String getUser(@PathVariable("value") T value, Model model){
        model.addAttribute("user", this.userService.getUser(value));
        return "user_current";
    }

    @GetMapping("/get/{id}/change")
    public <T> String userFormForChange(@PathVariable("id") T id,Model model){
        model.addAttribute("user", this.userService.getUser(id));
        return "user_changing_form";
    }

    @PostMapping("/get/{id}/changed")
    public String userSubmitChanges(@ModelAttribute User user, @PathVariable("id") int id, Model model){
        this.userService.updateUser(user.getId(), user);
        model.addAttribute("user", user);
        return "user_current";
    }

    @PostMapping("/del/{id}")
    public String delUser(@PathVariable("id") int id){
        this.userService.deleteUser(id);
        return "redirect:/user/";
    }

    @GetMapping("/get-doctor/{value}")
    public <T> String getDoctor(@PathVariable("value") T value, Model model){
        model.addAttribute("doctor", this.userService.getDoctor(value));
        return "current_doctor_for_user";
    }

    @GetMapping("/get-doctors")
    public String getDoctors(Model model){
        model.addAttribute("doctors", this.userService.allDoctors());
        return "doctors_for_users";
    }

//    @GetMapping("/doctor-time-table")
//    public String appointmentsForm(Model model) {
//        model.addAttribute("timeTable", new TimeTable());
//        return "doctors_time_table";
//    }
//
//    @PostMapping("/doctor-time-table")
//    public String appointmentsSubmit(@ModelAttribute TimeTable timeTable){
//        System.out.println(timeTable);
//        //
//        return "doctors_time_table";
//    }
}
