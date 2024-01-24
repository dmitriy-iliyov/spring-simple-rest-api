package com.example.sf_lab_2.repository;

import com.example.sf_lab_2.models.Account;
import com.example.sf_lab_2.repository.configs.DataBaseConfig;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class AccountDAO {
    private final Connection connection = DataBaseConfig.getDataBaseConfig().getConnection();

    public void createAccount(Account account){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Accounts (user_id, balance) VALUES(?,?)");

            preparedStatement.setInt(1, account.getUserID());
            preparedStatement.setDouble(2, account.getBalance());

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public Account getAccount(int userID){
        Account account = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Accounts WHERE user_id=?");
            preparedStatement.setInt(1, userID);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            account = new Account(userID);
            account.setUserID(resultSet.getInt("user_id"));
            account.setBalance(resultSet.getDouble("balance"));

        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return account;
    }

    public void delAccount(int userID){
        try {
            PreparedStatement preparedStatement  = connection.prepareStatement("DELETE FROM Accounts WHERE user_id=?");
            preparedStatement.setInt(1, userID);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
