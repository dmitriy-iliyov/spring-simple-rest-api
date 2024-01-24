package com.example.sf_lab_6.controllers;


import com.example.sf_lab_6.DTO.AdminDTO;
import com.example.sf_lab_6.DTO.DoctorDTO;
import com.example.sf_lab_6.DTO.TimeTableDTO;
import com.example.sf_lab_6.entitys.AdminEntity;
import com.example.sf_lab_6.entitys.DoctorEntity;
import com.example.sf_lab_6.entitys.TimeTableEntity;
import com.example.sf_lab_6.services.AdminService;
import com.example.sf_lab_6.services.DoctorService;
import com.example.sf_lab_6.services.TimeTableService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;


@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdministratorController {

    private final AdminService administratorService;

    private final DoctorService doctorService;

    private final TimeTableService timeTableService;

    @GetMapping("")
    @ResponseBody
    public int adminHomePage(){
        return 0;
    }

    @GetMapping("/add")
    public String adminForm(Model model){
        model.addAttribute("admin", new AdminEntity());
        return "admin_register_form";
    }

    @PostMapping("/add")
    @ResponseBody
    public AdminDTO adminSubmit(@ModelAttribute AdminEntity admin){
        administratorService.save(admin);
        return administratorService.entityData(admin);
    }

    @DeleteMapping("/del/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delAdmin(@PathVariable("id") Long id){
        administratorService.deleteById(id);
    }

    @GetMapping("/add-doctor")
    public String doctorForm(Model model){
        model.addAttribute("doctor", new DoctorEntity());
        return "doctor_register_form";
    }

    @PostMapping("/add-doctor")
    @ResponseBody
    public DoctorDTO doctorSubmit(@ModelAttribute DoctorEntity doctor){
        doctorService.save(doctor);
        return doctorService.entityData(doctor);
    }

    @GetMapping("/get-doctor/{id}")
    @ResponseBody
    public Optional<DoctorDTO> getDoctor(@PathVariable("id") Long id){
        DoctorDTO doctorDTO = doctorService.findById(id).get();
        return doctorService.findById(id);
    }

    @GetMapping("/doctors")
    //http://localhost:8080/admin/doctors?spec=info
    //http://localhost:8080/admin/doctors?spec=specification
    public String getDoctor(String spec, Model model){
        Collection<DoctorDTO> doctors;
        if(spec != null)
            doctors = doctorService.findBySpecification(spec);
         else
            doctors = doctorService.findAll();
        model.addAttribute("doctors", doctors);
        return "doctors_for_admins";
    }


    @GetMapping("/users")
    public String getUsers(){
        return "users";
    }

    @GetMapping("/get-doctor/{id}/change")
    public String doctorFormForChange(@PathVariable("id") Long id, Model model){
        model.addAttribute("doctor", doctorService.findById(id));
        return "doctor_changing_form";
    }

    @PatchMapping("/get-doctor/{id}/changed")
    @ResponseBody
    public DoctorDTO doctorSubmitChanges(@ModelAttribute DoctorEntity doctor, Model model){
        doctorService.save(doctor);
        return DoctorDTO.entityData(doctor);
    }

    @DeleteMapping ("/del-doctor/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String doctorSubmitChanges(@PathVariable("id") Long id){
        doctorService.deleteById(id);
        return "redirect:/admin/doctors";
    }

    @GetMapping("/create-timetable/{id}")
    public String appointmentsForm(@PathVariable("id") Long id, Model model) {
        TimeTableEntity timeTableEntity = new TimeTableEntity();
        Optional<DoctorEntity> doctorEntity =  doctorService.findEntityById(id);
        timeTableEntity.setDoctor(doctorEntity.get());
        System.out.println(TimeTableDTO.entityToDTO(timeTableEntity));
        model.addAttribute("timeTable", timeTableEntity);
        return "doctor_time_table";
    }

    @PatchMapping("/create-timetable/{id}")
    @ResponseBody
    public TimeTableDTO appointmentsSubmit(@ModelAttribute TimeTableEntity timeTable){
        timeTableService.save(timeTable);
        Optional<DoctorEntity> optionalEntity =  doctorService.findEntityById(timeTable.getId());
        DoctorEntity doctorEntity = optionalEntity.get();
        doctorEntity.setTimeTable(timeTable);
        doctorService.save(doctorEntity);
        return TimeTableDTO.entityToDTO(timeTable);
    }

    @GetMapping("/get-timetable/{id}")
    @ResponseBody
    public Optional<TimeTableDTO> getDoctorAppointment(@PathVariable("id") Long id){
        return timeTableService.findById(id);
    }
}