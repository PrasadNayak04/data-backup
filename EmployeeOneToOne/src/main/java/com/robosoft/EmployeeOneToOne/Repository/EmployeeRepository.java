package com.robosoft.EmployeeOneToOne.Repository;

import com.robosoft.EmployeeOneToOne.Modal.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
