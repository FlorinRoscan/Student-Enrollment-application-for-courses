package Model.Methods;

import Model.Course.Course;
import Model.Students.Student;
import com.itfactory.data.DataLoader;

public class Case5 {
    public static void displayStudentsAndCourses(DataLoader dataLoader) {
        System.out.println("Display students and the course they attend:");
        for (Course course : dataLoader.getMapCourseAndStudents().keySet()) {
            System.out.println("The following students are enrolled in the following courses " + course.getCourseName());
            for (Student student : dataLoader.getMapCourseAndStudents().get(course)) {
                System.out.println(student.getStudentName());
            }
            System.out.println("\n");
        }
    }

}
