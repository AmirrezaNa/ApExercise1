package User;

import Course.Course;
import EnteringTheProgram.EnterPage;

import java.util.ArrayList;
import java.util.List;

public class Student extends User {
    public String studentNumber;
    public List<Course> studentCourses;
    public int studentCredit;

    private String studentPass;

    public String getStudentPass() {
        return studentPass;
    }

    public void setStudentPass(String studentPass) {
        this.studentPass = studentPass;
    }

    static List<String> studentNumbers = new ArrayList<>();

    public static List<Student> students = new ArrayList<>();

    public Student(String studentNumber, List<Course> studentCourses, int studentCredit, String studentPass) {
        this.studentNumber = studentNumber;
        this.studentCourses = studentCourses;
        this.studentCredit = studentCredit;
        this.studentPass = studentPass;
    }

    public static void studentType() {
        System.out.println("1.signup     2.login    3.back     4.back to start      5.end program");
        try {
            String studentTypeChoice = EnterPage.scanner.nextLine();
            if (studentTypeChoice.equals("1")) {
                Student.studentSignup();
            } else if (studentTypeChoice.equals("2")) {
                Student.studentLogin();
            } else if (studentTypeChoice.equals("3")) {
                EnterPage.userType();
            } else if (studentTypeChoice.equals("4")) {
                EnterPage.userType();
            } else if (studentTypeChoice.equals("5")) {
                System.exit(0);
            } else {
                System.out.println("try again!");
                Student.studentType();
            }

        } catch (Exception e) {
            System.out.println("try again");
            EnterPage.userType();
        }
    }

    public static void studentSignup() {
        System.out.println("1.enter student number (3 digits):         2.back       3.back to start      4.end program");
        try {
            String newStudentID = EnterPage.scanner.nextLine();
            switch (newStudentID) {
                case "2" -> Student.studentType();
                case "3" -> EnterPage.userType();
                case "4" -> System.exit(0);
            }
            if (isNumeric(newStudentID)) {
                if (newStudentID.length() == 3) {
                    while (true) {
                        if (!Student.studentNumbers.contains(newStudentID)) {
                            System.out.println("1.enter student password:         2.back       " +
                                    "3.back to start      4.end program");
                            String newStudentPass = EnterPage.scanner.nextLine();
                            if (newStudentPass.equals("2")) {
                                Student.studentSignup();
                            } else if (newStudentPass.equals("3")) {
                                EnterPage.userType();
                            } else if (newStudentPass.equals("4")) {
                                System.exit(0);
                            } else {
                                int studentCredit = 0;
                                Student student = new Student(newStudentID, new ArrayList<Course>(),
                                        studentCredit, newStudentPass);
                                Student.students.add(student);
                                Student.studentNumbers.add(newStudentID);
                                Student.studentSignupChoice(student);
                            }
                        } else {
                            System.out.println("this student number already exists!");
                            System.out.println("try again:");
                        }
                    }
                } else {
                    System.out.println("A 5 digits number!!!");
                    Student.studentSignup();
                }
            }
        } catch (Exception e) {
            System.out.println("try again!");
            Student.studentSignup();
        }

    }


    public static void studentSignupChoice(Student student) {
        System.out.println("1.seeing courses       2.back(deleting the student account " +
                "that you just created!)");
        System.out.println("3.back to start      4.end program");
        String StudentChoice = EnterPage.scanner.nextLine();
        switch (StudentChoice) {
            case "1" -> {
                Course.showCourses();
                while (true) {
                    System.out.println("1.adding course     2.back        3.back to start       4.end program");
                    String choice = EnterPage.scanner.nextLine();
                    switch (choice) {
                        case "1" -> Course.addCourseForStudent(student, "s");
                        case "2" -> Student.studentSignupChoice(student);
                        case "3" -> EnterPage.userType();
                        case "4" -> System.exit(0);
                        default -> System.out.println("try again!");
                    }
                }
            }
            case "2" -> {
                Student.students.remove(student);
                Student.studentNumbers.remove(student.studentNumber);
                Student.studentSignup();
            }
            case "3" -> EnterPage.userType();
            case "4" -> System.exit(0);
            default -> {
                System.out.println("try again.");
                Student.studentSignupChoice(student);
            }
        }
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }


    public static void studentLogin() {
        System.out.println("1.student number:        2.back      3.back to start      4.end program");
        String studentNumber1 = EnterPage.scanner.nextLine();
        switch (studentNumber1) {
            case "2" -> Student.studentType();
            case "3" -> EnterPage.userType();
            case "4" -> System.exit(0);
            default -> {
                if (Student.studentNumbers.contains(studentNumber1)) {
                    while (true) {
                        System.out.println("password:");
                        String studentPass1 = EnterPage.scanner.nextLine();
                        for (Student student : Student.students) {
                            if (student.studentNumber.equals(studentNumber1)) {
                                if (student.studentPass.equals(studentPass1)) {
                                    Student.studentLoginChoice(student);
                                } else {
                                    System.out.println("wrong password!");
                                    System.out.println("try again.");
                                }
                            }
                        }
                    }

                } else {
                    System.out.println("student number doesn't exist!");
                    System.out.println("try again");
                    Student.studentLogin();
                }
            }
        }

    }
    public static void studentLoginChoice(Student student) {
        System.out.println("1.seeing courses       2.back        3.back to start      4.end program");
        String StudentChoice = EnterPage.scanner.nextLine();
        switch (StudentChoice) {
            case "1" -> {
                Course.showCourses();
                while (true) {
                    System.out.println("1.adding course     2.back        3.back to start       4.end program");
                    String choice = EnterPage.scanner.nextLine();
                    switch (choice) {
                        case "1" -> Course.addCourseForStudent(student, "l");
                        case "2" -> Student.studentLoginChoice(student);
                        case "3" -> EnterPage.userType();
                        case "4" -> System.exit(0);
                        default -> System.out.println("try again!");
                    }
                }
            }
            case "2" -> Student.studentLogin();
            case "3" -> EnterPage.userType();
            case "4" -> System.exit(0);
            default -> {
                System.out.println("try again.");
                Student.studentLoginChoice(student);
            }
        }
    }
}
