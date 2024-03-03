package Course;

import User.Student;

import java.util.ArrayList;
import java.util.List;

public class RequiredCourses extends Course{
    final public CourseType type = CourseType.requiredCourse;
    List<Student> students = new ArrayList<>();
    public RequiredCourses (CourseType type, CourseDepartment department, String code,
                            String teacher, String title, int capacity, int credit,
                            int[] classTime, String examDate, List<Student> students, int members){
        super(type, department, code, teacher, title, capacity, credit, classTime, examDate, students, members);

        this.department = department;
        this.code = code;
        this.teacher = teacher;
        this.title = title;
        this.capacity = capacity;
        this.credit = credit;
        this.classTime = classTime;
        this.examDate = examDate;
        this.members = members;
    }
    public static void addCourse(){
        Course.courses.add(calculus1);
        Course.courses.add(physics1);
        Course.courses.add(computerArchitect);
        Course.courses.add(electronic);
        Course.courses.add(chemistry1);
        Course.courses.add(mechanic);
    }

    public static void showCourseInformation(Course a){
        System.out.print("department: " + a.department + "   code: " + a.code + "   teacher:" + a.teacher +
                "   title: " +a.title + "    capacity: " + a.capacity + "    credit: " + a.credit +
                "    exam date: " + a.examDate + "    class time: ");
        if (a.classTime[0] == 1){
            System.out.print("saturday");
        }
        else if (a.classTime[0] == 2){
            System.out.print("sunday");
        }
        else if (a.classTime[0] == 3){
            System.out.print("monday");
        }
        else if (a.classTime[0] == 4){
            System.out.print("tuesday");
        }
        else if (a.classTime[0] == 5){
            System.out.print("wednesday");
        }
        else{

        }
        System.out.print(": " + a.classTime[1] + "-" + a.classTime[2]);
    }

    static RequiredCourses calculus1 = new RequiredCourses(CourseType.requiredCourse, CourseDepartment.mathematicalScience,
            "22015", "jamali", "calculus1", 260, 4,
            new int[]{3, 13, 15}, "1403/03/29", new ArrayList<Student>(), 0);

    static RequiredCourses physics1 = new RequiredCourses(CourseType.requiredCourse, CourseDepartment.physics, "24011",
            "moghimi", "physics1", 40, 3, new int[]{1,9, 11},
            "1403/03/20", new ArrayList<Student>(), 0);

    static RequiredCourses computerArchitect = new RequiredCourses(CourseType.requiredCourse, CourseDepartment.computerEngineering,
            "40102", "ejlali", "computerArchitect", 15, 1,
            new int[]{5, 13, 17}, "1403/03/22", new ArrayList<Student>(), 0);

    static RequiredCourses electronic = new RequiredCourses(CourseType.requiredCourse, CourseDepartment.electricalEngineering,
            "25031", "kaveh-vosh", "electronic", 60, 3,
            new int[]{3, 9, 11}, "1403,03,30", new ArrayList<Student>(), 0);

    static RequiredCourses chemistry1 = new RequiredCourses(CourseType.requiredCourse, CourseDepartment.chemistry, "23011",
            "bagherzadeh", "chemistry1", 35, 3, new int[]{4, 9, 11},
            "1403/04/03", new ArrayList<Student>(), 0);

    static RequiredCourses mechanic = new RequiredCourses(CourseType.requiredCourse, CourseDepartment.mechanicalEngineering,
            "28139", "mohammadi", "mechanic", 60, 2,
            new int[]{5, 15, 17}, "1403/03/30", new ArrayList<Student>(), 0);

}

