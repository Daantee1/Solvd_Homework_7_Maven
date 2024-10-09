package Homework_SQL.dao;

import Homework_SQL.model.Dean;

import java.util.List;

public interface IDeanDao extends IBaseDao<Dean> {

    @Override
    Dean getEntityById(int index);

    @Override
    List<Dean> getEntities();

    @Override
    void insert(Dean dean);

    @Override
    void delete(int index);

    @Override
    void update(int index, Dean dean);

}
