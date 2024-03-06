package EnteringTheProgram;

import User.Student;

import java.util.Scanner;

public class EnterPage {
    public static Scanner scanner = new Scanner(System.in);
    public static void userType(){
        System.out.println("1.student     2.admin    3.end Program");
        String userTypeChoice = EnterPage.scanner.nextLine();
        if (userTypeChoice.equals("1")){
            Student.studentType();
        }
        else if (userTypeChoice.equals("2")){

        }
        else if (userTypeChoice.equals("3")){
            System.exit(0);
        }

    }
}
