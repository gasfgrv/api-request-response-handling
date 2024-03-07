package com.gasfgrv.api.handling.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseError {

    private String code;
    private String message;
    private String description;

    public ResponseError(String code, String message) {
        this.code = code;
        this.message = message;
        this.description = message;
    }
    public ResponseError(String code, String message, String description) {
        this.code = code;
        this.message = message;
        this.description = description;
    }

}
