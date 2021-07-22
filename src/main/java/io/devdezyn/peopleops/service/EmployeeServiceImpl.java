package io.devdezyn.peopleops.service;

import io.devdezyn.peopleops.entity.Employee;
import io.devdezyn.peopleops.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(Long id) {
        Optional<Employee> result = employeeRepository.findById(id);

        Employee employee = null;

        if(result.isPresent()) {
            employee = result.get();
        } else {
            throw new RuntimeException("Employee not found");
        }

        return employee;
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> findBySearch(String search) {
        List<Employee> employees = null;

        if (search != null && (search.trim().length() > 0)) {
            employees = employeeRepository.findByFirstNameContainsOrLastNameContainsAllIgnoreCase(search, search);
        }
        else {
            employees = findAll();
        }

        return employees;
    }
}
