package Main;

import Model.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MockData {
    public static List<User> users;

    public static List<Course> courses;

    public static List<Material> materials;
    public static List<AssignmentMaterial> assignmentMaterials;

    public static void initialize() {
        courses = new ArrayList<Course>();
        Course mockCourse = new Course("Object Oriented A & D", "OOAD", "0000000000", "-", "annaaaaa!!!", new ArrayList<TeachingClass>(1));

        Date mockDate = new Date(System.currentTimeMillis());
        mockDate.setHours(13);
        mockDate.setMinutes(30);
        Date mockDueDate = Date.from(mockDate.toInstant());
        mockDueDate.setHours(16);
        mockCourse.getTeachingClasses().add(new TeachingClass(mockDate, "What is OOAD", new Material()));
        mockCourse.getTeachingClasses().add(new TeachingClass(mockDate, "Use case", new AssignmentMaterial(mockDate, mockDueDate)));

        courses.add(mockCourse);
        courses.add(new Course("Comp Arch", "CA", "0000000001", "-", "annaaaaa!!!", new ArrayList<TeachingClass>(1)));
        courses.add(new Course("Software End", "SE", "0000000002", "-", "annaaaaa!!!", new ArrayList<TeachingClass>(1)));
        courses.add(new Course("Comp Net", "CN", "0000000003", "-", "annaaaaa!!!", new ArrayList<TeachingClass>(1)));
        courses.add(new Course("Foundation Eng", "FE", "0000000004", "-", "annaaaaa!!!", new ArrayList<TeachingClass>(1)));
        courses.add(new Course("Infomation Retrieval", "IR", "0000000005", "-", "annaaaaa!!!", new ArrayList<TeachingClass>(1)));
        courses.add(new Course("Micro Robot", "MR", "0000000006", "-", "annaaaaa!!!", new ArrayList<TeachingClass>(1)));
        courses.add(new Course("Operation System", "OS", "0000000007", "-", "annaaaaa!!!", new ArrayList<TeachingClass>(1)));
        courses.add(new Course("Compiler Comp", "CC", "0000000008", "-", "annaaaaa!!!", new ArrayList<TeachingClass>(1)));

        users = new ArrayList<User>(10);
//        User mockStudent = new Student("Example Student1", "001", "001", courses);
        User mockTeacher = new Teacher("Example Teacher1", "002", "002", courses);
//        users.add(mockStudent);
        users.add(mockTeacher);
//        users.add(new Student("Example Student3", "003", "003", courses));
        users.add(new Teacher("Example Teacher1", "004", "004", courses));
        users.add(new Teacher("Example Teacher2", "005", "005", courses));
    }

    public static List<AssignmentMaterial> mockAssignment() {
        Student student = new Student();
        student.setId(1234);
        student.setFullName("TestStudent");

        List<AssignmentMaterial> assignmentMaterials = new ArrayList<AssignmentMaterial>();

        AssignmentMaterial tmpAssigmentMaterial = new AssignmentMaterial();
        tmpAssigmentMaterial.addHomework(new Homework("https://stackoverflow.com/questions/5226212/how-to-open-the-default-webbrowser-using-java", student));
        tmpAssigmentMaterial.addHomework(new Homework("1sadsd4567", student));
        tmpAssigmentMaterial.addHomework(new Homework("1dsadsadsa67", student));
        tmpAssigmentMaterial.addHomework(new Homework("1dsadsa67", student));
        tmpAssigmentMaterial.addHomework(new Homework("12zzz7", student));
        tmpAssigmentMaterial.addHomework(new Homework("12345sssss67", student));
        tmpAssigmentMaterial.addHomework(new Homework("123zzz7", student));

        assignmentMaterials.add(tmpAssigmentMaterial);

        AssignmentMaterial tmpAssignmentMaterial2 = new AssignmentMaterial();
        tmpAssignmentMaterial2.addHomework(new Homework("asdfghjk", student));
        tmpAssignmentMaterial2.addHomework(new Homework("adsajk", student));
        tmpAssignmentMaterial2.addHomework(new Homework("bxdfghjk", student));
        tmpAssignmentMaterial2.addHomework(new Homework("bxxsdfghjk", student));
        tmpAssignmentMaterial2.addHomework(new Homework("aasdsadafghjk", student));
        tmpAssignmentMaterial2.addHomework(new Homework("dsadsadfghjk", student));
        tmpAssignmentMaterial2.addHomework(new Homework("czccfghjk", student));
        tmpAssignmentMaterial2.addHomework(new Homework("czcazzzfghjk", student));


        assignmentMaterials.add(tmpAssignmentMaterial2);
        return assignmentMaterials;
    }
}
