package io.devdezyn.peopleops.dao;

import io.devdezyn.peopleops.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    public List<Employee> findAll();

    public Employee findById(Long id);

    public void save(Employee employee);

    public void update(Employee employee);

    public void deleteById(Long id);
}
