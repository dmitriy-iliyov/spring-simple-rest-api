package com.example.sf_lab_6.DTO;


import com.example.sf_lab_6.entitys.DoctorEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DoctorDTO {
    private Long id;
    private String name;
    private String specification;
    private String number;
    private String email;


    public static DoctorDTO entityData(DoctorEntity doctor){
        return new DoctorDTO(doctor.getId(), doctor.getName(), doctor.getSpecification(), doctor.getNumber(), doctor.getEmail());
    }
}

