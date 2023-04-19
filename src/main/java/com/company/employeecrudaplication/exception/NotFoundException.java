package com.company.employeecrudaplication.exception;

import com.company.employeecrudaplication.enums.ExceptionEnum;

public class   NotFoundException extends RuntimeException {
    public NotFoundException() {
        super(ExceptionEnum.EMPLOYEE_NOT_FOUND_EXCEPTION.getMessage());

    }
}
