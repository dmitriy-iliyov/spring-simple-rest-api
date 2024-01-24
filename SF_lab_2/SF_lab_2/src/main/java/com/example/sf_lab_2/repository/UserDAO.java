package com.example.sf_lab_2.repository;

import com.example.sf_lab_2.models.User;
import com.example.sf_lab_2.repository.configs.DataBaseConfig;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.*;

@Component
public class UserDAO {

    private final Connection connection = DataBaseConfig.getDataBaseConfig().getConnection();

    public Integer createUser(User user){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Users (name, email, number, password) VALUES(?,?,?,?)", Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getNumber());
            preparedStatement.setString(4, user.getPassword());

            preparedStatement.executeUpdate();

            ResultSet rs = preparedStatement.getGeneratedKeys();
            if(rs.next())
                return rs.getInt(1);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
//        String sql = "INSERT INTO Users (name, email, number, password) VALUES(?,?,?,?) RETURN id";
//        this.jdbcTemplate.update(sql, user.getName(), user.getEmail(), user.getNumber(), user.getPassword());
//        return Integer.parseInt(sql);
        return null;
    }

    public User getUserByID(int id){
        User user = null;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Users WHERE id=?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            user = new User();

            user.setId(resultSet.getInt("id"));
            user.setName(resultSet.getString("name"));
            user.setEmail(resultSet.getString("email"));
            user.setNumber(resultSet.getString("number"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return user;
    }

    public User getUserByName(String name){
        User user = null;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Users WHERE name=?");
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            user = new User();

            user.setId(resultSet.getInt("id"));
            user.setName(resultSet.getString("name"));
            user.setEmail(resultSet.getString("email"));
            user.setNumber(resultSet.getString("number"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return user;
    }

    public void updateUser(int id, User updatedUser){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Users SET name=?, email=?, number=?, password=? WHERE id=?");

            preparedStatement.setString(1, updatedUser.getName());
            preparedStatement.setString(2, updatedUser.getEmail());
            preparedStatement.setString(3, updatedUser.getNumber());
            preparedStatement.setString(4, updatedUser.getPassword());
            preparedStatement.setInt(5, id);

            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void delUser(int id){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Users WHERE id=?");
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
