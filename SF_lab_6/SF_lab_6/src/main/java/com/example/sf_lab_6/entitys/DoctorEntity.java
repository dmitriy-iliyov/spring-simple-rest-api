package com.example.sf_lab_6.entitys;


import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity(name = "doctors")
public class DoctorEntity {

    @Id
    @SequenceGenerator(name = "doctor_sequence", sequenceName = "doctor_sequence", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "doctor_sequence")
    @Column(name = "id", updatable = false)
    private Long id;
    @Column(name = "name", nullable = false, columnDefinition = "TEXT")
    private String name;
    @Column(name = "specification", nullable = false, columnDefinition = "TEXT")
    private String specification;
    @Column(name = "number", nullable = false, columnDefinition = "TEXT")
    private String number;
    @Column(name = "email", nullable = false, columnDefinition = "TEXT", unique = true)
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", specification='" + specification + '\'' +
                ", number='" + number + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
