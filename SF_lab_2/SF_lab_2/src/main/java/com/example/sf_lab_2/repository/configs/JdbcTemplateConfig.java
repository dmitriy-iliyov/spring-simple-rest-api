package com.example.sf_lab_2.repository.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;

@Configuration
@ComponentScan("com.example.sf_lab_2")
@EnableWebMvc
public class JdbcTemplateConfig {

    DataBaseConfig dataBaseConfig = DataBaseConfig.getDataBaseConfig();

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl(dataBaseConfig.getURL());
        dataSource.setUsername(dataBaseConfig.getUSERNAME());
        dataSource.setPassword(dataBaseConfig.getPASSWORD());

        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }
}
