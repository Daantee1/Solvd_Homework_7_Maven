package Homework_JSON;

import java.util.Date;
import java.util.List;

public class Admin {
    private int id;
    private String name;

    private Student student;
    private List<Animal> animals;
    private List<Car> cars;
    private Employee employee;
    private Date date;

    public Admin(int id, String name, Student student, List<Animal> animals, List<Car> cars, Employee employee, Date date) {
        this.id = id;
        this.name = name;
        this.student = student;
        this.animals = animals;
        this.cars = cars;
        this.employee = employee;
        this.date = date;
    }

    public Admin() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", student=" + student +
                ", animals=" + animals +
                ", cars=" + cars +
                ", employee=" + employee +
                ", date=" + date +
                '}';
    }
}
