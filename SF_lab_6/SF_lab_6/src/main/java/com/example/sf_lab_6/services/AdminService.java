package com.example.sf_lab_6.services;

import com.example.sf_lab_6.DTO.AdminDTO;
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
    public Optional<AdminDTO> findById(Long id){
        return adminRepository.findById(id).map(AdminDTO::entityData);
    }

    @Transactional
    public Iterable<AdminEntity> findAll(){
        return adminRepository.findAll();
    }

    @Transactional
    public void deleteById(Long id){
        adminRepository.deleteById(id);
    }

    public AdminDTO entityData(AdminEntity adminEntity){
        return AdminDTO.entityData(adminEntity);
    }
}
