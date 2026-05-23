package com.saxena.employee_service.controller;

import com.saxena.employee_service.entity.Employee;
import com.saxena.employee_service.service.EmployeeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api")
@AllArgsConstructor
@Slf4j
public class EmployeeController {

    EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getAllEmployee() {
        log.info("Inside getAllEmployee method");
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        log.info("Inside getEmployeeById method");
        return employeeService.getEmployeeById(id);
    }

    @PostMapping("/employee")
    public Employee addEmployee(@RequestBody Employee employee) {
        log.info("Inside addEmployee method");
        return employeeService.saveEmployee(employee);
    }

    @PutMapping("/employee")
    public Employee updateEmployee(@RequestBody Employee employee) {
        log.info("Inside updateEmployee method");
        return employeeService.updateEmployee(employee);
    }

    @DeleteMapping("employee")
    public void deleteEmployee(@RequestBody Employee employee) {
        log.info("Inside deleteEmployee method");
        employeeService.deleteEmployee(employee);
    }
}
