package com.example.sf_lab_2.service;

import com.example.sf_lab_2.repositories.PolyclinicRepository;
import org.springframework.stereotype.Service;

//Користувач: перегляд розкладу часів прийому вказаного доктора, запис на прийом, відміна запису
@Service
public class UserService {
    private PolyclinicRepository timeTable;

    public UserService() {
    }

}
