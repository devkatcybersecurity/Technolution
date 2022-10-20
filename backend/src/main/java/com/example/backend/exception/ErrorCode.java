package com.example.backend.exception;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum ErrorCode {

    STUDENT_NOT_FOUND(1004, "Student not found"),
    UNEXPECTED_ERROR(9999, "Unexpected error");

    private final Integer errorCode;
    private final String errorMessage;

    private ErrorCode(Integer errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

}
