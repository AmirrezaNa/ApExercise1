package User;

import Course.Course;
import EnteringTheProgram.EnterPage;

public class Admin extends User{
    final String name = "admin";
    public static void enterAdmin(){
        System.out.println("1.seeing courses        2.checking students of courses      3.back      4.end program");
        String adminChoice = EnterPage.scanner.nextLine();
        switch (adminChoice){
            case "1" -> {
                Admin.seeingCourses();
            }
            case "2" -> {
                Course.showCourses();
                Admin.adminCheckingStudents();
            }
            case "3" -> EnterPage.userType();
            case "4" -> System.exit(0);

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
