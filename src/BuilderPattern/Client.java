package BuilderPattern;

public class Client {
    public static void main(String[] args) {
        Director directorObj1 = new Director(new EngineeringStudentBuilder());
        Director directorObj2 = new Director(new MBAStudentBuilder());

        Student engineeringStudent = directorObj1.buildStudent();
        Student mbaStudent = directorObj2.buildStudent();

        System.out.println(engineeringStudent.toString());
        System.out.println(mbaStudent.toString());
    }
}
