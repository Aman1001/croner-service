package com.learnjava.cronerservce.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class ConfigurationDto extends BaseDto{
    private Long id;
    private String key;
    private Map value;
}
