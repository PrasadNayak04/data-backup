package com.robosoft.HospitalManagementJdbc.model;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class Helpdesk {

    private int helpdeskId;

    private String hospitalName;

    public Helpdesk(String hospitalName) {
        this.hospitalName = hospitalName;
    }

}
