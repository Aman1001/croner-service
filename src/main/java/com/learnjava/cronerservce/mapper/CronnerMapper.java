package com.learnjava.cronerservce.mapper;

import com.learnjava.cronerservce.constant.CronerConstants;
import com.learnjava.cronerservce.dto.ActiveCronJobsDto;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class CronnerMapper implements BaseRowMapper<ActiveCronJobsDto>{
    @Override
    public ActiveCronJobsDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        return ActiveCronJobsDto.builder()
                .id(rs.getLong(CronerConstants.ID))
                .cronString(rs.getString(CronerConstants.CRON_JOB_STRING))
                .baseUrl(rs.getString(CronerConstants.CRON_JOB_BASE_URL))
                .endPoint(rs.getString(CronerConstants.CRON_JOB_END_POINT))
                .status(rs.getString(CronerConstants.CRON_JOB_STATUS))
                .build();
    }
}
