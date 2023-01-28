package com.learnjava.cronerservce.dao;

import com.learnjava.cronerservce.dto.ActiveCronJobsDto;
import com.learnjava.cronerservce.mapper.BaseRowMapper;
import com.learnjava.cronerservce.mapper.CronnerMapper;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.PreparedStatementCreator;

import javax.sql.DataSource;

public class CronnerDao extends MysqlBaseDao<Long, ActiveCronJobsDto>{
    public CronnerDao(DataSource dataSource,  BaseRowMapper<ActiveCronJobsDto> baseRowMapper) {
        super(dataSource,baseRowMapper);
    }

    @Override
    protected String getInsertQuery() {
        return null;
    }

    @Override
    protected String getFindByIdQuery() {
        return null;
    }

    @Override
    protected String getUpdateQuery() {
        return null;
    }

    @Override
    protected String getDeleteQuery() {
        return null;
    }

    @Override
    protected PreparedStatementCreator getInsertQueryStatementCreator(ActiveCronJobsDto value) {
        return null;
    }

    @Override
    protected PreparedStatementCallback getUpdateQueryStatementCallback(ActiveCronJobsDto value) {
        return null;
    }
}
