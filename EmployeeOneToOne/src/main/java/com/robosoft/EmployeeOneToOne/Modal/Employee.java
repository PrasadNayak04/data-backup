package com.robosoft.EmployeeOneToOne.Modal;

import javax.persistence.*;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int emp_id;
    private String name;
    private String address;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    //@JoinColumn(name = "employee_profile_id", referencedColumnName = "employee_profile_id")
    private EmployeeProfile employeeProfile;

    public Employee() {
    }

    public Employee(String name, String address, EmployeeProfile employeeProfile) {
        this.name = name;
        this.address = address;
        this.employeeProfile = employeeProfile;
    }

    public int getId() {
        return emp_id;
    }

    public void setId(int id) {
        this.emp_id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public EmployeeProfile getEmployeeProfile() {
        return employeeProfile;
    }

    public void setEmployeeProfile(EmployeeProfile employeeProfile) {
        this.employeeProfile = employeeProfile;
    }
}
