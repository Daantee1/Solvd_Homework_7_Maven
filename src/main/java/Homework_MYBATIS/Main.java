package Homework_MYBATIS;

import Homework_MYBATIS.model.Student;
import Homework_MYBATIS.myBatis.StudentDao;

public class Main {
    public static void main(String[] args) {
        StudentDao studentDAO = new StudentDao();
        Student student = studentDAO.getEntityById(2);
        System.out.println(student);
    }
}
