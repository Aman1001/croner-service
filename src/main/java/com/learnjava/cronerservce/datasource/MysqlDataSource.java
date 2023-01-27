package com.learnjava.cronerservce.datasource;

import com.jolbox.bonecp.BoneCPConfig;
import com.jolbox.bonecp.BoneCPDataSource;
import com.learnjava.cronerservce.mapper.Mapper;

import javax.sql.DataSource;
import java.util.Map;

public class MysqlDataSource {
    public static DataSource getDataSource(Map<String,String> mysqlConfig) {
        BoneCPConfig boneCPConfig = Mapper.INSTANCE.getModelMapper().map(mysqlConfig, BoneCPConfig.class);
        return new BoneCPDataSource(boneCPConfig);
    }
}