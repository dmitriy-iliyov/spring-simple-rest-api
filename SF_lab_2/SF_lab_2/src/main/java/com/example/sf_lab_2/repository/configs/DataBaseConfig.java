package com.example.sf_lab_2.repository.configs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConfig {
    private final String URL = "jdbc:postgresql://localhost:5432/policlinic_database";
    private final String USERNAME = "postgres";
    private final String PASSWORD = "postgres";

    private Connection connection;

    private static DataBaseConfig instance;

    private DataBaseConfig(){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static DataBaseConfig getDataBaseConfig(){
        if(instance == null)
            instance = new DataBaseConfig();
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    public String getURL() {
        return URL;
    }

    public String getUSERNAME() {
        return USERNAME;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }
}
