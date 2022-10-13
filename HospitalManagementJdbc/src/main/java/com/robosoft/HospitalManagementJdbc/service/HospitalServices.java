package com.robosoft.HospitalManagementJdbc.service;

import com.robosoft.HospitalManagementJdbc.model.Department;
import com.robosoft.HospitalManagementJdbc.model.Doctor;
import com.robosoft.HospitalManagementJdbc.model.Ward;
import org.springframework.stereotype.Service;

@Service
public interface HospitalServices {

    public String addDepartment(Department department);

    public String addDoctorToDepartment(Doctor doctor);

    public String addWard(Ward ward);

    public boolean isAvailable(Doctor doctor);

    public boolean isVacant(Ward ward);

}
