package Course;

import User.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

    static Scanner scanner = new Scanner(System.in);

    public static void showCourses() {
        System.out.println("choose department: 1.mathematical science   2.physics   3.computer engineering" +
                "   4.electrical engineering    5.chemistry   6.mechanic engineering");
        int chooseDepartment = scanner.nextInt();
        if (chooseDepartment == 1) {
            for (Course a : courses) {
                if (a.department.equals(CourseDepartment.mathematicalScience)) {
                    if (a.type.equals(CourseType.requiredCourse)) {
                        RequiredCourses.showCourseInformation(a);
                    } else {
                        SpecializedCourses.showCourseInformation(a);
                    }
                    System.out.println();
                }
            }
        } else if (chooseDepartment == 2) {
            for (Course a : courses) {
                if (a.department.equals(CourseDepartment.physics)) {
                    if (a.type.equals(CourseType.requiredCourse)) {
                        RequiredCourses.showCourseInformation(a);
                    } else {
                        SpecializedCourses.showCourseInformation(a);
                    }
                    System.out.println();
                }
            }
        } else if (chooseDepartment == 3) {
            for (Course a : courses) {
                if (a.department.equals(CourseDepartment.computerEngineering)) {
                    if (a.type.equals(CourseType.requiredCourse)) {
                        RequiredCourses.showCourseInformation(a);
                    } else {
                        SpecializedCourses.showCourseInformation(a);
                    }
                    System.out.println();
                }

            }
        } else if (chooseDepartment == 4) {
            for (Course a : courses) {
                if (a.department.equals(CourseDepartment.electricalEngineering)) {
                    if (a.type.equals(CourseType.requiredCourse)) {
                        RequiredCourses.showCourseInformation(a);
                    } else {
                        SpecializedCourses.showCourseInformation(a);
                    }
                    System.out.println();
                }

            }
        } else if (chooseDepartment == 5) {
            for (Course a : courses) {
                if (a.department.equals(CourseDepartment.chemistry)) {
                    if (a.type.equals(CourseType.requiredCourse)) {
                        RequiredCourses.showCourseInformation(a);
                    } else {
                        SpecializedCourses.showCourseInformation(a);
                    }
                    System.out.println();
                }

            }
        } else if (chooseDepartment == 6) {
            for (Course a : courses) {
                if (a.department.equals(CourseDepartment.mechanicalEngineering)) {
                    if (a.type.equals(CourseType.requiredCourse)) {
                        RequiredCourses.showCourseInformation(a);
                    } else {
                        SpecializedCourses.showCourseInformation(a);
                    }
                    System.out.println();
                }

            }
        }
        String empty = scanner.nextLine();
    }
}
