package com.example.sf_lab_6.entitys;

import jakarta.persistence.*;
import lombok.Data;

import static jakarta.persistence.GenerationType.IDENTITY;

@Data
@Table
@Entity(name = "accounts")
public class AccountEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "user_id", updatable = false)
    private Long id;
    private double balance;
    @OneToOne
    @JoinColumn(name = "user_id")
    @MapsId
    private UserEntity user;

    public AccountEntity() {
        double min = 100.0;
        double max = 20000.0;
        this.balance = (long) (min + (max - min) * Math.random());
    }
}
