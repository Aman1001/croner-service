package com.learnjava.cronerservce.dao;

import com.learnjava.cronerservce.mapper.BaseRowMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;
import java.io.Serializable;

@Slf4j
public abstract class MysqlBaseDao<K, V extends Serializable> {
    protected final DataSource dataSource;

    protected final JdbcTemplate jdbcTemplate;

    protected final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    protected final BaseRowMapper<V> baseRowMapper;

    public MysqlBaseDao(DataSource dataSource, BaseRowMapper<V> baseRowMapper) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.baseRowMapper = baseRowMapper;
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(this.jdbcTemplate.getDataSource());
    }

    protected abstract String getInsertQuery();

    protected abstract String getFindByIdQuery();

    protected abstract String getUpdateQuery();

    protected abstract String getDeleteQuery();

    protected abstract PreparedStatementCreator getInsertQueryStatementCreator(V value);

    protected abstract PreparedStatementCallback getUpdateQueryStatementCallback(V value);

    public V findById(K id) {
        try {
            return jdbcTemplate.queryForObject(getFindByIdQuery(), new Object[]{id}, baseRowMapper);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public Long persist(V value) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        try {
            jdbcTemplate.update(getInsertQueryStatementCreator(value), keyHolder);
            return keyHolder.getKey().longValue();

        } catch (DataAccessException e){
            log.error("Error in persist "+e.getMessage());
            return null;
        }
    }

    public void update(V value) {
        jdbcTemplate.execute(getUpdateQuery(), getUpdateQueryStatementCallback(value));
    }

    public void delete(V value) {
    }

}
