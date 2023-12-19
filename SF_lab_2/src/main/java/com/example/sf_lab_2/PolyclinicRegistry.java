package com.example.sf_lab_2;



//3. Компоненти рівня доступу до даних (@Repository) реалізуйте у вигляді заглушки (Stub або Fake).
//4. Рівень представлення реалізуйте у вигляді контролера (@Controller) та шаблонів (Thymeleaf) з мінімальною функціональністю, достатньою для демонстрації компонентів бізнес-логіки.
//5. На рівні сервісів (@Service) реалізуйте компоненти бізнес-логіки. При цьому в лабораторній роботі мають бути продемонстровані наступні можливості Spring Framework:
//- анотація @Component (@Repository, @Service, @Controller);
//- анотація @Bean;
//- створення бінів типу singleton та prototype;
//- ін’єкція залежностей через конструктор, сетер, та напряму у поле біна;

//Сутності: розклад, часи прийому, запис, доктор
//Актори: Адміністратор, Користувач


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PolyclinicRegistry {

    public static void main(String[] args) {
        SpringApplication.run(PolyclinicRegistry.class, args);
    }
}
