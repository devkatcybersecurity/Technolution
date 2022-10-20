package com.example.backend.exception;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum ApiError {

    STUDENT_NOT_FOUND(1004, "Student Not Found"),
    MARK_NOT_FOUND(1014, "Mark Not Found"),
    GROUP_NOT_FOUND(1024, "Group Not Found"),
    UNEXPECTED_ERROR(9999, "Unexpected error");

    private final Integer ApiError;
    private final String errorMessage;

    private ApiError(Integer ApiError, String errorMessage) {
        this.ApiError = ApiError;
        this.errorMessage = errorMessage;
    }

}
