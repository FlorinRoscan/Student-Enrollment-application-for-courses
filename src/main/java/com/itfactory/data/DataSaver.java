package com.itfactory.data;

import Model.Course.Course;
import com.itfactory.utils.DataSaverUtils;
import Model.Students.Student;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DataSaver {

    private void saveCourses(Map<Course, List<Student>> mapSaveCourses) throws IOException {
        Set<Course> setCourse = mapSaveCourses.keySet();
        String content = "";
        for (Course course : setCourse) {
            content = content.concat(course.toString().concat("\n"));
        }
        System.out.println(content);

        DataSaverUtils.writeFile(DataSaverUtils.SAVE_COURSE_FILE_PATH, content);
    }

    private void saveStudent(Map<Course, List<Student>> mapSaveStudent) throws IOException {
        String content = "";
        for (List<Student> mapValue : mapSaveStudent.values()) {
            for (Student student : mapValue) {
                content = content.concat(student.toString().concat("\n"));
            }
        }

        DataSaverUtils.writeFile(DataSaverUtils.SAVE_STUDENT_FILE_PATH, content);
    }

    private void saveMapping(Map<Course, List<Student>> mapping) throws IOException {
        String content = "";
        for (Map.Entry<Course, List<Student>> registration : mapping.entrySet()) {
            int courseId = registration.getKey().getCourseId();
            for (Student student : registration.getValue()) {
                int studentId = student.getStudentId();
                content = content.concat(courseId + "," + studentId + "\n");
            }
        }

        DataSaverUtils.writeFile(DataSaverUtils.SAVE_MAPPING_FILE_PATH, content);
    }

    public void saveData(Map<Course, List<Student>> mapDataSave) throws IOException {
        saveCourses(mapDataSave);
        saveStudent(mapDataSave);
        saveMapping(mapDataSave);
    }
}
