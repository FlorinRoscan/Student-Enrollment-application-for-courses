package Model.Methods;

import Model.Course.Course;
import com.itfactory.data.DataLoader;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Case2 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static void addNewCourse(DataLoader dataLoader) {
        System.out.println("Enter a new course");
        System.out.println("Enter the course id : ");
        int idCourse = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter the name of the course : ");
        String nameCourse = scanner.nextLine();
        System.out.println("Enter the price : ");

        Double price = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter the start date of the course dd/MM/yyyy");
        String date = scanner.nextLine();
        LocalDate dateCourse = LocalDate.parse(date, formatter);

        Course newCourse = new Course(idCourse, nameCourse, price, dateCourse);
        System.out.println("The following course was entered successfully :");
        System.out.println(newCourse);

        DataLoader.addCourse(newCourse, dataLoader.getMapCourseAndStudents());
    }
}
