package com.example.sf_lab_2.repository;

import com.example.sf_lab_2.models.Doctor;
import com.example.sf_lab_2.repository.configs.DataBaseConfig;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class DoctorDAO {

    private final Connection connection = DataBaseConfig.getDataBaseConfig().getConnection();

    public void createDoctor(Doctor doctor){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Doctors (name, specification, number, email ) VALUES(?,?,?,?)");

            preparedStatement.setString(1, doctor.getName());
            preparedStatement.setString(2, doctor.getSpecification());
            preparedStatement.setString(3, doctor.getNumber());
            preparedStatement.setString(4, doctor.getEmail());

            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public Doctor getDoctorByID(int id){
        Doctor doctor = null;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Doctors WHERE id=?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            doctor = new Doctor();

            doctor.setId(resultSet.getInt("id"));
            doctor.setName(resultSet.getString("name"));
            doctor.setSpecification(resultSet.getString("specification"));
            doctor.setNumber(resultSet.getString("number"));
            doctor.setEmail(resultSet.getString("email"));

        } catch (SQLException throwables) {
            throwables.fillInStackTrace();
        }

        return doctor;
    }

    public Doctor getDoctorByName(String name){
        Doctor doctor = null;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Doctors WHERE name=?");
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            doctor = new Doctor();

            doctor.setId(resultSet.getInt("id"));
            doctor.setName(resultSet.getString("name"));
            doctor.setSpecification(resultSet.getString("specification"));
            doctor.setNumber(resultSet.getString("number"));
            doctor.setEmail(resultSet.getString("email"));

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return doctor;
    }

    public List<Doctor> getDoctorsBySpecification(String specification){
        List<Doctor> doctorsBySpecification = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Doctors WHERE specification=?");
            preparedStatement.setString(1, specification);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {

            }
            resultSet.next();

            Doctor doctor = new Doctor();

            doctor.setId(resultSet.getInt("id"));
            doctor.setName(resultSet.getString("name"));
            doctor.setSpecification(resultSet.getString("specification"));
            doctor.setNumber(resultSet.getString("number"));
            doctor.setEmail(resultSet.getString("email"));

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return doctorsBySpecification;
    }

    public void updateDoctor(int id, Doctor updetedDoctor){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Doctors SET name=?, specification=?, number=?, email=? WHERE id=?");

            preparedStatement.setString(1, updetedDoctor.getName());
            preparedStatement.setString(2, updetedDoctor.getSpecification());
            preparedStatement.setString(3, updetedDoctor.getNumber());
            preparedStatement.setString(4, updetedDoctor.getEmail());
            preparedStatement.setLong(5, id);

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void delDoctor(int id){
        try {
            PreparedStatement preparedStatement  = connection.prepareStatement("DELETE FROM Doctors WHERE id=?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<Doctor> allDoctors() {
        List<Doctor> doctors = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM Doctors";
            ResultSet resultSet = statement.executeQuery(SQL);
            while(resultSet.next()) {
                Doctor doctor = new Doctor();

                doctor.setId(resultSet.getInt("id"));
                doctor.setName(resultSet.getString("name"));
                doctor.setSpecification(resultSet.getString("specification"));
                doctor.setEmail(resultSet.getString("email"));
                doctor.setNumber(resultSet.getString("number"));

                doctors.add(doctor);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return doctors;
    }
}
