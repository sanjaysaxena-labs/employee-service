package com.saxena.employee_service.service;

import com.saxena.employee_service.entity.Employee;
import com.saxena.employee_service.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository; // 1. Create a fake repository

    @InjectMocks
    private EmployeeService employeeService; // 2. Create a REAL service and plug the fake repository into it

    @Test
    void testGetEmployeeById(){

        Employee mockEmployee = new Employee();
        mockEmployee.setId(1L);
        mockEmployee.setName("John Doe");
        mockEmployee.setEmail("abc@email.com");

        Mockito.when(employeeRepository.findById(any())).thenReturn(Optional.of(mockEmployee));
        Employee employee=employeeService.getEmployeeById(1L);

        assertEquals(mockEmployee.getName(), employee.getName());

    }


}
