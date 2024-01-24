package com.example.sf_lab_6.controllers;


import com.example.sf_lab_6.entitys.UserEntity;
import com.example.sf_lab_6.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/")
    public String userHomePage(){
        return "user_home_page";
    }

    @GetMapping("/add")
    public String userForm(Model model){
        model.addAttribute("user", new UserEntity());
        return "user_register_form";
    }

    @PostMapping("/add")
    public String userSubmit(@ModelAttribute UserEntity user){
        this.userService.save(user);
        return "user_current";
    }

    @GetMapping("/get/{id}")
    public String getUser(@PathVariable("id") Long id, Model model){
        model.addAttribute("user", this.userService.findById(id));
        return "user_current";
    }

    @GetMapping("/get/{id}/change")
    public String userFormForChange(@PathVariable("id") Long id, Model model){
        model.addAttribute("user", this.userService.findById(id));
        return "user_changing_form";
    }

    @PostMapping("/get/{id}/changed")
    public String userSubmitChanges(@ModelAttribute UserEntity user, Model model){
        this.userService.save(user);
        model.addAttribute("user", user);
        return "user_current";
    }

    @PostMapping("/del/{id}")
    public String delUser(@PathVariable("id") Long id){
        this.userService.deleteById(id);
        return "redirect:/user/";
    }

//    @GetMapping("/get-doctor/{value}")
//    public <T> String getDoctor(@PathVariable("value") T value, Model model){
//        model.addAttribute("doctor", this.userService.getDoctor(value));
//        return "current_doctor_for_user";
//    }
//
//    @GetMapping("/get-doctors")
//    public String getDoctors(Model model){
//        model.addAttribute("doctors", this.userService.allDoctors());
//        return "doctors_for_users";
//    }

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
