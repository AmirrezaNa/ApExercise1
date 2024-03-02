package Course;

import User.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Course {

    public Course(CourseType type, CourseDepartment department, String code,
                  String teacher, String title, int capacity, int credit,
                  int[] classTime, String examDate, List<Student> students, int members) {
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
        this.members = members;
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
    int members = 0;

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


    public static void addCourseForStudent(Student student) {
        System.out.println("write your course's code:");
        String courseCode = scanner.nextLine();
        boolean c = true;
        while (c) {
            for (Course course : Course.courses) {
                if (course.code.equals(courseCode)) {
                    c = false;
                    boolean a = true;
                    if (student.studentCourses.contains(course)) {
                        System.out.println("you already have this course!");
                    } else if (student.studentCourses.isEmpty()) {
                        student.studentCredit += course.credit;
                        course.members++;
                        student.studentCourses.add(course);
                        System.out.println("course added successfully.");
                    } else {
                        boolean d = true;
                        boolean e = true;
                        boolean f = true;
                        for (Course course1 : student.studentCourses) {
                            if (course1.classTime[0] == course.classTime[0]) {
                                if ((course.classTime[1] < course1.classTime[1] &&
                                        course.classTime[2] > course1.classTime[1]) ||
                                        (course1.classTime[1] < course.classTime[1] &&
                                                course1.classTime[2] > course.classTime[1])) {
                                    d = false;
                                }
                            }
                            if (course.examDate.equals(course1.examDate)) {
                                e = false;
                            }
                            if (student.studentCredit + course.credit > 20) {
                                f = false;
                            }
                        }
                        if (d == false){
                            System.out.println("you have a another class at this time.");
                        }
                        else if (e == false){
                            System.out.println("you have a another exam at this time.");
                        }
                        else if (f == false){
                            System.out.println("you can't take more than 20 credit.");
                        }
                        else if (d == true && e == true && f == true) {
                            student.studentCredit += course.credit;
                            course.members++;
                            student.studentCourses.add(course);
                            System.out.println("course added successfully.");
                        }
                    }

                }
            }
            if (c == true) {
                System.out.println("there's no such a course!");
                System.out.println("try again.");
                Course.addCourseForStudent(student);
            }
        }

        boolean b = true;
        while (b) {
            System.out.println("1.keep adding courses    2.done");
            int a = scanner.nextInt();
            if (a == 1) {
                b = false;
                String empty = scanner.nextLine();
                Course.addCourseForStudent(student);
            }
            if (a == 2) {
                b = false;
            } else if (a > 2) {
                System.out.println("try again!");
            }
        }

    }

    public static void removeCourseForStudent(Student student){
        System.out.println("write your course's code:");
        String courseCode = scanner.nextLine();
        boolean c = true;
        while (c){
            for (Course course: Course.courses){
                if (course.code.equals(courseCode)){
                    c = false;
                    if (student.studentCourses.contains(course)){
                        student.studentCourses.remove(course);
                        student.studentCredit -= course.credit;
                        course.members--;
                        course.students.remove(student);
                        System.out.println("course was removed successfully.");
                    }
                }
            }
            if (c = true){
                System.out.println("you don't have this course.");
                System.out.println("try again.");
            }
        }
    }
}
