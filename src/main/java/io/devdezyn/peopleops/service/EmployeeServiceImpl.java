package io.devdezyn.peopleops.service;

import io.devdezyn.peopleops.dao.EmployeeDAO;
import io.devdezyn.peopleops.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }


    @Override
    @Transactional
    public List<Employee> getEmployees() {
        return employeeDAO.findAll();
    }

    @Override
    @Transactional
    public Employee getEmployee(Long id) {
        return employeeDAO.findById(id);
    }

    @Override
    @Transactional
    public void createEmployee(Employee employee) {
        employeeDAO.save(employee);
    }

    @Override
    @Transactional
    public void updateEmployee(Employee employee) {
        employeeDAO.update(employee);
    }

    @Override
    @Transactional
    public void deleteEmployee(Long id) {
        employeeDAO.deleteById(id);
    }
}
