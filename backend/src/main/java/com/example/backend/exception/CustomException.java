package com.example.backend.exception;

import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Component
@Getter
@Setter
@ToString
public class CustomException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private Integer ApiError;
    private String errorMessage;

    public CustomException(){

    }

    public CustomException( Integer ApiError, String errorMessage) {
        super();
        this.ApiError = ApiError;
        this.errorMessage = errorMessage;
    }
}

