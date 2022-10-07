package com.robosoft.HospitalManagement;

import java.util.Scanner;

public class Helpdesk {

    Scanner scanner = new Scanner(System.in);
    Scanner scanner1 = new Scanner(System.in);
    private Hospital hospital;
    String patientType;
    public Helpdesk(Hospital hospital) {
        this.hospital = hospital;
    }

    public String getPatientType(){
        System.out.println("Enter type of patient (OPD/Admission)");
        return scanner.nextLine();
    }

    public void register(Person person) {
        Patient patient = new Patient(person.getName(), person.getAge(), person.getGender(), person.getTelephoneNumber());
        patientType = getPatientType();
        System.out.println("Department name : ");
        String departmentToVisit = scanner.nextLine();

        if(patientType.equalsIgnoreCase("OPD")) {
            System.out.println("Doctor name : ");
            String doctorToVisit = scanner.nextLine();

            hospital.sendOpdPatientToDepartment(patient, departmentToVisit, doctorToVisit);
        }

        else if(patientType.equalsIgnoreCase("Admission")){
            outPatientRegister(patient, departmentToVisit);
        }

        else {
            throw new IllegalArgumentException("Please provide valid patient type");
        }
    }

    public void outPatientRegister(Patient patient, String departmentToVisit){
        System.out.println("Enter number of days to admit");
        hospital.sendInPatientToDepartment(patient, departmentToVisit, scanner1.nextInt());
    }

}
