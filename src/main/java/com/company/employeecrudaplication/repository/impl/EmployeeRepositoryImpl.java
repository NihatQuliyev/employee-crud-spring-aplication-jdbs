package com.company.employeecrudaplication.repository.impl;

import com.company.employeecrudaplication.model.Employee;
import com.company.employeecrudaplication.query.EmployeeQuery;
import com.company.employeecrudaplication.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor

public class EmployeeRepositoryImpl implements EmployeeRepository {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Override
    public List<Employee> findAll() {
        return namedParameterJdbcTemplate.query(EmployeeQuery.EMPLOYEE_LIST,
                (rs,row) -> Employee.builder().
                        id(rs.getLong("id")).
                        name(rs.getString("name")).
                        email(rs.getString("email")).
                        salary(rs.getInt("salary")).
                        build()

        );
    }

    @Override
    public Optional<Employee> findById(Long id) {
        MapSqlParameterSource mapSqlParameterSource =new MapSqlParameterSource();
        mapSqlParameterSource.addValue("id",id);
        return namedParameterJdbcTemplate.query(EmployeeQuery.EMPLOYEE_FIND_BY_ID,
                mapSqlParameterSource,
                (rs,row) ->Employee.builder().
                        id(rs.getLong("id")).
                        name(rs.getString("name")).
                        email(rs.getString("email")).
                        salary(rs.getInt("salary")).
                        build()).
                stream().
                findFirst();
    }

    @Override
    public int insert(Employee employee) {
        return namedParameterJdbcTemplate.update(EmployeeQuery.INSERT_EMPLOYEE,
                new BeanPropertySqlParameterSource(employee));
    }

    @Override
    public int update(Employee employee) {
        return namedParameterJdbcTemplate.update(EmployeeQuery.UPDATE_EMPLOYEE,
                new BeanPropertySqlParameterSource(employee));
    }

    @Override
    public int delete(Long id) {
        return namedParameterJdbcTemplate.update(EmployeeQuery.DELETE_EMPLOYEE,
                new MapSqlParameterSource("id",id));

    }
}
