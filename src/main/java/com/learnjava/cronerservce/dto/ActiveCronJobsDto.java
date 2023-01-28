package com.learnjava.cronerservce.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class ActiveCronJobsDto extends BaseDto implements Serializable {
    private long id;
    private String baseUrl;
    private String endPoint;
    private String cronString;
    private String status;
}
