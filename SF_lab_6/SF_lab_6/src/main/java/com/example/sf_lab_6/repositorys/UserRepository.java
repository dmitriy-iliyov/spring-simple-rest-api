package com.example.sf_lab_6.repositorys;

import com.example.sf_lab_6.entitys.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity,Long> {
}
