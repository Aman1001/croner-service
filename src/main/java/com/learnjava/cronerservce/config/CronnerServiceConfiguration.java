package com.learnjava.cronerservce.config;

import com.learnjava.cronerservce.dao.CronnerDao;
import com.learnjava.cronerservce.mapper.CronnerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
@Configuration
public class CronnerServiceConfiguration {
    @Qualifier(value = "cronnerDataSource")
    @Autowired
    private DataSource dataSource;
    @Autowired
    CronnerMapper cronnerMapper;

    @Bean
    @Primary
    public CronnerDao getCronnerDao() {
        return new CronnerDao(dataSource, cronnerMapper);
    }
}
