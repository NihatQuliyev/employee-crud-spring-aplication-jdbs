package com.company.employeecrudaplication.query;

public class EmployeeQuery {

    public static final String EMPLOYEE_LIST = "select * from emp";

    public static final String EMPLOYEE_FIND_BY_ID = "select * from emp where id = :id";

    public static final String INSERT_EMPLOYEE = "insert into emp(name, email, salary) values(:name, :email, :salary)";

    public static final String UPDATE_EMPLOYEE = "update emp set name = :name, email = :email, salary = :salary where id = :id";

    public static final String DELETE_EMPLOYEE = "delete from emp where id = :id";
}
