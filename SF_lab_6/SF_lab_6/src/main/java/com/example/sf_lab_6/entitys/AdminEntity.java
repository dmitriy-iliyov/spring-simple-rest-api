package com.example.sf_lab_6.entitys;

import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Table
@Entity(name = "admins")
public class AdminEntity {
    @Id
    @SequenceGenerator(name = "admin_sequence", sequenceName = "admin_sequence", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "admin_sequence")
    @Column(name = "id", updatable = false)
    private Long id;
    @Column(name = "name", nullable = false, columnDefinition = "TEXT")
    private String name;
    @Column(name = "password", nullable = false, columnDefinition = "TEXT")
    private String password;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", passsword='" + password + '\'' +
                '}';
    }


}
