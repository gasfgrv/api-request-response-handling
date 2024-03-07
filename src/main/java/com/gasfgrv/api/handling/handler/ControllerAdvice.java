package com.gasfgrv.api.handling.handler;

import com.gasfgrv.api.handling.response.Response;
import com.gasfgrv.api.handling.response.ResponseBuilder;
import com.gasfgrv.api.handling.response.ResponseError;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Optional;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Response<Object>> handleRuntimeException(RuntimeException ex) {
        ResponseError erro = new ResponseError("500", ex.getMessage());
        return ResponseEntity.of(Optional.ofNullable(new ResponseBuilder<>().error(erro).build()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Response<Object>> handleException(Exception ex) {
        ResponseError erro = new ResponseError("500", ex.getMessage(), ex.getLocalizedMessage());
        return ResponseEntity.of(Optional.ofNullable(new ResponseBuilder<>().error(erro).build()));
    }

}
