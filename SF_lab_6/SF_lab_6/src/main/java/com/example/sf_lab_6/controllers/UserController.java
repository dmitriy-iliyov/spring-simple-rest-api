package com.example.sf_lab_6.controllers;


import com.example.sf_lab_6.DTO.DoctorDTO;
import com.example.sf_lab_6.DTO.TimeTableDTO;
import com.example.sf_lab_6.DTO.UserDTO;
import com.example.sf_lab_6.entitys.AccountEntity;
import com.example.sf_lab_6.entitys.UserEntity;
import com.example.sf_lab_6.services.AccountService;
import com.example.sf_lab_6.services.DoctorService;
import com.example.sf_lab_6.services.TimeTableService;
import com.example.sf_lab_6.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final DoctorService doctorService;
    private final AccountService accountService;
    private final TimeTableService timeTableService;

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
    @ResponseBody
    public UserDTO userSubmit(@ModelAttribute UserEntity user){
        AccountEntity accountEntity = new AccountEntity();
        user.setAccount(accountEntity);
        accountEntity.setUser(user);
        userService.save(user);
        accountService.save(accountEntity);
        return UserDTO.entityData(user);
    }

    @GetMapping("/get/{id}")
    @ResponseBody
    public Optional<UserDTO> getUser(@PathVariable("id") Long id){
        return userService.findById(id);
    }

    @GetMapping("/get/{id}/change")
    public String userFormForChange(@PathVariable("id") Long id, Model model){
        model.addAttribute("user", userService.findById(id));
        return "user_changing_form";
    }

    @PostMapping("/get/{id}/change")
    @ResponseBody
    public UserDTO userSubmitChanges(@ModelAttribute UserEntity user, Model model){
        this.userService.save(user);
        return UserDTO.entityData(user);
    }

    @DeleteMapping("/del/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delUser(@PathVariable("id") Long id){
        userService.deleteById(id);
        accountService.deleteById(id);
    }

    @GetMapping("/get-doctor/{id}")
    @ResponseBody
    public Optional<DoctorDTO> getDoctor(@PathVariable("id") Long id){
        return doctorService.findById(id);
    }

    @GetMapping("/doctors")
    //http://localhost:8080/user/doctors?spec=info
    //http://localhost:8080/user/doctors?spec=specification
    public String getDoctor(String spec, Model model){
        Collection<DoctorDTO> doctors;
        if(spec != null)
            doctors = doctorService.findBySpecification(spec);
        else
            doctors = doctorService.findAll();
        model.addAttribute("doctors", doctors);
        return "doctors_for_admins";
    }

    @GetMapping("/get-timetable/{id}")
    @ResponseBody
    public Optional<TimeTableDTO> getDoctorAppointment(@PathVariable("id") Long id){
        return timeTableService.findById(id);
    }
}
