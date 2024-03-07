package User;

import Course.Course;
import EnteringTheProgram.EnterPage;

public class Admin extends User{
    final String name = "admin";
    public static void enterAdmin(){
        System.out.println("1.seeing courses        2.checking students of courses      3.back");
        System.out.println("4.back to start      5.end program");
        String adminChoice = EnterPage.scanner.nextLine();
        switch (adminChoice){
            case "1" -> {
                Admin.seeingCourses();
            }
            case "2" -> {
                Course.showCourses();
                Admin.adminCheckingStudents();
            }
            case "3" -> Admin.adminCheck();
            case "4" -> EnterPage.userType();
            case "5" -> System.exit(0);
            default -> {
                System.out.println("try again.");
                Admin.enterAdmin();
            }
        }
    }
    public static void adminCheck(){
        System.out.println("username: ");
        String adminName = EnterPage.scanner.nextLine();
        if (adminName.equalsIgnoreCase("admin")){
            while (true){
                System.out.println("password: ");
                String adminPass = EnterPage.scanner.nextLine();
                if (adminPass.equals("1111")){
                    Admin.enterAdmin();
                }
                else {
                    System.out.println("wrong password!");
                    System.out.println("try again.");
                }
            }
        }
        else {
            System.out.println("wrong username!");
            System.out.println("try again.");
            Admin.adminCheck();
        }
    }
    public static void seeingCourses(){
        Course.showCourses();
        while (true){
            System.out.println("1.creating course      2.removing course     3.back");
            System.out.println("4.back to start       5.end program");
            String adminAction = EnterPage.scanner.nextLine();
            switch (adminAction){
                case "1" -> Course.creatingCourse();
                case "2" -> Course.removingCourse();
                case "3" -> Admin.enterAdmin();
                case "4" -> EnterPage.userType();
                case "5" -> System.exit(0);
                default -> {
                    System.out.println("try again.");
                }
            }
        }
    }

    public static void adminCheckingStudents(){
        System.out.println("1.course's code:       2.back      3.back to start     4.end program");
        String courseStudents = EnterPage.scanner.nextLine();
        switch (courseStudents){
            case "2" -> Admin.enterAdmin();
            case "3" -> EnterPage.userType();
            case "4" -> System.exit(0);
            default -> Course.showingCourseStudents(courseStudents);
        }
    }

}
