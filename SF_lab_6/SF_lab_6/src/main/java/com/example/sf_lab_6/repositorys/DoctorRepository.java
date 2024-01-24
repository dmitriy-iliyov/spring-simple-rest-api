package com.example.sf_lab_6.repositorys;

import com.example.sf_lab_6.entitys.DoctorEntity;
import org.springframework.data.repository.CrudRepository;

public interface DoctorRepository extends CrudRepository<DoctorEntity,Long> {

}
