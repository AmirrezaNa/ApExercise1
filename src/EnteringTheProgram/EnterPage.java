package EnteringTheProgram;

import User.Admin;
import User.Student;

import java.util.Scanner;

public class EnterPage {
    public static Scanner scanner = new Scanner(System.in);
    public static void userType(){
        System.out.println("1.student     2.admin    3.end Program");
        String userTypeChoice = EnterPage.scanner.nextLine();
        switch (userTypeChoice) {
            case "1" -> Student.studentType();
            case "2" -> Admin.enterAdmin();
            case "3" -> System.exit(0);
        }

    }
}
