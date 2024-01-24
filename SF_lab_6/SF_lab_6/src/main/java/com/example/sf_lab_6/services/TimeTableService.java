package com.example.sf_lab_6.services;

import com.example.sf_lab_6.DTO.AccountDTO;
import com.example.sf_lab_6.DTO.TimeTableDTO;
import com.example.sf_lab_6.entitys.AccountEntity;
import com.example.sf_lab_6.entitys.TimeTableEntity;
import com.example.sf_lab_6.repositorys.TimeTableRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TimeTableService {

    private final TimeTableRepository timeTableRepository;

    @Transactional
    public void save(TimeTableEntity timeTable){
        timeTableRepository.save(timeTable);
    }
    @Transactional
    public Optional<TimeTableDTO> findById(Long id){
        return timeTableRepository.findById(id).map(TimeTableDTO::entityToDTO);
    }

    @Transactional
    public Iterable<TimeTableEntity> findAll(){
        return timeTableRepository.findAll();
    }

    @Transactional
    public void deleteById(Long id){
        timeTableRepository.deleteById(id);
    }

    public TimeTableDTO entityData(TimeTableEntity timeTableEntity){
        return TimeTableDTO.entityToDTO(timeTableEntity);
    }
}
