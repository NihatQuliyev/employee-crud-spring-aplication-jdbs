package com.company.employeecrudaplication.service.impl;

import com.company.employeecrudaplication.dto.requset.EmployeeDtoIdRequest;
import com.company.employeecrudaplication.dto.requset.EmployeeDtoRequest;
import com.company.employeecrudaplication.dto.response.EmployeeDtoResponse;
import com.company.employeecrudaplication.dto.response.ResponseDto;
import com.company.employeecrudaplication.exception.NotFoundException;
import com.company.employeecrudaplication.model.Employee;
import com.company.employeecrudaplication.repository.EmployeeRepository;
import com.company.employeecrudaplication.service.EmployeeService;

import lombok.RequiredArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<EmployeeDtoResponse> findAll() {
        return employeeRepository.findAll().stream()
                .map(employee -> modelMapper.map(employee,EmployeeDtoResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDtoResponse findById(Long id) {
        return modelMapper.map(
                employeeRepository.findById(id).orElseThrow(NotFoundException::new),EmployeeDtoResponse.class);
    }

    @Override
    public ResponseDto insert(EmployeeDtoRequest employeeDto) {
        return employeeRepository.insert(modelMapper.map(employeeDto,Employee.class))  >0
                ? new ResponseDto("Employee created successfully") :
                new ResponseDto("Employee created failed");
    }

    @Override
    public ResponseDto update(EmployeeDtoIdRequest employeeDtoIdRequest) {
        return employeeRepository.update(modelMapper.map(employeeDtoIdRequest,Employee.class)) >0
                ? new ResponseDto("Employee updated successfully") :
                new ResponseDto("Employee updated failed");

    }

    @Override
    public ResponseDto delete(Long id) {
        return employeeRepository.delete(id) >0
                ? new ResponseDto("Employee deleted successfully") :
                new ResponseDto("Employee deleted failed");

    }
}
