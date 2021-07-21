package io.devdezyn.peopleops.rest;

import io.devdezyn.peopleops.entity.Employee;
import io.devdezyn.peopleops.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EmployeeRestController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employeeService.getEmployees();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable Long employeeId) {
        Employee existingEmployee = employeeService.getEmployee(employeeId);
        if(existingEmployee == null) {
            throw new RuntimeException("Employee not found");
        }

        return existingEmployee;
    }

    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee) {
        employee.setId((long) 0);
        employeeService.createEmployee(employee);

        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        employeeService.createEmployee(employee);

        return employee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public void deleteEmployee(@PathVariable Long employeeId) {
        Employee existingEmployee = employeeService.getEmployee(employeeId);

        // throw exception if null

        if (existingEmployee == null) {
            throw new RuntimeException("Employee not found");
        }

        employeeService.deleteEmployee(employeeId);
    }
}
