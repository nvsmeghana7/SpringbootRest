package com.example.springbootrest.controller;

import com.example.springbootrest.model.Employee;
import com.example.springbootrest.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        super();
        this.employeeService = employeeService;
    }

    //build create employee REST API
    @PostMapping
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {

        return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }

    //build get all employees rest API
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    //build get employee by id
    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long id) {
        return new ResponseEntity<Employee>(employeeService.getEmployeebyId(id), HttpStatus.OK);
    }

    //build update Employee Rest Api
    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id
            , @RequestBody Employee employee) {
        return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id) {

        // delete employee from DB
        employeeService.deleteEmployee(id);

        return new ResponseEntity<String>("Employee deleted successfully!.", HttpStatus.OK);
    }
}