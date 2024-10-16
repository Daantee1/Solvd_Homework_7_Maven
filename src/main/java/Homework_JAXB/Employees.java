package Homework_JAXB;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "employees")
public class Employees {

    private List<Employee> list;

    public List<Employee> getList() {
        return list;
    }

    @XmlElement(name = "employee")
    public void setList(List<Employee> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "list=" + list +
                '}';
    }
}
