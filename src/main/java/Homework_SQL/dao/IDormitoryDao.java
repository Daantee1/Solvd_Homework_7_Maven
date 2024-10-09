package Homework_SQL.dao;

import Homework_SQL.model.Car;
import Homework_SQL.model.Dormitory;

import java.util.List;

public interface IDormitoryDao extends IBaseDao<Dormitory> {

    Dormitory getEntityById(int index);

    @Override
    List<Dormitory> getEntities();

    @Override
    void insert(Dormitory dormitory);

    @Override
    void delete(int index);

    @Override
    void update(int index, Dormitory dormitory);
}
