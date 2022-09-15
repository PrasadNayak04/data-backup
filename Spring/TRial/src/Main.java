import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {



        System.out.println("Creating course");
        Course c1 = new Course("CSE");


        List<Student> students = new ArrayList<>();
        Student s1 = new Student(100, "Varun");
        Student s2 = new Student(101, "Varun2");
        students.add(s1);
        students.add(s2);

        c1.setStudents(students);

        c1.showStudents();

        c1.getStudents().remove(s1);
        System.out.println("Deleted successfully\n");

        c1.showStudents();


    }

}
