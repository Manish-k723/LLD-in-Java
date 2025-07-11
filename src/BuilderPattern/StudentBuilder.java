package BuilderPattern;

import java.util.List;

public abstract class StudentBuilder {
    int rollNo;
    int age;
    String name;
    String phone;
    String fatherName;
    String motherName;
    List<String> subjects;

    public StudentBuilder setRollNo(int rollNo) {
        this.rollNo = rollNo;
        return this;
    }

    public StudentBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    public StudentBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public StudentBuilder setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public StudentBuilder setFatherName(String fatherName) {
        this.fatherName = fatherName;
        return this;
    }

    public StudentBuilder setMotherName(String motherName) {
        this.motherName = motherName;
        return this;
    }

    abstract StudentBuilder setSubjects(List<String> subjects);

    public Student build() {
        return new Student(this);
    }
}

// Builder Pattern is a creational design pattern that allows you to construct
// complex objects step by step. It separates the construction of a complex
// object from its representation, allowing the same construction process to
// create different representations.

// Advantages:
// 1. It allows you to construct complex objects step by step.
// 2. It allows you to reuse the same construction process to create different
// representations.
// 3. It isolates the construction of a complex object from its representation.

// Disadvantages:
// 1. It requires creating a new subclass for each different representation of
// the object.

// Decorator Pattern is a structural design pattern that allows you to
// dynamically add new functionality to an object without modifying its existing
// code. It is a way to extend the functionality of a class by wrapping it in
// another class.

// Advantages:
// 1. It allows you to add new functionality to an object dynamically.
// 2. It allows you to reuse the same decoration process to create different
// representations.
// 3. It isolates the decoration of a complex object from its representation.

// Disadvantages:
// 1. It requires creating a new subclass for each different representation of
// the object.
