package com.robosoft.HospitalManagementJdbc.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Hospital {

    private String hospitalName;

    Helpdesk helpdesk;

    public Hospital(String hospitalName) {
        this.hospitalName = hospitalName;
        this.helpdesk = new Helpdesk();
    }

}
