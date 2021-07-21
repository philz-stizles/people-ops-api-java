package io.devdezyn.peopleops.repository;

import io.devdezyn.peopleops.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
