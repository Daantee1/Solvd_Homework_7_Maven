package Homework_JSON;
import java.util.Date;
public class Student {
    private String name;
    private int age;
    private String studyOfField;
    private Car car;
    private Date date;

    public Student(String name, int age, String studyOfField, Car car, Date date) {
        this.name = name;
        this.age = age;
        this.studyOfField = studyOfField;
        this.car = car;
        this.date = date;
    }

    public Student() {
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

    public String getStudyOfField() {
        return studyOfField;
    }

    public void setStudyOfField(String studyOfField) {
        this.studyOfField = studyOfField;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", studyOfField='" + studyOfField + '\'' +
                ", car=" + car +
                ", date=" + date +
                '}';
    }
}
