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


        mockCourse.getTeachingClasses().add(new TeachingClass(new Date(System.currentTimeMillis()), new AssignmentMaterial("What is OOAD")));
        mockCourse.getTeachingClasses().add(new TeachingClass(new Date(System.currentTimeMillis()), new Material("Use case")));

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
        User mockStudent = new Student("Example Student1", "001", "001", courses);
        User mockTeacher = new Teacher("Example Teacher1", "002", "002", courses);
        users.add(mockStudent);
        users.add(mockTeacher);
        users.add(new Student("Example Student3", "003", "003", courses));
        users.add(new Teacher("Example Teacher1", "004", "004", courses));
        users.add(new Teacher("Example Teacher2", "005", "005", courses));
    }

}
