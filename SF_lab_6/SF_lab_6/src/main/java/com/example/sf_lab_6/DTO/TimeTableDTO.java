package com.example.sf_lab_6.DTO;

import com.example.sf_lab_6.entitys.TimeTableEntity;


import lombok.Data;

@Data
public class TimeTableDTO {
    private Long doctorID;
    private String date;
    private String firstDayFrom;
    private String firstDayTo;
    private String secondDayFrom;
    private String secondDayTo;
    private String thirdDayFrom;
    private String thirdDayTo;
    private String forthDayFrom;
    private String forthDayTo;
    private String fifthDayFrom;
    private String fifthDayTo;
    private String sixthDayFrom;
    private String sixthDayTo;
    private String seventhDayFrom;
    private String seventhDayTo;
    public static TimeTableDTO entityToDTO(TimeTableEntity timeTableEntity) {
        TimeTableDTO timeTableDTO = new TimeTableDTO();
        timeTableDTO.setDoctorID(timeTableEntity.getId());
        timeTableDTO.setDate(timeTableEntity.getDate());
        timeTableDTO.setFirstDayFrom(timeTableEntity.getFirstDayFrom());
        timeTableDTO.setFirstDayTo(timeTableEntity.getFirstDayTo());
        timeTableDTO.setSecondDayFrom(timeTableEntity.getSecondDayFrom());
        timeTableDTO.setSecondDayTo(timeTableEntity.getSecondDayTo());
        timeTableDTO.setThirdDayFrom(timeTableEntity.getThirdDayFrom());
        timeTableDTO.setThirdDayTo(timeTableEntity.getThirdDayTo());
        timeTableDTO.setForthDayFrom(timeTableEntity.getForthDayFrom());
        timeTableDTO.setForthDayTo(timeTableEntity.getForthDayTo());
        timeTableDTO.setFifthDayFrom(timeTableEntity.getFifthDayFrom());
        timeTableDTO.setFifthDayTo(timeTableEntity.getFifthDayTo());
        timeTableDTO.setSixthDayFrom(timeTableEntity.getSixthDayFrom());
        timeTableDTO.setSixthDayTo(timeTableEntity.getSixthDayTo());
        timeTableDTO.setSeventhDayFrom(timeTableEntity.getSeventhDayFrom());
        timeTableDTO.setSeventhDayTo(timeTableEntity.getSeventhDayTo());
        return timeTableDTO;
    }
}
