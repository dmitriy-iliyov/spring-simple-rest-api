package com.example.sf_lab_6.services;

import com.example.sf_lab_6.entitys.AdminEntity;
import com.example.sf_lab_6.repositorys.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final AdminRepository adminRepository;

    @Transactional
    public void save(AdminEntity admin){
        adminRepository.save(admin);
    }
    @Transactional
    public Optional<AdminEntity> findById(Long id){
        return adminRepository.findById(id);
    }

    @Transactional
    public Iterable<AdminEntity> findAll(){
        return adminRepository.findAll();
    }

    @Transactional
    public void deleteById(Long id){
        adminRepository.deleteById(id);
    }
}
