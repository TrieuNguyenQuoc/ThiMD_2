package views;

import controller.ManagerController;
import controller.ReadWriteFile;
import model.Student;

import java.util.Comparator;
import java.util.Scanner;
import java.util.regex.Pattern;


public class Menu {
    ManagerController menu = new ManagerController();
    public Scanner input = new Scanner(System.in);
    public int checkInput;
    public String checkId;

    public void menuStudent() {

        while (true) {
            showMessage("""
                    ------CHƯƠNG TRÌNH QUẢN LÝ SINH VIÊN------
                    chọn chức năng theo số (để tiếp tục)
                      1. Xem danh sách sinh viên
                      2. Thêm mới
                      3. Cập nhật
                      4. Xóa
                      5. Sắp xếp
                      6. Đọc từ file
                      7. Ghi vào file
                      8. Thoát
                    """);
            showMessage("Lựa chọn: ");
            checkInput = checkInt();
            switch (checkInput) {
                case 1 -> menu.displayStudents();
                case 2 -> menu.addNewStudent(addStudent());
                case 3 -> editStudent();
                case 4 -> deleteStudent();
                case 5 -> sortByStudents();
                case 6 -> System.out.println(ReadWriteFile.readDataFileClient());
                case 7 -> ReadWriteFile.writeToFileStudent(menu.getStudents());
                case 8 -> {
                    showMessage("Goodbye");
                    System.exit(checkInput);
                }
                default -> showMessageErr("Vui lòng nhập lại!");
            }
        }
    }

    public Student addStudent() {
        showMessage("Mời bạn nhập mã sinh viên viên  : ");
        String id = string();
        showMessage("Mời bạn nhập tên sinh viên  : ");
        String name = stringName();
        showMessage("Mời bạn nhập tuổi sinh viên : ");
        int age = checkInt();
        showMessage("Mời bạn nhập giới tính sinh viên : ");
        String gender = stringName();
        showMessage("Mời bạn nhập địa chỉ sinh viên  : ");
        String address = stringName();
        showMessage("Mời bạn nhập điểm trung bình sinh viên : ");
        double mediumScore = checkDouble();
        return new Student(id, name, age, gender, address, mediumScore);
    }

    public void editStudent() {
        String newName;
        int newAge;
        String newGender;
        String newAddress;
        double newMediumScore;
        Student student;
        showMessage("Mời bạn nhập vào id nhân viên: ");
        String id = string();
        for (Student st : menu.getStudents()) {
            if (id.equals(st.getId())) {
                showMessage("Mời bạn nhập tên sinh viên  : ");
                newName = stringName();
                showMessage("Mời bạn nhập tuổi sinh viên : ");
                newAge = checkInt();
                showMessage("Mời bạn nhập giới tính sinh viên : ");
                newGender = stringName();
                showMessage("Mời bạn nhập địa chỉ sinh viên  : ");
                newAddress = stringName();
                showMessage("Mời bạn nhập điểm trung bình sinh viên : ");
                newMediumScore = checkDouble();
                student = new Student(id, newName, newAge, newGender, newAddress, newMediumScore);
                menu.editStudent(student, id);
            }
        }
    }

    public void sortByStudents() {
        showMessage("""
                --------SẮP XẾP SINH VIÊN THEO ĐIỂM TRUNG BÌNH-------
                chọn chức năng theo số (để tiếp tục)
                1. Sắp xếp điểm trung bình tăng dần
                2. Sắp xếp điểm trung bình giảm dần
                3. Thoát
                """);
        showMessage("Chọn chức năng: ");
        checkInput = Integer.parseInt(input.nextLine());
        switch (checkInput) {
            case 1 -> {
                menu.getStudents().sort(new Comparator<Student>() {
                    @Override
                    public int compare(Student o1, Student o2) {
                           return (int) (o1.getMediumScore() - o2.getMediumScore());
                    }
                });
            }
            case 2 -> {
                menu.getStudents().sort(new Comparator<Student>() {
                    @Override
                    public int compare(Student o1, Student o2) {
                        return (int) (o2.getMediumScore() - o1.getMediumScore());
                    }
                });
            }
            case 3 -> menuStudent();
            default -> showMessageErr("Nhập dữ liệu không đúng !!");
        }
    }

    public void deleteStudent() {
        if (menu.getStudents().isEmpty()) {
            showMessageErr("Danh sách trống!");
        } else {
            showMessage("Nhập id sinh viên muốn xóa: ");
            checkId = input.nextLine();
            showMessage(menu.deleteByStudent(checkId));
        }
    }

    public void showMessage(String msg) {
        System.out.println(msg);
    }

    public void showMessageErr(String msg) {
        System.err.println(msg);
    }

    public String string() {
        while (true) {
            String string = input.nextLine();
            Pattern check = Pattern.compile("^[a-z0-9]+$");
            if (check.matcher(string).find()) {
                showMessage("input is ok");
                return string;
            } else {
                showMessageErr("input is not ok");
            }
        }

    }

    public String stringName() {
        while (true) {
            String string = input.nextLine();
            Pattern check = Pattern.compile("^[a-zA-Z ]+$");
            if (check.matcher(string).find()) {
                showMessage("input is ok");
                return string;
            } else {
                showMessageErr("input is not ok");
            }
        }

    }

    public int checkInt() {
        while (true) {
            try {
                return Integer.parseInt(input.nextLine());
            } catch (Exception e) {
                showMessageErr("Nhập sai định dạng! vui lòng nhập lại");
            }
        }
    }

    public double checkDouble() {
        while (true) {
            try {
                return Double.parseDouble(input.nextLine());
            } catch (Exception e) {
                showMessageErr("Nhập sai định dạng! vui lòng nhập lại");
            }
        }
    }
}
