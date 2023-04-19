package com.company.employeecrudaplication.controller;

import com.company.employeecrudaplication.dto.requset.EmployeeDtoIdRequest;
import com.company.employeecrudaplication.dto.requset.EmployeeDtoRequest;
import com.company.employeecrudaplication.dto.response.EmployeeDtoResponse;
import com.company.employeecrudaplication.dto.response.ResponseDto;
import com.company.employeecrudaplication.service.EmployeeService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/employees")

@Slf4j
public class EmployeeController {
    private final EmployeeService employeeService;


    @GetMapping
    public List<EmployeeDtoResponse> employees(){
        log.info("Get - /employees -> request none");
        var response = employeeService.findAll();
        log.info("Get - /employees - response -> {}",response);

        return employeeService.findAll();
    }

    @GetMapping("/{id}")
    public EmployeeDtoResponse employeeById(@PathVariable Long id) {
        log.info("Get - /employees/{} -> request ",id);
        var response = employeeService.findAll();
        log.info("Get - /employees/{} - response -> {}",id,response);
        return employeeService.findById(id);
    }

    @PostMapping
    public ResponseDto insert(@RequestBody EmployeeDtoRequest employeeDto){
        return employeeService.insert(employeeDto);
    }

    @PutMapping
    public ResponseDto update(@RequestBody EmployeeDtoIdRequest employeeDtoIdRequest) {
        return  employeeService.update(employeeDtoIdRequest);
    }

    @DeleteMapping("/{id}")
    public ResponseDto delete(@PathVariable Long id) {
        return employeeService.delete(id);
    }


}
