package com.example.sf_lab_1_2;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SfLab12Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SfLab12Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello from Spring Boot");
    }
}


