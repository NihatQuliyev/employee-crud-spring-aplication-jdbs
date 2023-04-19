package com.company.employeecrudaplication.enums;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.RequiredArgsConstructor;


@Getter
@RequiredArgsConstructor
public enum ExceptionEnum {

    EMPLOYEE_NOT_FOUND_EXCEPTION(HttpStatus.NOT_FOUND,"Employee not found!");

    private final HttpStatus status;
    private final String message;
}
