package com.example.sf_lab_6.DTO;

import com.example.sf_lab_6.entitys.AdminEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AdminDTO {
    private Long id;
    private String name;
    private String password;

    public static AdminDTO entityData(AdminEntity admin){
        return new AdminDTO(admin.getId(), admin.getName(), admin.getPassword());
    }
}
