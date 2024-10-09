package Homework_SQL.dao.jdbc;

import Homework_SQL.BasicConnectionPool;
import Homework_SQL.dao.ICarDao;
import Homework_SQL.model.Car;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarDao implements ICarDao {

    static BasicConnectionPool connectionPool = BasicConnectionPool.create();


    @Override
    public Car getEntityById(int index) {
        Car car = new Car();
        Connection connection = null;
        try{
            connection = connectionPool.getConnection();
            String query = "SELECT * FROM mydb.cars WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, index);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                car.setModel(resultSet.getString("model"));
            }
        }
        catch (SQLException e){
            System.out.println("ERROR");
        }
        finally{
            connectionPool.releaseConnection(connection);
        }
        return car;
    }

    @Override
    public List<Car> getEntities() {
        List<Car> cars = new ArrayList<>();
        String query = "SELECT * FROM mydb.cars";
        Connection connection = null;

        try{
            connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                Car car = new Car(resultSet.getInt("id"), resultSet.getString("model"));
                cars.add(car);
            }
        } catch(SQLException e){
            System.out.println("ERROR");
        }
        return cars;
    }

    @Override
    public void insert(Car car) {
        String query = "INSERT INTO mydb.cars(model) VALUES(?)";
        Connection connection = null;
        try{
            connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, car.getModel());
            preparedStatement.execute();
        } catch (SQLException e){
            System.out.println("ERROR");
        }
    }

    @Override
    public void delete(int index) {
        String query = "DELETE FROM mydb.cars WHERE id =?";
        Connection connection = null;
        try{
            connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, index);
            preparedStatement.execute();
        } catch (SQLException e){
            System.out.println("ERROR");
        }
    }

    @Override
    public void update(int index, Car car) {
        String query = "UPDATE mydb.cars SET model =? WHERE id =?";
        Connection connection = null;
        try{
            connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, car.getModel());
            preparedStatement.setInt(2, index);
            preparedStatement.execute();
        } catch (SQLException e){
            System.out.println("ERROR");
        }
    }
}
