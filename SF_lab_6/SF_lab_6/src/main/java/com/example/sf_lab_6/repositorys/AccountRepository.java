package com.example.sf_lab_6.repositorys;

import com.example.sf_lab_6.entitys.AccountEntity;
import org.springframework.data.repository.CrudRepository;


public interface AccountRepository extends CrudRepository<AccountEntity,Long>{
}
