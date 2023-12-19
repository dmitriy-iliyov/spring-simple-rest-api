package com.example.sf_lab_2.controllers;

import com.example.sf_lab_2.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/policlinic-registry")
    public String viewAppointments() {
        return "test1";
    }

    @GetMapping("/create-user")
    public String addUser(){
        return "create_user";
    }
}
