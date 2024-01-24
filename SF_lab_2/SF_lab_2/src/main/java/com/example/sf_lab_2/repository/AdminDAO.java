package com.example.sf_lab_2.repository;

import com.example.sf_lab_2.models.Admin;
import com.example.sf_lab_2.repository.configs.DataBaseConfig;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Component
public class AdminDAO {
    private final Connection connection = DataBaseConfig.getDataBaseConfig().getConnection();

    public void createAdmin(Admin admin){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Admins (name, password) VALUES(?,?)");

            preparedStatement.setString(1, admin.getName());
            preparedStatement.setString(2, admin.getPassword());

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void delAdmin(int id){
        try {
            PreparedStatement preparedStatement  = connection.prepareStatement("DELETE FROM Admins WHERE id=?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
