package com.itfactory.data;

import Model.Students.BudgetInvalidException;
import Model.Course.Course;
import com.itfactory.utils.DataLoaderUtils;
import Model.Students.Student;

import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

public class DataLoader {
    private Map<Course, List<Student>> mapCourseAndStudents;
    private List<Student> studentsList;

    public DataLoader() {
        mapCourseAndStudents = new HashMap<>();
        studentsList = new ArrayList<>();
    }

    public void loadData() throws IOException {
        loadCourses();
        loadStudents();
        mapStudentsToCourses();
    }

    private void mapStudentsToCourses() throws IOException {
        List<String> mapping = DataLoaderUtils.readFile(DataLoaderUtils.MAPPING_FILE_PATH);

        for (String mapp : mapping) {
            String[] iduri = mapp.split(",");
            int idStudent = Integer.parseInt(iduri[0]);
            int idCourse = Integer.parseInt(iduri[1]);

            Student studentFind = null;
            Course courseFind = null;
            for (Student student : studentsList) {
                if (student.getStudentId() == idStudent) {
                    studentFind = student;
                    break;
                }
            }

            for (Course course : mapCourseAndStudents.keySet()) {
                if (course.getCourseId() == idCourse) {
                    courseFind = course;
                    break;
                }
            }

            if (studentFind != null && courseFind != null) {
                mapCourseAndStudents.get(courseFind).add(studentFind);
                double budgetStudent = studentFind.getBudget();
                double priceCourse = courseFind.getPriceCourse();
                double remainingBudget = budgetStudent - priceCourse;

                try {
                    studentFind.setBudget(remainingBudget);
                    mapCourseAndStudents.get(courseFind).add(studentFind);
                } catch (BudgetInvalidException e) {
                }
            }
        }
    }

                private void loadStudents () throws IOException {
                    List<String> students = DataLoaderUtils.readFile(DataLoaderUtils.STUDENT_FILE_PATH);

                    for (String student : students) {
                        String[] studentArray = student.split(",");
                        Student studentNew = createStudent(studentArray);

                        studentsList.add(studentNew);
                    }
                }

                private void loadCourses () throws IOException {
                    List<String> courses = DataLoaderUtils.readFile(DataLoaderUtils.COURSE_FILE_PATH);

                    for (String Course : courses) {
                        String[] dateCourse = Course.split(",");
                        Course newCourse = createCourse(dateCourse);

                        mapCourseAndStudents.put(newCourse, new ArrayList<>());
                    }
                }

                private Course createCourse (String[]dateCourse){
                    int id = Integer.parseInt(dateCourse[0]);
                    String name = dateCourse[1];
                    Double price = Double.parseDouble(dateCourse[2]);
                    LocalDate startDate = LocalDate.parse(dateCourse[3]);

                    return new Course(id, name, price, startDate);
                }

                private Student createStudent (String[]studentsArray){

                    int id = Integer.parseInt(studentsArray[0]);
                    String name = studentsArray[1];
                    Double budget = Double.parseDouble(studentsArray[2]);

                    return new Student(id, name, budget);
                }

                public Map<Course, List<Student>> getMapCourseAndStudents () {
                    return mapCourseAndStudents;
                }

                public static void displayCourses (Map < Course, List < Student >> mapping){
                    Set<Course> listCourses = mapping.keySet();
                    for (Course displayCourses : listCourses) {
                        System.out.println(displayCourses);
                    }
                }

                public static void addCourse (Course newCourse, Map < Course, List < Student >> mapping){
                    mapping.put(newCourse, new ArrayList<>());
                }
            }




