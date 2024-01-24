package com.example.sf_lab_6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableJpaRepositories
public class SfLab6Application {
    public static void main(String[] args) {
        SpringApplication.run(SfLab6Application.class, args);
    }
}
