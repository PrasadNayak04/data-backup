package com.robosoft.EmployeeOneToOne.Modal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EmployeeProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int employee_profile_id;
    private String gender;
    private double height;

    public EmployeeProfile() {
    }

    public EmployeeProfile(int employee_profile_id, String gender, double height) {
        this.employee_profile_id = employee_profile_id;
        this.gender = gender;
        this.height = height;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}
