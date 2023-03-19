package Model.Methods;

import Model.Students.Student;
import com.itfactory.data.DataLoader;

import java.util.List;
import java.util.Scanner;

public class Case4 {
    public static class SearchStudentByName {

        private final DataLoader dataLoader;
        private final Scanner scanner;
        public SearchStudentByName(DataLoader dataLoader, Scanner scanner) {
            this.dataLoader = dataLoader;
            this.scanner = scanner;
        }

        public void search() {
            System.out.println("Search for a student by name!");
            System.out.println("Enter the student's name:");
            String nameSearch = scanner.nextLine();
            boolean studentFound = false;
            for (List<Student> studentsList : dataLoader.getMapCourseAndStudents().values()) {
                for (Student student : studentsList) {
                    if (student.getStudentName().contains(nameSearch)) {
                        System.out.println("The student was found: " + student);
                        studentFound = true;
                    }
                }
            }
            if (!studentFound) {
                System.out.println("The student does not exist in any course.");
            }
        }
    }
}
