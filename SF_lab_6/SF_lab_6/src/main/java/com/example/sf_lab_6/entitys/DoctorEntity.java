package com.example.sf_lab_6.entitys;


import jakarta.persistence.*;
import lombok.Data;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Data
@Table
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

    @OneToOne(mappedBy = "doctor", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private TimeTableEntity timeTable;

    public DoctorEntity getEntity(){
        return this;
    }
}
