package Homework_MYBATIS;

import Homework_MYBATIS.model.Student;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IStudentDao extends IBaseDao<Student>{
    @Select(
            "select * from mydb.Students where id = #{index}")
    @Results(value = {
            @Result(property="firstName", column = "first_name"),
            @Result(property="carId", column = "Cars_id"),
    })
    @Override
    Student getEntityById(int index);

    @Override
    List<Student> getEntities();

    @Override
    void insert(Student student);

    @Override
    void delete(int index);

    @Override
    void update(int index, Student student);
}
