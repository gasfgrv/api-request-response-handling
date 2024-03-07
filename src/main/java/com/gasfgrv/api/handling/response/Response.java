package com.gasfgrv.api.handling.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Response<T> {
    private String status;
    private String result;
    private ResponseError error;
    private T data;
}
