package Homework_SQL.dao;

import Homework_SQL.model.Car;

import java.util.List;

public interface ICarDao extends IBaseDao<Car>{

    @Override
    Car getEntityById(int index);

    @Override
    List<Car> getEntities();

    @Override
    void insert(Car car);

    @Override
    void delete(int index);

    @Override
    void update(int index, Car car);


}
