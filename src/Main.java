import EnteringTheProgram.EnterPage;
import Course.SpecializedCourses;
import Course.RequiredCourses;

public class Main {
    public static void main(String[] args) {
        SpecializedCourses.addCourses();
        RequiredCourses.addCourse();
        System.out.println("Hi!");
        System.out.println("welcome.");
        EnterPage.userType();
    }
}