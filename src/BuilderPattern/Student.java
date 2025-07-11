package BuilderPattern;

import java.util.List;

public class Student {
    int rollNo;
    int age;
    String name;
    String phone;
    String fatherName;
    String motherName;
    List<String> subjects;

    public Student(StudentBuilder studentBuilder) {
        this.rollNo = studentBuilder.rollNo;
        this.age = studentBuilder.age;
        this.name = studentBuilder.name;
        this.phone = studentBuilder.phone;
        this.fatherName = studentBuilder.fatherName;
        this.motherName = studentBuilder.motherName;
        this.subjects = studentBuilder.subjects;
    }

    public String toString() {
        return "Student [rollNo=" + rollNo + ", age=" + age + ", name=" + name + ", phone=" + phone + ", fatherName="
                + fatherName + ", motherName=" + motherName + ", subjects=" + subjects + "]";
    }
}
