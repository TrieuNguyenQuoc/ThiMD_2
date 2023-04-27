package model;

public class Student {
    private String id; // ma sinh vien
    private String name;// ten
    private int age; // tuoi
    private String sex; // gioi tinh
    private String address; // dia chi
    private double averagePoints; // diem tb

    public Student() {
    }

    public Student(String id, String name, int age, String sex, String address, double averagePoints) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.address = address;
        this.averagePoints = averagePoints;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getAveragePoints() {
        return averagePoints;
    }

    public void setAveragePoints(double averagePoints) {
        this.averagePoints = averagePoints;
    }

    @Override
    public String toString() {
        return "Students{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                ", averagePoints=" + averagePoints +
                '}';
    }
}