package Course;

import User.Student;

import java.util.ArrayList;
import java.util.List;

public class SpecializedCourses extends Course{
    final public CourseType type = CourseType.specializedCourse;

    List<Student> students = new ArrayList<>();

    public SpecializedCourses(CourseType type, CourseDepartment department, String code,
                              String teacher, String title, int capacity, int credit,
                              int[] classTime, String examDate,List<Student> students, int members) {
        super(type, department, code, teacher, title, capacity, credit, classTime, examDate, students, members);
        this.department = department;
        this.code = code;
        this.teacher = teacher;
        this.title = title;
        this.capacity = capacity;
        this.credit = credit;
        this.classTime = classTime;
        this.examDate = examDate;
        this.students = students;
        this.members = members;
    }


    public static void addCourses(){
        Course.courses.add(algebra);
        Course.courses.add(mathematicalAnalysis);
        Course.courses.add(linearAlgebra);
        Course.courses.add(probability);
        Course.courses.add(quantumMechanics);
        Course.courses.add(cosmology);
        Course.courses.add(electromagnetism);
        Course.courses.add(mathematicalPhysics);
        Course.courses.add(softwareEngineering);
        Course.courses.add(gameTheory);
        Course.courses.add(network);
        Course.courses.add(webApplication);
        Course.courses.add(electricalCircuit);
        Course.courses.add(machineLearning);
        Course.courses.add(signals);
        Course.courses.add(nano);
        Course.courses.add(chemistryPhysics);
        Course.courses.add(organicChemistry);
        Course.courses.add(analyticalChemistry);
        Course.courses.add(robotic);
        Course.courses.add(dynamics);
        Course.courses.add(vibrations);
        Course.courses.add(thermodynamics);
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
        System.out.print(": " + a.classTime[1] + "-" + a.classTime[2]);
    }

    static SpecializedCourses algebra = new SpecializedCourses(CourseType.specializedCourse, CourseDepartment.mathematicalScience, "22217",
            "ebraihimi", "algebra", 40, 4, new int[]{2, 10, 12}, "1403/03/31",
            new ArrayList<Student>(), 0);

    static SpecializedCourses mathematicalAnalysis = new SpecializedCourses(CourseType.specializedCourse, CourseDepartment.mathematicalScience,
            "22325", "fanaee", "mathematical Analysis", 40, 4,
            new int[]{3, 8, 10}, "1403,03,21", new ArrayList<Student>(), 0);

    static SpecializedCourses linearAlgebra = new SpecializedCourses(CourseType.specializedCourse, CourseDepartment.mathematicalScience,
            "22255", "bahreyni", "linearAlgebra", 60, 4,
            new int[]{1, 15, 17}, "1403/03/23", new ArrayList<Student>(), 0);

    static SpecializedCourses probability = new SpecializedCourses(CourseType.specializedCourse, CourseDepartment.mathematicalScience,
            "22089", "khazaee", "probability", 46, 4,
            new int[]{4, 13, 15}, "1403/04/03", new ArrayList<Student>(), 0);

    static SpecializedCourses quantumMechanics = new SpecializedCourses(CourseType.specializedCourse, CourseDepartment.physics, "24313",
            "kargarian", "quantumMechanics", 40, 3,
            new int[]{2, 9, 11}, "1403/03/27", new ArrayList<Student>(), 0);

    static SpecializedCourses cosmology = new SpecializedCourses(CourseType.specializedCourse, CourseDepartment.physics, "24922",
            "khosravi", "cosmology", 35, 3, new int[]{1, 9, 11},
            "1403/03/30", new ArrayList<Student>(), 0);

    static SpecializedCourses electromagnetism = new SpecializedCourses(CourseType.specializedCourse, CourseDepartment.physics, "24213",
            "mirkamali", "electromagnetism", 35, 3,
            new int[]{3, 10, 12}, "1403/03/26", new ArrayList<Student>(), 0);

    static SpecializedCourses mathematicalPhysics = new SpecializedCourses(CourseType.specializedCourse, CourseDepartment.physics, "24178",
            "rohani", "mathematicalPhysics", 46, 3,
            new int[]{1, 13, 15}, "1403/03/23", new ArrayList<Student>(), 0);

    static SpecializedCourses softwareEngineering = new SpecializedCourses(CourseType.specializedCourse, CourseDepartment.computerEngineering,
            "40474", "reyvadeh", "softwareEngineering", 88, 3,
            new int[]{1, 9, 11}, "1403/03/30", new ArrayList<Student>(), 0);

    static SpecializedCourses gameTheory = new SpecializedCourses(CourseType.specializedCourse, CourseDepartment.computerEngineering,
            "40456", "sedighin", "game theory", 155, 3,
            new int[]{4, 13, 15}, "1403/04/03", new ArrayList<Student>(), 0);

    static SpecializedCourses network = new SpecializedCourses(CourseType.specializedCourse, CourseDepartment.computerEngineering, "40443",
            "mizanian", "network", 85, 3, new int[]{2, 9, 11},
            "1403/03/20", new ArrayList<Student>(), 0);
    static SpecializedCourses webApplication = new SpecializedCourses(CourseType.specializedCourse, CourseDepartment.computerEngineering,
            "40419", "poorsoltani", "web application", 60, 3,
            new int[]{1, 13, 15}, "1403/03/23", new ArrayList<Student>(), 0);


    static SpecializedCourses electricalCircuit = new SpecializedCourses(CourseType.specializedCourse, CourseDepartment.electricalEngineering,
            "25731", "hosseini", "electricalCircuit", 40, 3,
            new int[]{3, 10, 12}, "1403/03/26", new ArrayList<Student>(), 0);

    static SpecializedCourses machineLearning = new SpecializedCourses(CourseType.specializedCourse, CourseDepartment.electricalEngineering,
            "25737", "amiri", "machine learning", 45, 3,
            new int[]{4, 9, 11}, "1403/03/27", new ArrayList<Student>(), 0);

    static SpecializedCourses signals = new SpecializedCourses(CourseType.specializedCourse, CourseDepartment.electricalEngineering,
            "25743", "amini", "signals", 30, 3, new int[]{2, 7, 9},
            "1403/03/30", new ArrayList<Student>(), 0);

    static SpecializedCourses nano = new SpecializedCourses(CourseType.specializedCourse, CourseDepartment.chemistry, "23559",
            "hormozi", "nano", 25, 3, new int[]{3, 16, 18},
            "1403/27/03", new ArrayList<Student>(), 0);

    static SpecializedCourses chemistryPhysics = new SpecializedCourses(CourseType.specializedCourse, CourseDepartment.chemistry,
            "23421", "rahman", "chemistryPhysics", 40, 3,
            new int[]{1, 7, 9}, "1403/03/27", new ArrayList<Student>(), 0);

    static SpecializedCourses organicChemistry = new SpecializedCourses(CourseType.specializedCourse, CourseDepartment.chemistry,
            "23326", "bideh", "organicChemistry", 30, 3,
            new int[]{2, 7, 9}, "1403/03/20", new ArrayList<Student>(), 0);

    static SpecializedCourses analyticalChemistry = new SpecializedCourses(CourseType.specializedCourse, CourseDepartment.chemistry,
            "23223", "hormozinezhad", "analyticalChemistry", 35, 3,
            new int[]{4, 10, 12}, "1403/04/03", new ArrayList<Student>(), 0);

    static SpecializedCourses robotic = new SpecializedCourses(CourseType.specializedCourse, CourseDepartment.mechanicalEngineering,
            "28865", "sayadi", "robotic", 27, 3,
            new int[]{3, 10, 12}, "1403/03/27", new ArrayList<Student>(), 0);

    static SpecializedCourses dynamics = new SpecializedCourses(CourseType.specializedCourse, CourseDepartment.mechanicalEngineering,
            "28567", "behzadi", "dynamics", 60, 4,
            new int[]{2, 10, 12}, "1403/03/22", new ArrayList<Student>(), 0);

    static SpecializedCourses vibrations = new SpecializedCourses(CourseType.specializedCourse, CourseDepartment.chemistry,
            "28568", "moradi", "vibrations", 40, 3,
            new int[]{1, 11, 13}, "1403/03/22", new ArrayList<Student>(), 0);

    static SpecializedCourses thermodynamics = new SpecializedCourses(CourseType.specializedCourse, CourseDepartment.chemistry,
            "28161", "afshin", "thermodynamics", 60, 3,
            new int[]{2, 9, 11}, "1403/03/30", new ArrayList<Student>(), 0);
}
