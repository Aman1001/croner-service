package com.learnjava.cronerservce.pojo.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CronerBaseResonse<T> {
    private Integer code;
    private String message;
    private T data;
}
