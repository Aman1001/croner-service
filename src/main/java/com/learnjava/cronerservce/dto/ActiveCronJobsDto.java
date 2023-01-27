package com.learnjava.cronerservce.dto;

import lombok.Data;

@Data
public class ActiveCronJobsDto {
    private long id;
    private String baseUrl;
    private String endPoint;
    private String cronString;
}
