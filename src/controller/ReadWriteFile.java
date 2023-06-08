package controller;

import model.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteFile {
        public static void writeToFileStudent(List<Student> students) {
        File file = new File("students.csv");
        FileOutputStream stream;
        try {
            stream = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            BufferedOutputStream bufSt = new BufferedOutputStream(stream);
            ObjectOutputStream oos = new ObjectOutputStream(bufSt);
            oos.writeObject(students);
            oos.close();
        } catch (IOException e) {
            System.err.println("Không ghi được file");
        }
        try {
            stream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Student> readDataFileClient() {
        File file = new File("students.csv");
        List<Student> students = new ArrayList<>();
        FileInputStream stream;
        try {
            stream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            BufferedInputStream bufInSt = new BufferedInputStream(stream);
            ObjectInputStream ois = new ObjectInputStream(bufInSt);
            students = (List<Student>) ois.readObject();
            ois.close();
            stream.close();
        } catch (Exception ex) {
            System.err.println("Không đọc được dữ liệu");
        }
        return students;
    }
}
