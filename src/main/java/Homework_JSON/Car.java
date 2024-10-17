package Homework_JSON;

import java.util.Date;

public class Car {
    private String brand;
    private int year;
    private Date date;

    public Car(String brand, int year, Date date) {
        this.brand = brand;
        this.year = year;
        this.date = date;
    }

    public Car() {
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", year=" + year +
                ", date=" + date +
                '}';
    }
}
