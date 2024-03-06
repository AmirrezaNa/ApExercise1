import Course.Course;
import EnteringTheProgram.EnterPage;
import Course.SpecializedCourses;
import Course.RequiredCourses;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SpecializedCourses.addCourses();
        RequiredCourses.addCourse();
        System.out.println("Hi!");
        System.out.println("welcome.");
        EnterPage.userType();
    }
}