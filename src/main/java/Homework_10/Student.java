package Homework_10;

import java.util.Objects;

public class Student implements Comparable<Student> {
    private String name;
    private int age;
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Student other) {
        if (this.age != other.age) {
            return Integer.compare(this.age, other.age);
        }
        return this.name.compareTo(other.name);
    }
}
