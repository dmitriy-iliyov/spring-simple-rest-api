package com.example.sf_lab_2.repository;


import com.example.sf_lab_2.models.TimeTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;


@Component
public class TimeTableDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public TimeTableDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public <DateFormat> void createTimeTable(TimeTable timeTable){
        String sql = "INSERT INTO DoctorTimeTable (doctor_id, date, firstDayFrom, firstDayTo, secondDayFrom, secondDayTo," +
                " thirdDayFrom, thirdDayTo, forthDayFrom, forthDayTo, fifthDayFrom, fifthDayTo, sixthDayFrom, sixthDayTo, " +
                "seventhDayFrom, seventhDayTo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(sql,timeTable.getDoctorID(), timeTable.getDate(),timeTable.getFirstDayFrom(),
                timeTable.getFirstDayTo(), timeTable.getSecondDayFrom(), timeTable.getSecondDayTo(),
                timeTable.getThirdDayFrom(), timeTable.getThirdDayTo(), timeTable.getForthDayFrom(),
                timeTable.getForthDayTo(), timeTable.getFifthDayFrom(), timeTable.getFifthDayTo(),
                timeTable.getSixthDayFrom(), timeTable.getSixthDayTo(), timeTable.getSeventhDayFrom(),
                timeTable.getSeventhDayTo());

    }

    public TimeTable getTimeTable(int doctorID){
        return this.jdbcTemplate.query("SELECT * FROM DoctorTimeTable WHERE doctor_id=?", new Object[]{doctorID},
                        new BeanPropertyRowMapper<>(TimeTable.class)).stream().findAny().orElse(null);
    }


    public TimeTable getTimeTableByDate(String date){
        return this.jdbcTemplate.query("SELECT * FROM DoctorTimeTable WHERE date=?", new Object[]{},
                        new BeanPropertyRowMapper<>(TimeTable.class)).stream().findAny().orElse(null);
    }

    public void updateTimeTable(int doctorID, TimeTable updatedTimeTable){
        String sql = "UPDATE DoctorTimeTable SET date = ?, firstDayFrom = ?, firstDayTo = ?, secondDayFrom = ?, secondDayTo = ?, " +
                "thirdDayFrom = ?, thirdDayTo = ?, forthDayFrom = ?, forthDayTo = ?, fifthDayFrom = ?, fifthDayTo = ?, " +
                "sixthDayFrom = ?, sixthDayTo = ?, seventhDayFrom = ?, seventhDayTo = ? WHERE doctor_id = ?";

        this.jdbcTemplate.update(sql, updatedTimeTable.getFirstDayFrom(), updatedTimeTable.getFirstDayTo(),
                updatedTimeTable.getSecondDayFrom(), updatedTimeTable.getSecondDayTo(), updatedTimeTable.getThirdDayFrom(),
                updatedTimeTable.getThirdDayTo(), updatedTimeTable.getForthDayFrom(), updatedTimeTable.getForthDayTo(),
                updatedTimeTable.getFifthDayFrom(), updatedTimeTable.getFifthDayTo(), updatedTimeTable.getSixthDayFrom(),
                updatedTimeTable.getSixthDayTo(), updatedTimeTable.getSeventhDayFrom(), updatedTimeTable.getSeventhDayTo(),
                updatedTimeTable.getDoctorID(), updatedTimeTable.getDate());
    }

    public void delTimeTable(int doctorID){
        this.jdbcTemplate.update("DELETE FROM DoctorTimeTable WHERE doctor_id=?");
    }

}
