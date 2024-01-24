package com.example.sf_lab_6.entitys;


import java.util.Date;

public class TimeTableEntity {

    private Integer doctorID;
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

    public TimeTableEntity(int doctorID) {
        this.doctorID = doctorID;
        this.date = new Date().toString();
    }

    public Integer getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(Integer doctorID) {
        this.doctorID = doctorID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFirstDayFrom() {
        return firstDayFrom;
    }

    public String getFirstDayTo() {
        return firstDayTo;
    }

    public String getSecondDayFrom() {
        return secondDayFrom;
    }

    public String getSecondDayTo() {
        return secondDayTo;
    }

    public String getThirdDayFrom() {
        return thirdDayFrom;
    }

    public String getThirdDayTo() {
        return thirdDayTo;
    }

    public String getForthDayFrom() {
        return forthDayFrom;
    }

    public String getForthDayTo() {
        return forthDayTo;
    }

    public String getFifthDayFrom() {
        return fifthDayFrom;
    }

    public String getFifthDayTo() {
        return fifthDayTo;
    }

    public String getSixthDayFrom() {
        return sixthDayFrom;
    }

    public String getSixthDayTo() {
        return sixthDayTo;
    }

    public String getSeventhDayFrom() {
        return seventhDayFrom;
    }

    public String getSeventhDayTo() {
        return seventhDayTo;
    }

    public void setFirstDayFrom(String firstDayFrom) {
        this.firstDayFrom = firstDayFrom;
    }

    public void setFirstDayTo(String firstDayTo) {
        this.firstDayTo = firstDayTo;
    }

    public void setSecondDayFrom(String secondDayFrom) {
        this.secondDayFrom = secondDayFrom;
    }

    public void setSecondDayTo(String secondDayTo) {
        this.secondDayTo = secondDayTo;
    }

    public void setThirdDayFrom(String thirdDayFrom) {
        this.thirdDayFrom = thirdDayFrom;
    }

    public void setThirdDayTo(String thirdDayTo) {
        this.thirdDayTo = thirdDayTo;
    }

    public void setForthDayFrom(String forthDayFrom) {
        this.forthDayFrom = forthDayFrom;
    }

    public void setForthDayTo(String forthDayTo) {
        this.forthDayTo = forthDayTo;
    }

    public void setFifthDayFrom(String fifthDayFrom) {
        this.fifthDayFrom = fifthDayFrom;
    }

    public void setFifthDayTo(String fifthDayTo) {
        this.fifthDayTo = fifthDayTo;
    }

    public void setSixthDayFrom(String sixthDayFrom) {
        this.sixthDayFrom = sixthDayFrom;
    }

    public void setSixthDayTo(String sixthDayTo) {
        this.sixthDayTo = sixthDayTo;
    }

    public void setSeventhDayFrom(String seventhDayFrom) {
        this.seventhDayFrom = seventhDayFrom;
    }

    public void setSeventhDayTo(String seventhDayTo) {
        this.seventhDayTo = seventhDayTo;
    }

    @Override
    public String toString() {
        return "TimeTable{" +
                "firstDayFrom='" + firstDayFrom + '\'' +
                ", firstDayTo='" + firstDayTo + '\'' +
                ", secondDayFrom='" + secondDayFrom + '\'' +
                ", secondDayTo='" + secondDayTo + '\'' +
                ", thirdDayFrom='" + thirdDayFrom + '\'' +
                ", thirdDayTo='" + thirdDayTo + '\'' +
                ", forthDayFrom='" + forthDayFrom + '\'' +
                ", forthDayTo='" + forthDayTo + '\'' +
                ", fifthDayFrom='" + fifthDayFrom + '\'' +
                ", fifthDayTo='" + fifthDayTo + '\'' +
                ", sixthDayFrom='" + sixthDayFrom + '\'' +
                ", sixthDayTo='" + sixthDayTo + '\'' +
                ", seventhDayFrom='" + seventhDayFrom + '\'' +
                ", seventhDayTo='" + seventhDayTo + '\'' +
                '}';
    }
//    private int timeFrom;
//    private int timeTo;
//
//
//    public int getTimeFrom() {
//        return timeFrom;
//    }
//
//    public void setTimeFrom(int timeFrom) {
//        this.timeFrom = timeFrom;
//    }
//
//    public int getTimeTo() {
//        return timeTo;
//    }
//
//    public void setTimeTo(int timeTo) {
//        this.timeTo = timeTo;
//    }
//
//    @Override
//    public String toString() {
//        return "TimeTable{" +
//                "doctorID=" + doctorID +
//                ", date=" + date +
//                ", timeFrom=" + timeFrom +
//                ", timeTo=" + timeTo +
//                '}';
//    }

}
