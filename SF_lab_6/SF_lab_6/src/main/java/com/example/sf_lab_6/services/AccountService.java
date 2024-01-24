package com.example.sf_lab_6.services;

import com.example.sf_lab_6.DTO.AccountDTO;
import com.example.sf_lab_6.entitys.AccountEntity;
import com.example.sf_lab_6.repositorys.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    @Transactional
    public void save(AccountEntity account){
        accountRepository.save(account);
    }
    @Transactional
    public Optional<AccountDTO> findById(Long id){
        return accountRepository.findById(id).map(AccountDTO::entityData);
    }

    @Transactional
    public Iterable<AccountEntity> findAll(){
        return accountRepository.findAll();
    }

    @Transactional
    public void deleteById(Long id){
        accountRepository.deleteById(id);
    }

    public AccountDTO entityData(AccountEntity userEntity){
        return AccountDTO.entityData(userEntity);
    }
}