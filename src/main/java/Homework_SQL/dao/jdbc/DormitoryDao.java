package Homework_SQL.dao.jdbc;

import Homework_SQL.BasicConnectionPool;
import Homework_SQL.dao.IDormitoryDao;
import Homework_SQL.model.Dormitory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DormitoryDao implements IDormitoryDao {

    static BasicConnectionPool connectionPool = BasicConnectionPool.create();

    @Override
    public Dormitory getEntityById(int index){
        Dormitory dormitory = new Dormitory();
        Connection connection = null;
        try{
            connection = connectionPool.getConnection();
            String query = "SELECT * FROM mydb.dormitories WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, index);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                dormitory.setName(resultSet.getString("name"));
                dormitory.setRoom(resultSet.getInt("room"));
                dormitory.setAddress(resultSet.getString("address"));
            }
        } catch(SQLException e){
            System.out.println("ERROR");
        }
        finally{
            connectionPool.releaseConnection(connection);
        }
        return dormitory;
    }

    @Override
    public List<Dormitory> getEntities(){
        List<Dormitory> dormitories = new ArrayList<>();
        Connection connection = null;
        String query = "SELECT * FROM mydb.dormitories";
        try{
            connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Dormitory dormitory = new Dormitory(resultSet.getInt("id"), resultSet.getString("name")
                , resultSet.getInt("room"), resultSet.getString("address"));
                dormitories.add(dormitory);
            }
        }
        catch (SQLException e){
            System.out.println("ERROR");
        }
        return dormitories;
    }

    @Override
    public void insert(Dormitory dormitory){
        String query = "INSERT INTO mydb.dormitories(name, room, address) VALUES(?,?,?)";
        Connection connection = null;
        try{
            connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, dormitory.getName());
            preparedStatement.setInt(2, dormitory.getRoom());
            preparedStatement.setString(3, dormitory.getAddress());
            preparedStatement.execute();
        }
        catch (SQLException e){
            System.out.println("ERROR");
        }
    }

    @Override
    public void update(int index,Dormitory dormitory){
        Connection connection = null;
        String query = "UPDATE mydb.dormitories SET name=?, room=?, address=? WHERE id=?";
        try{
            connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, dormitory.getName());
            preparedStatement.setInt(2, dormitory.getRoom());
            preparedStatement.setString(3, dormitory.getAddress());
            preparedStatement.execute();
        } catch(SQLException e){
            System.out.println("ERROR");
        }
    }
    @Override
    public void delete(int index){
        Connection connection = null;
        String query = "DELETE FROM mydb.dormitories WHERE id=?";
        try{
            connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, index);
            preparedStatement.execute();
        } catch(SQLException e){
            System.out.println("ERROR");
        }
    }

}
