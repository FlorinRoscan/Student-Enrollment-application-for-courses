package Model.Methods;

import com.itfactory.data.DataSaver;
import com.itfactory.data.DataLoader;

import java.io.IOException;
public class Case6 {
    public static void exportData(DataLoader dataLoader) throws IOException {
        System.out.println("Saving course and student data for export...");
        DataSaver dataSaver = new DataSaver();
        dataSaver.saveData(dataLoader.getMapCourseAndStudents());
        System.out.println("Data saved successfully for export.");
        }
    }


