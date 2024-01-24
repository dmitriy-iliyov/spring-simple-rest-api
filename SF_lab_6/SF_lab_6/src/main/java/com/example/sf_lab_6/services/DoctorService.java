package com.example.sf_lab_6.services;


import com.example.sf_lab_6.DTO.DoctorDTO;
import com.example.sf_lab_6.entitys.DoctorEntity;
import com.example.sf_lab_6.repositorys.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
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
    public Optional<DoctorDTO> findById(Long id){
        return doctorRepository.findById(id).map(DoctorDTO::entityData);
    }

    @Transactional
    public Optional<DoctorEntity> findEntityById(Long id){
        return doctorRepository.findById(id);
    }

    @Transactional
    public Collection<DoctorDTO> findAll(){
        return doctorRepository.findAll().stream().map(DoctorDTO::entityData).toList();
    }

    @Transactional
    public Collection<DoctorDTO> findBySpecification(String specification){
        return doctorRepository.findBySpecification(specification).stream().map(DoctorDTO::entityData).toList();
    }

    @Transactional
    public void deleteById(Long id){
        doctorRepository.deleteById(id);
    }

    public DoctorDTO entityData(DoctorEntity doctorEntity){
        return DoctorDTO.entityData(doctorEntity);
    }
}
