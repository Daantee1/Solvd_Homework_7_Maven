package Homework_JAXB;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import java.util.Date;

@XmlType(propOrder = { "id", "name", "age", "position", "salary", "location", "date" })
public class Employee {

    private int id;
    private String name;
    private int age;
    private String position;
    private double salary;

    private Location location;
    private Date date;

    public Employee(int id, String name, int age, String position, double salary, Location location, Date date) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.position = position;
        this.salary = salary;
        this.location = location;
        this.date = date;
    }

    public Employee(){

    }


    public int getId() {
        return id;
    }

    @XmlAttribute
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    @XmlElement
    public void setAge(int age) {
        this.age = age;
    }

    public String getPosition() {
        return position;
    }

    @XmlElement
    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    @XmlElement
    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Location getLocation() {
        return location;
    }

    @XmlElement
    public void setLocation(Location location) {
        this.location = location;
    }

    public Date getDate() {
        return date;
    }

    @XmlJavaTypeAdapter(DateAdapter.class)
    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                ", location=" + location +
                '}';
    }
}
