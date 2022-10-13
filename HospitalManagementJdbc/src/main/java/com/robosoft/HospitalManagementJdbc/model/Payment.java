package com.robosoft.HospitalManagementJdbc.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Payment {

    private int paymentId;
    private int appointmentId;
    private int amount;

    public Payment(int appointmentId, int amount) {
        this.appointmentId = appointmentId;
        this.amount = amount;
    }

}
