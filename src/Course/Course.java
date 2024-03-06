package Course;

import EnteringTheProgram.EnterPage;
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
    int[] classTime;
    String examDate;
    List<Student> students;
    public static List<Course> courses = new ArrayList<>();
    int members = 0;

    static Scanner scanner = new Scanner(System.in);

    public static void showCourses() {
        System.out.println("choose department: 1.mathematical science   2.physics   3.computer engineering" +
                "   4.electrical engineering    5.chemistry   6.mechanic engineering");
        String chooseDepartment = EnterPage.scanner.nextLine();
        switch (chooseDepartment) {
            case "1" -> {
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
            }
            case "2" -> {
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
            }
            case "3" -> {
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
            }
            case "4" -> {
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
            }
            case "5" -> {
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
            }
            case "6" -> {
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
        }
    }


    public static void addCourseForStudent(Student student, String studentType) {
        System.out.println("1.course's code:       2.back     3.back to start     4.end program");
        String courseCode = scanner.nextLine();
        switch (courseCode) {
            case "2" -> {
                if (studentType.equals("s")) {
                    Student.studentSignupChoice(student);
                } else if (studentType.equals("l")) {
                    Student.studentLoginChoice(student);
                }
            }
            case "3" -> EnterPage.userType();
            case "4" -> System.exit(0);
            default -> {
                boolean courseExistence = true;
                while (courseExistence) {
                    for (Course course : Course.courses) {
                        if (course.code.equals(courseCode)) {
                            courseExistence = false;
                            boolean havingCourseAlready = true;
                            if (student.studentCourses.contains(course)) {
                                havingCourseAlready = false;
                                System.out.println("you already have this course!");
                                System.out.println("try again.");
                                Course.addCourseForStudent(student, studentType);
                            } else if (student.studentCourses.isEmpty()) {
                                student.studentCredit += course.credit;
                                course.members++;
                                student.studentCourses.add(course);
                                System.out.println("course added successfully.");
                            } else {
                                boolean havingAnotherClass = true;
                                boolean havingAnotherExam = true;
                                boolean checkStudentCredit = true;
                                for (Course course1 : student.studentCourses) {
                                    if (course1.classTime[0] == course.classTime[0]) {
                                        if ((course.classTime[1] < course1.classTime[1] &&
                                                course.classTime[2] > course1.classTime[1]) ||
                                                (course1.classTime[1] < course.classTime[1] &&
                                                        course1.classTime[2] > course.classTime[1])) {
                                            havingAnotherClass = false;
                                        }
                                    }
                                    if (course.examDate.equals(course1.examDate)) {
                                        havingAnotherExam = false;
                                    }
                                    if (student.studentCredit + course.credit > 20) {
                                        checkStudentCredit = false;
                                    }
                                }
                                if (!havingAnotherClass) {
                                    System.out.println("you have a another class at this time.");
                                } else if (!havingAnotherExam) {
                                    System.out.println("you have a another exam at this time.");
                                } else if (!checkStudentCredit) {
                                    System.out.println("you can't take more than 20 credit.");
                                } else {
                                    student.studentCredit += course.credit;
                                    course.members++;
                                    course.students.add(student);
                                    student.studentCourses.add(course);
                                    System.out.println("course added successfully.");
                                    Course.choiceAfterAddingCourse(student, course, studentType);
                                }
                            }

                        }
                    }
                    if (courseExistence) {
                        System.out.println("there's no such a course!");
                        System.out.println("try again.");
                        Course.addCourseForStudent(student, studentType);
                    }
                }

                boolean b = true;
                while (b) {
                    System.out.println("1.keep adding courses    2.done");
                    int a = scanner.nextInt();
                    if (a == 1) {
                        b = false;
                        String empty = scanner.nextLine();
                        Course.addCourseForStudent(student, studentType);
                    }
                    if (a == 2) {
                        b = false;
                    } else if (a > 2) {
                        System.out.println("try again!");
                    }
                }
            }
        }
    }


    public static void choiceAfterAddingCourse(Student student, Course course, String studentType){
        System.out.println("1.keep adding course      2.back(deleting the course you just added)     " +
                "3.back to start     4.end program");
        String keepAddingCourse = EnterPage.scanner.nextLine();
        if (keepAddingCourse.equals("1")){
            if (studentType.equals("s")){
                Student.studentSignupChoice(student);
            }
            else if (studentType.equals("l")){
                Student.studentLoginChoice(student);
            }

        }
        else if (keepAddingCourse.equals("2")){
            student.studentCredit -= course.credit;
            course.members--;
            course.students.remove(student);
            student.studentCourses.remove(course);
        }
        else if (keepAddingCourse.equals("3")){
            EnterPage.userType();
        }
        else if (keepAddingCourse.equals("4")){
            System.exit(0);
        }
        else {
            System.out.println("try again!");
            Course.choiceAfterAddingCourse(student, course, studentType);
        }
    }

    public static void removeCourseForStudent(Student student) {
        System.out.println("write your course's code:");
        String courseCode = scanner.nextLine();
        boolean courseExistence = true;
        while (courseExistence) {
            for (Course course : Course.courses) {
                if (course.code.equals(courseCode)) {
                    courseExistence = false;
                    if (student.studentCourses.contains(course)) {
                        student.studentCourses.remove(course);
                        student.studentCredit -= course.credit;
                        course.members--;
                        course.students.remove(student);
                        System.out.println("course was removed successfully.");
                    }
                }
            }
            if (!courseExistence) {
                System.out.println("you don't have this course.");
                System.out.println("try again.");
            }
        }
    }

    public static void creatingCourse() {
        System.out.println("1.special   2.required");
        int type1 = scanner.nextInt();
        System.out.println("department:   1.mathematical   2.physics  3.computerEngineering   4.electricalEngineering" +
                "    5.chemistry    6.mechanicalEngineering");

        int department1 = scanner.nextInt();
        String empty = scanner.nextLine();
        System.out.println("code:");
        String code1 = scanner.nextLine();
        System.out.println("teacher:");
        String teacher1 = scanner.nextLine();
        System.out.println("title:");
        String title1 = scanner.nextLine();
        System.out.println("capacity:");
        int capacity1 = scanner.nextInt();
        System.out.println("credit:");
        int credit1 = scanner.nextInt();
        System.out.println("class day:   1.saturday  2.sunday  3.monday   4.tuesday  5.wednesday");
        int classDay1 = scanner.nextInt();
        System.out.println("starting hour:");
        int startingHour1 = scanner.nextInt();
        System.out.println("finishingHour:");
        int finishingHour1 = scanner.nextInt();
        int[] classTime1 = {classDay1, startingHour1, finishingHour1};
        System.out.println("exam date:");
        String examDate1 = scanner.nextLine();
        List<Student> courseStudents1 = new ArrayList<>();
        int members = 0;
        if (type1 == 1) {
            if (department1 == 1) {
                SpecializedCourses courses1 = new SpecializedCourses(CourseType.specializedCourse,
                        CourseDepartment.mathematicalScience, code1, teacher1, title1, capacity1,
                        credit1, classTime1, examDate1, courseStudents1, members);
                Course.courses.add(courses1);
            } else if (department1 == 2) {
                SpecializedCourses courses1 = new SpecializedCourses(CourseType.specializedCourse,
                        CourseDepartment.physics, code1, teacher1, title1, capacity1,
                        credit1, classTime1, examDate1, courseStudents1, members);
                Course.courses.add(courses1);
            } else if (department1 == 3) {
                SpecializedCourses courses1 = new SpecializedCourses(CourseType.specializedCourse,
                        CourseDepartment.computerEngineering, code1, teacher1, title1, capacity1,
                        credit1, classTime1, examDate1, courseStudents1, members);
                Course.courses.add(courses1);
            } else if (department1 == 4) {
                SpecializedCourses courses1 = new SpecializedCourses(CourseType.specializedCourse,
                        CourseDepartment.electricalEngineering, code1, teacher1, title1, capacity1,
                        credit1, classTime1, examDate1, courseStudents1, members);
                Course.courses.add(courses1);
            } else if (department1 == 5) {
                SpecializedCourses courses1 = new SpecializedCourses(CourseType.specializedCourse,
                        CourseDepartment.chemistry, code1, teacher1, title1, capacity1,
                        credit1, classTime1, examDate1, courseStudents1, members);
                Course.courses.add(courses1);
            } else if (department1 == 6) {
                SpecializedCourses courses1 = new SpecializedCourses(CourseType.specializedCourse,
                        CourseDepartment.mechanicalEngineering, code1, teacher1, title1, capacity1,
                        credit1, classTime1, examDate1, courseStudents1, members);
                Course.courses.add(courses1);
            }
        }


    }

    public static void removingStudent() {
        System.out.println("enter the code of your course:");
        String courseCode = scanner.nextLine();
        for (Course course : courses) {
            if (course.code.equals(courseCode)) {
                for (Student student : course.students) {
                    System.out.println(student.studentNumber);
                }
                System.out.println("enter the code of your student:");
                String studentCode = scanner.nextLine();
                for (Student student : Student.students) {
                    if (student.studentNumber.equals(studentCode)) {
                        if (course.students.contains(student)) {
                            course.students.remove(student);
                            student.studentCourses.remove(course);
                            student.studentCredit -= course.credit;
                            course.members--;
                            System.out.println("student removed successfully.");
                        } else {
                            System.out.println("this student doesn't have this course.");
                        }
                    }
                }
            }
        }
    }

    public static void addingStudent() {
        System.out.println("enter the code of your course:");
        String courseCode = scanner.nextLine();
        for (Course course : courses) {
            if (course.code.equals(courseCode)) {
                System.out.println("enter the code of your student:");
                String studentCode = scanner.nextLine();
                for (Student student : Student.students) {
                    if (student.studentNumber.equals(studentCode)) {
                        if ((student.studentCredit + course.credit <= 20) && (course.members < course.capacity)) {
                            student.studentCourses.add(course);
                            student.studentCredit += course.credit;
                            course.members++;
                            course.students.add(student);
                        } else if (student.studentCredit + course.credit > 20) {
                            System.out.println("you can't take more than 20 credit!");
                        } else if (course.members >= course.capacity) {
                            System.out.println("this course has no capacity!");
                        }
                    }
                }
            }
        }
    }
}
