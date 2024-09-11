package Homework_9.Interfaces;

@FunctionalInterface
public interface IMultiplication <T extends Number> {

    T multiply(T a, T b);
}
