package com.example.sf_lab_2;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class PolyclinicRegistry {
    public static void main(String[] args) {
        SpringApplication.run(PolyclinicRegistry.class, args);
    }
}
