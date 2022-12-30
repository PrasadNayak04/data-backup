package com.robosoft.department_service.repository;

import com.robosoft.department_service.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    Department getDepartmentByDepartmentId(Long departmentId);

}
