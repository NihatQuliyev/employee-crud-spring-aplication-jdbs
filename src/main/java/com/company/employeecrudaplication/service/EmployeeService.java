package com.company.employeecrudaplication.service;

import com.company.employeecrudaplication.dto.requset.EmployeeDtoIdRequest;
import com.company.employeecrudaplication.dto.requset.EmployeeDtoRequest;
import com.company.employeecrudaplication.dto.response.EmployeeDtoResponse;
import com.company.employeecrudaplication.dto.response.ResponseDto;

import java.util.List;

public interface EmployeeService {

    List<EmployeeDtoResponse> findAll();
    EmployeeDtoResponse findById(Long id);
    ResponseDto insert(EmployeeDtoRequest employee);
    ResponseDto update(EmployeeDtoIdRequest employeeDtoIdRequest);

    ResponseDto delete(Long id);
}
