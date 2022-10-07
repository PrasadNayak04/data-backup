package com.robosoft.HospitalManagement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@AllArgsConstructor
public class Person implements PersonRegisterInterface{
    private String name;
    private int age;
    private String gender;
    private long telephoneNumber;

    @Override
    public void register(Person person, Helpdesk hd) {
        hd.register(person);
    }

}
