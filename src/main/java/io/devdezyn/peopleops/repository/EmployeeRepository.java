package io.devdezyn.peopleops.repository;

import io.devdezyn.peopleops.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // add a method to sort by last name
    List<Employee> findAllByOrderByLastNameAsc();

    // search by name
    List<Employee> findByFirstNameContainsOrLastNameContainsAllIgnoreCase(String name, String lName);
}
