package com.robosoft.HospitalManagementJdbc.service;

import com.robosoft.HospitalManagementJdbc.model.Department;
import com.robosoft.HospitalManagementJdbc.model.Doctor;
import com.robosoft.HospitalManagementJdbc.model.Ward;

public interface HospitalServices {

    public String addDepartment(Department department);
    public String addDoctorToDepartment(Doctor doctor);
    public String addWard(Ward ward);
}
