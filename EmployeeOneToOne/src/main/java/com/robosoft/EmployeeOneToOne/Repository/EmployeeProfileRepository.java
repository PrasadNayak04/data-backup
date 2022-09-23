package com.robosoft.EmployeeOneToOne.Repository;

import com.robosoft.EmployeeOneToOne.Modal.EmployeeProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeProfileRepository extends JpaRepository<EmployeeProfile, Integer> {
}
