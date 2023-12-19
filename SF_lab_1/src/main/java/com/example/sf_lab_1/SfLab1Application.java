package com.example.sf_lab_1;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class SfLab1Application implements CommandLineRunner {

    public static void main(String[] args) {
        System.out.println("Begin of main");
        SpringApplication.run(SfLab1Application.class, args);
        System.out.println("End of main");
    }

    @Override
    @Order(2)
    public void run(String... args) throws Exception {
        System.out.println("Hello from Spring Boot");
    }
}

@Component
@Order(1)
class First implements CommandLineRunner{
    @Override
    public void run(String... args) throws Exception {
        System.out.println("First");
    }
}

@Component
class Second implements CommandLineRunner{
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Second");
    }
}

