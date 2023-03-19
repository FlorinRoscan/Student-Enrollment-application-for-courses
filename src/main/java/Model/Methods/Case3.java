package Model.Methods;

import Model.Course.Course;
import Model.Students.BudgetInvalidException;
import Model.Students.Student;
import com.itfactory.data.DataLoader;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Case3 {

    public static void enrollNewStudentInCourse(DataLoader dataLoader, Scanner scanner) throws BudgetInvalidException {

        System.out.println("Available courses:");
        for (Map.Entry<Course, List<Student>> enrolled : dataLoader.getMapCourseAndStudents().entrySet()) {
            if (enrolled.getValue().size() < 9) {
                Course course = enrolled.getKey();
                LocalDate startDate = course.getStartDate();
                System.out.println(course.getCourseName() + " - price: " + course.getPriceCourse() + " - start date: " + startDate);
            }
        }

        System.out.println("Please enter the name of the course:");
        String courseName = scanner.nextLine();

        LocalDate now = LocalDate.now();
        Course selectedCourse = null;

        for (Course course : dataLoader.getMapCourseAndStudents().keySet()) {
            if (course.getCourseName().equals(courseName) && now.isBefore(course.getStartDate())) {
                System.out.println("Found course: " + course);
                selectedCourse = course;
                break;
            }
        }

        if (selectedCourse == null) {
            System.out.println("This course does not exist or is not available.");

        }

        System.out.println("Please enter the ID of the student:");
        int newStudentId = Integer.parseInt(scanner.nextLine());

        System.out.println("Please enter the name of the student:");
        String newStudentName = scanner.nextLine();

        System.out.println("Please enter the budget of the student:");
        double newStudentBudget = Double.parseDouble(scanner.nextLine());

        Student newStudent = new Student(newStudentId, newStudentName, newStudentBudget);
        System.out.println("You have entered the following student : " + newStudent);

        double coursePrice = selectedCourse.getPriceCourse();
        double studentBudget = newStudent.getBudget();

        double remainingBudget = studentBudget - coursePrice;

        try {
            newStudent.setBudget(remainingBudget);
            dataLoader.getMapCourseAndStudents().get(selectedCourse).add(newStudent);

        } catch (BudgetInvalidException e) {

            System.out.println("The student's budget is invalid, enrollment in the course was not successful!");
        }
    }
}








