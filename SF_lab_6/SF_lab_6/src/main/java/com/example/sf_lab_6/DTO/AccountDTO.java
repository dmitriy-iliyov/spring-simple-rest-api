package com.example.sf_lab_6.DTO;

import com.example.sf_lab_6.entitys.AccountEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountDTO {
    private Long id;
    private double balance;

    public static AccountDTO entityData(AccountEntity account){
        return new AccountDTO(account.getId(), account.getBalance());
    }
}
