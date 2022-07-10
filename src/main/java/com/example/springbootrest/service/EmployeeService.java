package com.example.springbootrest.service;

import com.example.springbootrest.model.Employee;

import java.util.List;

public interface EmployeeService {

    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployees();

    Employee getEmployeebyId(long Id);

    Employee updateEmployee(Employee employee ,long Id);

    void deleteEmployee(long id);
}
