import java.util.*;

public class Course {

    private String name;
    Student[] students;

    public Course(String name) {
        this.name = name;
        this.students = new Student[5];
        System.out.println(name+" Branch created");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public void showStudents(){
        for(Student s : students){
            System.out.println(s.getId() + " " + s.getName());
        }
    }
}
