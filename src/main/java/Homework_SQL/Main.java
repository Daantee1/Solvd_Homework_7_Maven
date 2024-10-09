package Homework_SQL;

import Homework_SQL.dao.ICarDao;
import Homework_SQL.dao.IDormitoryDao;
import Homework_SQL.dao.jdbc.CarDao;
import Homework_SQL.dao.jdbc.DormitoryDao;
import Homework_SQL.model.Car;
import Homework_SQL.model.Dormitory;

public class Main {
    public static void main(String[] args) {

        ICarDao carDao = new CarDao();
        System.out.println(carDao.getEntityById(1));
        Car car = new Car();
        car.setModel("Audi");
        carDao.insert(car);
        System.out.println(carDao.getEntities());

        Car carUpdated = new Car();
        carUpdated.setModel("Volvo");
        carDao.update(3, carUpdated);
        System.out.println(carDao.getEntities());
        carDao.delete(3);
        System.out.println(carDao.getEntities());

        IDormitoryDao dormitoryDao = new DormitoryDao();
        System.out.println(dormitoryDao.getEntityById(1));
        Dormitory dormitory2 = new Dormitory();
        dormitory2.setName("Pod bykiem");
        dormitory2.setRoom(505);
        dormitory2.setAddress("Czarnowiejska 2");
        dormitoryDao.insert(dormitory2);
        System.out.println(dormitoryDao.getEntities());




    }
}
