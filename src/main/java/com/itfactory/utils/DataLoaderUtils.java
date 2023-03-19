package com.itfactory.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class DataLoaderUtils {
    public static final String COURSE_FILE_PATH = "course.csv";
    public static final String STUDENT_FILE_PATH = "students.csv";
    public static final String MAPPING_FILE_PATH = "mapping.csv";

    public static List<String> readFile(String filePathStr) throws IOException {
        Path path = Paths.get(filePathStr);

        return Files.readAllLines(path);
    }
}