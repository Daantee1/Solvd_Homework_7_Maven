package Homework_SQL.model;

public class Car {

    private int id;
    private String model;

    public Car(int id, String model) {
        this.id = id;
        this.model = model;
    }
    public Car(){

    }

    public void setId(int id) {
        this.id = id;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                '}';
    }
}
