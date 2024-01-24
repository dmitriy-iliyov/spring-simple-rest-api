package com.example.sf_lab_6.DTO;

import com.example.sf_lab_6.entitys.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDTO {
    private Long id;
    private String name;
    private String email;
    private String number;
    private String password;

    public static UserDTO entityData(UserEntity user){
        return new UserDTO(user.getId(), user.getName(), user.getEmail(), user.getNumber(), user.getPassword());
    }
}
