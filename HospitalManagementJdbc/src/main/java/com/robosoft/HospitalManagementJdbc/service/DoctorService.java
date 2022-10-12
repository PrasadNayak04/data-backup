package com.robosoft.HospitalManagementJdbc.service;

import com.robosoft.HospitalManagementJdbc.model.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class DoctorService implements DoctorServices{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    String query;

    @Override
    public boolean isAvailable(Doctor doctor) {
        query = "select count(Doctor_Id) from Appointments where Doctor_Id = '" + doctor.getDoctorId() + "' and Department_Name = '" + doctor.getDepartmentName() + "'";
        int count = jdbcTemplate.queryForObject(query, Integer.class);
        if(count > 3){
            return false;
        }
        return true;
    }
    
}
