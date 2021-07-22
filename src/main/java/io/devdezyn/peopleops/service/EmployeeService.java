package io.devdezyn.peopleops.service;

import io.devdezyn.peopleops.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    Employee findById(Long id);

    void save(Employee employee);

    void deleteById(Long id);

    List<Employee> findBySearch(String search);
}
