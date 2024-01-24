package com.example.sf_lab_6.services;

import com.example.sf_lab_6.entitys.UserEntity;
import com.example.sf_lab_6.repositorys.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public void save(UserEntity user){
        userRepository.save(user);
    }
    @Transactional
    public Optional<UserEntity> findById(Long id){
        return userRepository.findById(id);
    }

    @Transactional
    public Iterable<UserEntity> findAll(){
        return userRepository.findAll();
    }

    @Transactional
    public void deleteById(Long id){
        userRepository.deleteById(id);
    }
}
