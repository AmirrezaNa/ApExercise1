package User;

import Course.Course;
import EnteringTheProgram.EnterPage;

import java.util.ArrayList;
import java.util.List;

public class Student extends User {
    public String studentNumber;
    public List<Course> studentCourses;
    public int studentCredit;
    static List<String> studentNumbers = new ArrayList<>();

    public static List<Student> students = new ArrayList<>();

    public Student(String studentNumber, List<Course> studentCourses) {
        this.studentNumber = studentNumber;
        this.studentCourses = studentCourses;
    }

    public static void studentType() {
        System.out.println("1.signup     2.login    3.back     4.back to start      5.end program");
        try {
            String studentTypeChoice = EnterPage.scanner.nextLine();
            if (studentTypeChoice.equals("1")) {
                Student.studentSignup();
            }
            else if (studentTypeChoice.equals("2")){
                Student.studentLogin();
            }
            else if (studentTypeChoice.equals("3")){
                EnterPage.userType();
            }
            else if (studentTypeChoice.equals("4")){
                EnterPage.userType();
            }
            else if (studentTypeChoice.equals("5")){
                System.exit(0);
            }

        } catch (Exception e){
            System.out.println("try again");
            EnterPage.userType();
        }
    }

    public static void studentSignup(){
        System.out.println("1.enter student ID:         2.back       3.back to start      4.end program");

    }


    public static void studentLogin(){

    }
}
