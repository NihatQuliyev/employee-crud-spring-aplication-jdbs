package com.company.employeecrudaplication.handler;

import com.company.employeecrudaplication.dto.response.ExceptionResponse;
import com.company.employeecrudaplication.enums.ExceptionEnum;
import com.company.employeecrudaplication.exception.NotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionResponse handle() {
        return ExceptionResponse.builder()
                .localDateTime(LocalDateTime.now())
                .massage(ExceptionEnum.EMPLOYEE_NOT_FOUND_EXCEPTION.getMessage())
                .build();

    }

}
