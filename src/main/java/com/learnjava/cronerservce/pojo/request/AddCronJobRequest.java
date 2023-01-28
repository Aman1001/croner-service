package com.learnjava.cronerservce.pojo.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddCronJobRequest {
    private String jobKey;
    private String cronString;
    private String baseUrl;
    private String endPoint;
    private String status;
}
