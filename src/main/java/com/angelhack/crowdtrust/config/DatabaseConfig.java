package com.angelhack.crowdtrust.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig
{
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    public HikariConfig primaryHikariConfig() {
        return new HikariConfig();
    }

    @Bean(name = "primaryDataSource")
    public DataSource dataSource() {
        return new HikariDataSource(primaryHikariConfig());
    }

    @Bean(name = "primaryJdbcNamedTemplate")
    @Autowired
    public NamedParameterJdbcTemplate primaryJdbcNamedTemplate(@Qualifier("primaryDataSource") DataSource ds) {
        return new NamedParameterJdbcTemplate(ds);
    }

    @Bean(name = "primaryJdbcTemplate")
    @Autowired
    public JdbcTemplate primaryJdbcTemplate(@Qualifier("primaryDataSource") DataSource ds) {
        return new JdbcTemplate(ds);
    }
}
