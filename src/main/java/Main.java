import Model.Methods.Case4;
import com.itfactory.data.DataLoader;
import Model.Students.BudgetInvalidException;
import java.io.IOException;;
import java.util.*;
import static Model.Methods.Case2.addNewCourse;
import static Model.Methods.Case3.enrollNewStudentInCourse;
import static Model.Methods.Case5.displayStudentsAndCourses;
import static Model.Methods.Case6.exportData;

public class Main {
    public static void main(String[] args) throws IOException, BudgetInvalidException {

        DataLoader dataLoader = new DataLoader();
        dataLoader.loadData();
        Scanner scanner = new Scanner(System.in);
      
        System.out.println("You can enter the following options :\n" +
                "0 – Exit the program.\n" +
                "1 – Show courses\n" +
                "2 – Enter a new course\n" +
                "3 – Enter a new student and enroll him in the course\n" +
                "4 – Search for a student by name \n" +
                "5 – Displays the students and the course they are participating in \n" +
                "6 - Save course and student data for export\n");
        
        while (true) {
            System.out.println("\nPlease enter an option: ");
            int option = Integer.parseInt(scanner.nextLine());
          
            switch (option) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    System.out.println("Display courses");
                    DataLoader.displayCourses(dataLoader.getMapCourseAndStudents());
                    break;
                case 2:
                    addNewCourse(dataLoader);
                    break;
                case 3:
                    enrollNewStudentInCourse(dataLoader, scanner);
                    break;
                case 4:
                    Case4.SearchStudentByName searcher = new Case4.SearchStudentByName(dataLoader, scanner);
                    searcher.search();
                    break;
                case 5:
                    displayStudentsAndCourses(dataLoader);
                    break;
                case 6:
                    exportData(dataLoader);
                    break;
                default:
                    System.out.println("Invalid option.");
                    break;
            }
        }
    }
}
