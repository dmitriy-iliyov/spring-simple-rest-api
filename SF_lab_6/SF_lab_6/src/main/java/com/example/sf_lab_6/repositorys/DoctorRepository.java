package com.example.sf_lab_6.repositorys;

import com.example.sf_lab_6.entitys.DoctorEntity;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Collection;

public interface DoctorRepository extends ListCrudRepository<DoctorEntity,Long> {

    Collection<DoctorEntity> findBySpecification(String specification);
}
