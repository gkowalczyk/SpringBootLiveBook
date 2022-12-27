package com.example.springbootlivebook.JDBC;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.sql.DataSource;

@EnableScheduling
@Configuration
public class Config {

    @Value("${url}")
    private String url;
    @Value("${dbUser}")
    private String dbUser;
    @Value("${password}")
    private String password;

    @Bean
    public DataSource dataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url(url);
        dataSourceBuilder.username(dbUser);
        dataSourceBuilder.password(password);
        dataSourceBuilder.driverClassName("com.mysql.jdbc.Driver");
        return dataSourceBuilder.build();
    }

    @Bean
    public JdbcTemplate getJdbcTemplate() {   // nakładka która komunikuje się z bazą danych, wszsytkie zapytania
        return new JdbcTemplate(dataSource());
    }
}
