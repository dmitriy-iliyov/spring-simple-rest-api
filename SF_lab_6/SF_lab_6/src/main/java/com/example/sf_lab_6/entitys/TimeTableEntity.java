package com.example.sf_lab_6.entitys;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

import static jakarta.persistence.GenerationType.IDENTITY;

@Data
@Table
@Entity(name = "timetables")
public class TimeTableEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "doctor_id", updatable = false)
    private Long id;

    @Column(name = "date", nullable = false, columnDefinition = "TEXT")
    private String date;

    @Column(name = "firstdayfrom", nullable = false, columnDefinition = "TEXT")
    private String firstDayFrom;

    @Column(name = "firstdayto", nullable = false, columnDefinition = "TEXT")
    private String firstDayTo;

    @Column(name = "seconddayfrom", nullable = false, columnDefinition = "TEXT")
    private String secondDayFrom;

    @Column(name = "seconddayto", nullable = false, columnDefinition = "TEXT")
    private String secondDayTo;

    @Column(name = "thirddayfrom", nullable = false, columnDefinition = "TEXT")
    private String thirdDayFrom;

    @Column(name = "thirddayto", nullable = false, columnDefinition = "TEXT")
    private String thirdDayTo;

    @Column(name = "forthdayfrom", nullable = false, columnDefinition = "TEXT")
    private String forthDayFrom;

    @Column(name = "forthdayto", nullable = false, columnDefinition = "TEXT")
    private String forthDayTo;

    @Column(name = "fifthdayfrom", nullable = false, columnDefinition = "TEXT")
    private String fifthDayFrom;

    @Column(name = "fifthdayto", nullable = false, columnDefinition = "TEXT")
    private String fifthDayTo;

    @Column(name = "sixthdayfrom", nullable = false, columnDefinition = "TEXT")
    private String sixthDayFrom;

    @Column(name = "sixthdayto", nullable = false, columnDefinition = "TEXT")
    private String sixthDayTo;

    @Column(name = "seventhdayfrom", nullable = false, columnDefinition = "TEXT")
    private String seventhDayFrom;

    @Column(name = "seventhdayto", nullable = false, columnDefinition = "TEXT")
    private String seventhDayTo;

    @OneToOne
    @JoinColumn(name = "doctor_id")
    @MapsId
    private DoctorEntity doctor;
    public TimeTableEntity( ) {
        this.date = new Date().toString();
    }
}
