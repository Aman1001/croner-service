package com.learnjava.cronerservce.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import lombok.Getter;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

public enum Mapper {
    INSTANCE;

    private ModelMapper modelMapper = new ModelMapper();

    private ObjectMapper objectMapper = new ObjectMapper();

    @Getter
    private final ObjectMapper camelCaseObjectMapper = new ObjectMapper().setPropertyNamingStrategy(PropertyNamingStrategy.LOWER_CAMEL_CASE);


    private ObjectMapper snakeCaseEnabledObjectMapper = new ObjectMapper().setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);

    public ModelMapper getModelMapper() {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper;
    }

    public ObjectMapper getPlainObjectMapper() {
        return objectMapper;
    }

    public ObjectMapper getSnakeCaseEnabledObjectMapper() {
        return snakeCaseEnabledObjectMapper;
    }


}
