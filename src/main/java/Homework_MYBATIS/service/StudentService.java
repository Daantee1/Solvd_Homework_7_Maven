package Homework_MYBATIS.service;

import Homework_MYBATIS.IStudentDao;
import Homework_MYBATIS.myBatis.StudentDao;

import java.util.ResourceBundle;

public class StudentService {

    public static IStudentDao getStudentSelect() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("database");
        if  (resourceBundle.getString("type").equals("jdbc")){
            return new StudentDao();
        } else {
            return new StudentDao();
        }
    }

}
