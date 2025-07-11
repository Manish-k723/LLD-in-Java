package BuilderPattern;

import java.util.Arrays;
import java.util.List;

public class Director {
    StudentBuilder studentBuilder;

    Director(StudentBuilder studentBuilder) {
        this.studentBuilder = studentBuilder;
    }

    public Student buildStudent() {
        if (studentBuilder instanceof EngineeringStudentBuilder) {
            return createEngineeringStudent();
        } else if (studentBuilder instanceof MBAStudentBuilder) {
            return createMBAStudent();
        }
        return null;
    }

    public Student createEngineeringStudent() {
        return studentBuilder.setRollNo(1).setAge(20).setName("John").setPhone("1234567890").setName("Manish")
                .setSubjects(Arrays.asList("Math", "Science", "English"))
                .build();
    }

    public Student createMBAStudent() {
        return studentBuilder.setRollNo(1).setAge(20).setName("John").setPhone("1234567890")
                .setSubjects(Arrays.asList("Business", "Economics", "Finance"))
                .build();
    }

}
