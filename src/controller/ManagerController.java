package controller;

import model.Student;

import java.util.ArrayList;
import java.util.List;


public class ManagerController {
    List<Student> students;

    //Display saving-------------------------------------
    public ManagerController() {
        students = ReadWriteFile.readDataFileClient();
    }

    public ManagerController(List<Student> students) {
        this.students = students;
    }

    public List<Student> getStudents() {
        return students;
    }

    //CRUD student-----------------------------------------
    public void addNewStudent(Student student) {
        students.add(student);
    }

    public void displayStudents() {
        for (Student student : students) {
            System.out.println(student+" ");
        }
    }

    public String deleteByStudent(String id) {
        for (Student st : students) {
            if (id.equals(st.getId())) {
                students.remove(st);
                return "successful delete by " + st.getFullName();
            }
        }
        return "id bạn nhập không có trong danh sách";
    }

    public void editStudent(Student student, String id) {
        for (int i = 0; i < students.size(); i++) {
            if (id.equals(students.get(i).getId())) {
                students.set(i, student);
                break;
            }
        }
    }
}