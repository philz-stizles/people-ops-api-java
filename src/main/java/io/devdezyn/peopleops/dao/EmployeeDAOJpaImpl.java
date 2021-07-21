package io.devdezyn.peopleops.dao;

import io.devdezyn.peopleops.entity.Employee;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

    // Define field for EntityManager
    private EntityManager entityManager;

    // Setup Constructor Injection
    @Autowired
    public EmployeeDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        // Create the query
        Query query = entityManager.createQuery("from Employee", Employee.class);

        // Execute query and get result
        List<Employee> employees = query.getResultList();

        // Return result
        return employees;
    }

    @Override
    public Employee findById(Long id) {
        // Get the Employee
        Employee employee = entityManager.find(Employee.class, id);

        // Return the result
        return employee;
    }

    @Override
    public void save(Employee employee) {
        // Get the current hibernate session
        Employee newEmployee = entityManager.merge(employee);

        // Update id to newly created Employee id
        employee.setId(newEmployee.getId());
    }

    @Override
    public void update(Employee employee) {
        // Get the current hibernate session
        Employee updatedEmployee = entityManager.merge(employee);
    }

    @Override
    public void deleteById(Long id) {
        // Delete target Employee using the primary key
        Query query = entityManager.createQuery("DELETE FROM Employee WHERE id=:employeeId");
        query.setParameter("employeeId", id);
        query.executeUpdate();

    }
}
