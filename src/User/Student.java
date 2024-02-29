package User;

import Course.Course;

import java.util.ArrayList;
import java.util.List;

public class Student extends User{
    public String studentNumber;
    public List<Course> studentCourses;
    int studentCredit;
    static List<String> studentNumbers = new ArrayList<>();

    public static List<Student> students = new ArrayList<>();
    public Student(String studentNumber, List<Course> studentCourses){
        this.studentNumber = studentNumber;
        this.studentCourses = studentCourses;
    }
}
