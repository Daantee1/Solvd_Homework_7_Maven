package Homework_JAXB;


import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) throws JAXBException, IOException {

        //Employees employees = unmarshal();
        //System.out.println(employees);
        marshal();


    }

    public static Employees unmarshal() throws JAXBException, IOException {
        JAXBContext context = JAXBContext.newInstance(Employees.class);
        return (Employees) context.createUnmarshaller()
                .unmarshal(new FileReader("./src/main/resources/employee.xml"));
    }

    public static void marshal() throws JAXBException, IOException {

        Employee kacper = new Employee(5,"Kacper", 23, "Test Engineer", 5000, new Location("Stalowa Wola", "Andersa 5"), new Date());
        Employee pawel = new Employee(6,"Paweł", 23, "Test Engineer", 5000, new Location("Gdańsk", "Słowika 36"), new Date());
        Employees employees = new Employees();
        List<Employee> employeesList = new ArrayList<>();
        employeesList.add(kacper);
        employeesList.add(pawel);
        employees.setList(employeesList);

        JAXBContext context = JAXBContext.newInstance(Employees.class);
        Marshaller mar= context.createMarshaller();
        mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        mar.marshal(employees, new File("./src/main/resources/employee1.xml"));
    }
}
