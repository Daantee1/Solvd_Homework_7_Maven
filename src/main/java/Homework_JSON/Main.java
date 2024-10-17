package Homework_JSON;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        objectMapper.setDateFormat(df);

        //List<Employee> employees = objectMapper.readValue(new File("./src/main/resources/employees.json"), new TypeReference<List<Employee>>(){});
        //System.out.println(employees);


        Employee employee = new Employee("Dawid", "Puka", 20, "Junior Test engineer");
        objectMapper.writeValue(new File("./src/main/resources/employee1.json"), employee);

        List<Car> cars = new ArrayList<>();
        Car car = new Car("Audi", 2009, new Date());
        Car car2 = new Car("Bmw", 2010, new Date());
        cars.add(car);
        cars.add(car2);
        objectMapper.writeValue(new File("./src/main/resources/car.json"), cars);

        Student student = new Student("Marek", 18, "ETI", car, new Date());
        objectMapper.writeValue(new File("./src/main/resources/student.json"), student);

        List<Animal> animals = new ArrayList<>();
        Animal animal = new Animal("Lion", 2);
        Animal animal2 = new Animal("Tiger", 3);
        Animal animal3 = new Animal("Bird", 10);
        animals.add(animal);
        animals.add(animal2);
        animals.add(animal3);
        objectMapper.writeValue(new File("./src/main/resources/animals.json"), animals);

        List<Admin> adminsList = new ArrayList<>();
        Admin admin = new Admin(1, "Admin", student, animals,cars, employee, new Date());
        adminsList.add(admin);
        objectMapper.writeValue(new File("./src/main/resources/admins.json"), adminsList);
        System.out.println(adminsList);
    }
}
