package com.example.sf_lab_6.services;


import com.example.sf_lab_6.entitys.DoctorEntity;
import com.example.sf_lab_6.repositorys.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DoctorService {

    private final DoctorRepository doctorRepository;

    @Transactional
    public void save(DoctorEntity doctor){
        doctorRepository.save(doctor);
    }
    @Transactional
    public Optional<DoctorEntity> findById(Long id){
        return doctorRepository.findById(id);
    }

    @Transactional
    public Iterable<DoctorEntity> findAll(){
        return doctorRepository.findAll();
    }

    @Transactional
    public void deleteById(Long id){
        doctorRepository.deleteById(id);
    }
}
