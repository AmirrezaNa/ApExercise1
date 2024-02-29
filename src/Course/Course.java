package Course;

import User.Student;

import java.util.ArrayList;
import java.util.List;

public class Course {

    public Course(CourseType type, CourseDepartment department, String code,
                  String teacher, String title, int capacity, int credit,
                  int[] classTime, String examDate, List<Student> students) {
        this.department = department;
        this.code = code;
        this.teacher = teacher;
        this.title = title;
        this.capacity = capacity;
        this.credit = credit;
        this.classTime = classTime;
        this.examDate = examDate;
        this.students = students;
        this.type = type;
    }


    public CourseType type;
    CourseDepartment department;
    public String code;
    String teacher;
    String title;
    int capacity;
    int credit;
    int[] classTime = new int[3];
    String examDate;
    List<Student> students = new ArrayList<>();
    public static List<Course> courses = new ArrayList<>();
}
