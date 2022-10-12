package com.robosoft.HospitalManagementJdbc.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Appointment {

    private int AppointmentId;
    private int patientId;
    private String departmentName;
    private String doctorName;

    public Appointment(int patientId, String departmentName, String doctorName) {
        this.patientId = patientId;
        this.departmentName = departmentName;
        this.doctorName = doctorName;
    }

}
