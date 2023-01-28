package com.learnjava.cronerservce.config;

import com.learnjava.cronerservce.datasource.MysqlDataSource;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Data
@Configuration
@ConfigurationProperties("application")
@EnableTransactionManagement
public class CronerConfiguration {

    private Map<String, String> mysqlConfigCronner = new HashMap<>();


    @Bean(name = "cronnerDataSource")
    public DataSource createDataSourceBeanForCronner() {
        return MysqlDataSource.getDataSource(mysqlConfigCronner);
    }

    @Bean(name = "cronnerTx")
    public PlatformTransactionManager cronnerTransactionManager(){
        return new DataSourceTransactionManager(createDataSourceBeanForCronner());
    }
}
