package io.devdezyn.peopleops.dao;

import io.devdezyn.peopleops.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

    // Define field for EntityManager
    private EntityManager entityManager;

    // Setup Constructor Injection
    @Autowired
    public EmployeeDAOHibernateImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        // Get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // Create the query
        Query<Employee> query = currentSession.createQuery("from Employee", Employee.class);

        // Execute query and get result
        List<Employee> employees = query.getResultList();

        // Return result
        return employees;
    }

    @Override
    public Employee findById(Long id) {
        // Get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // Get the Employee
        Employee employee = currentSession.get(Employee.class, id);

        // Return the result
        return employee;
    }

    @Override
    public void save(Employee employee) {
        // Get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // Save new Employee
        currentSession.save(employee);
    }

    @Override
    public void update(Employee employee) {
        // Get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // Save new Employee
        currentSession.update(employee);
    }

    @Override
    public void deleteById(Long id) {
        // Get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // Delete target Employee using the primary key
        Query query = currentSession.createQuery("DELETE FROM Employee WHERE id=:employeeId");
        query.setParameter("employeeId", id);
        query.executeUpdate();

    }
}
