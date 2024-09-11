package Homework_9.Interfaces;

@FunctionalInterface
public interface IDivision<T extends Number> {
    T divide(T a, T b);
}
