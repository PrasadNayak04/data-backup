package com.robosoft.HospitalManagement;

public class HospitalMain {

    public static void main(String[] args) {
        Hospital hospital = new Hospital("KMC");

        //Add departments to Hospital
        Department department1 = new Department("Cardiology");
        hospital.addDepartment(department1);
        Department department2 = new Department("Urology");
        hospital.addDepartment(department2);

        //Add doctors to department
        Doctor deptDoctor1 = new Doctor("PadmaKumar");
        hospital.addDoctorToDepartment(deptDoctor1, hospital.findDepartmentByName("Cardiology"));

        Doctor deptDoctor2 = new Doctor("Rajesh");
        hospital.addDoctorToDepartment(deptDoctor2, hospital.findDepartmentByName("Cardiology"));

        Doctor deptDoctor3 = new Doctor("Vivek");
        hospital.addDoctorToDepartment(deptDoctor3, hospital.findDepartmentByName("Urology"));

        Ward w1 = new Ward("Cardio1", deptDoctor1, 5);
        hospital.addWardToDepartment(w1, hospital.findDepartmentByName("Cardiology"));

        Ward w2 = new Ward("Cardio2", deptDoctor2, 5);
        hospital.addWardToDepartment(w2, hospital.findDepartmentByName("Cardiology"));

        Ward w3 = new Ward("Uro1", deptDoctor3, 5);
        hospital.addWardToDepartment(w3, hospital.findDepartmentByName("Urology"));

        //Person
        Person p1 = new Person("Ganesh", 35, "Male", 916556489);
        //Person register using helpdesk
        p1.register(new Person(p1.getName(), p1.getAge(), p1.getGender(), p1.getTelephoneNumber()), hospital.getHelpdesk());

        Person p2 = new Person("Harish", 38, "Male", 916556454);
        p2.register(new Person(p2.getName(), p2.getAge(), p2.getGender(), p2.getTelephoneNumber()), hospital.getHelpdesk());

        Person p3 = new Person("Suresh", 45, "Male", 897589447);
        p3.register(new Person(p3.getName(), p3.getAge(), p3.getGender(), p3.getTelephoneNumber()), hospital.getHelpdesk());

        System.out.println(hospital.getPatients());
        System.out.println(hospital.getMedicalFiles());

    }

}
